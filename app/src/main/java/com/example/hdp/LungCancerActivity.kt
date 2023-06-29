package com.example.hdp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.hdp.LungCancer.Bengin
import com.example.hdp.LungCancer.Malignant
import kotlinx.android.synthetic.main.activity_skin_activty.*
import java.io.IOException

class LungCancerActivity : AppCompatActivity() {

    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap

    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private val mInputSize = 224
    private val mModelPath = "lung_cancer_model.tflite"
    private val mLabelPath = "lung_cancer_label.txt"
    private val mSamplePath = "lung2.png"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lung_cancer)

        mClassifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)

        resources.assets.open(mSamplePath).use {
            mBitmap = BitmapFactory.decodeStream(it)
            mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
            mPhotoImageView.setImageBitmap(mBitmap)
        }

        mGalleryButton.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode)
            mDetectButton.alpha = 1.0f
            mGalleryButton.alpha = 0.0f
            b_text.alpha = 0.0f
        }
        mDetectButton.setOnClickListener {
            val results = mClassifier.recognizeImage(mBitmap).firstOrNull()
            mResultTextView.text= results?.title+"\n Confidence:"+results?.confidence

            advice_text.text = "Precautions for "+ results?.title
            linear.alpha = 1.0f
            refresh.alpha = 1.0f
            refresh.setOnClickListener {
                mPhotoImageView.setImageResource(R.drawable.lung)
                refresh.alpha = 0.0f
                mResultTextView.text = "Lung Cancer result will show here.."
                mResultTextView.setTextColor(Color.parseColor("#000000"))
                linear.alpha = 0.0f
                mDetectButton.alpha = 0.0f
                mGalleryButton.alpha = 1.0f
                b_text.alpha = 1.0f
            }
            mResultTextView.setTextColor(Color.parseColor("#0D29B5"))

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == mCameraRequestCode){
            //Considérons le cas de la caméra annulée
            if(resultCode == Activity.RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap = scaleImage(mBitmap)
                val toast = Toast.makeText(this, ("Image crop to: w= ${mBitmap.width} h= ${mBitmap.height}"), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.BOTTOM, 0, 20)
                toast.show()
                mPhotoImageView.setImageBitmap(mBitmap)
                mResultTextView.text= "Your photo image set now."
                mDetectButton.alpha = 1.0f
            } else {
                Toast.makeText(this, "Camera cancel..", Toast.LENGTH_LONG).show()
            }
        } else if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Success!!!")
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)

            }
        } else {
            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }


    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / orignalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }

    fun precaution(view: View) {
        val results = mClassifier.recognizeImage(mBitmap).firstOrNull()

        when (results?.title) {
            "Bengin" -> {
                val intent = Intent(this, Bengin::class.java)
                startActivity(intent)
            }
            "Malignant" -> {
                val intent = Intent(this, Malignant::class.java)
                startActivity(intent)
            }
            "Safe Lung" -> {
                Toast.makeText(this, "No need to worry about!! Still Take Care of Yourself.", Toast.LENGTH_LONG).show()
            }

            else -> {
                Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show()
            }
        }
    }

}