package com.example.hdp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hdp.ml.BreastCancerDisease
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class BreastCancerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breast_cancer)

        var button : Button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {

            var ed1 : EditText = findViewById(R.id.editTextNumberDecimal)
            var ed2 : EditText = findViewById(R.id.editTextNumberDecimal2)
            var ed3 : EditText = findViewById(R.id.editTextNumberDecimal3)
            var ed4 : EditText = findViewById(R.id.editTextNumberDecimal4)
            var ed5 : EditText = findViewById(R.id.editTextNumberDecimal5)
            var ed6 : EditText = findViewById(R.id.editTextNumberDecimal6)
            var ed7 : EditText = findViewById(R.id.editTextNumberDecimal7)
            var ed8 : EditText = findViewById(R.id.editTextNumberDecimal8)
            var ed9 : EditText = findViewById(R.id.editTextNumberDecimal9)
            var ed10 : EditText = findViewById(R.id.editTextNumberDecimal10)

            var v1: Float = ed1.text.toString().toFloat()
            var v2: Float = ed2.text.toString().toFloat()
            var v3: Float = ed3.text.toString().toFloat()
            var v4: Float = ed4.text.toString().toFloat()
            var v5: Float = ed5.text.toString().toFloat()
            var v6: Float = ed6.text.toString().toFloat()
            var v7: Float = ed7.text.toString().toFloat()
            var v8: Float = ed8.text.toString().toFloat()
            var v9: Float = ed9.text.toString().toFloat()
            var v10: Float = ed10.text.toString().toFloat()



            var byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(10*4)
            byteBuffer.putFloat(v1)
            byteBuffer.putFloat(v2)
            byteBuffer.putFloat(v3)
            byteBuffer.putFloat(v4)
            byteBuffer.putFloat(v5)
            byteBuffer.putFloat(v6)
            byteBuffer.putFloat(v7)
            byteBuffer.putFloat(v8)
            byteBuffer.putFloat(v9)
            byteBuffer.putFloat(v10)



            val model = BreastCancerDisease.newInstance(this)


            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 10), DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)

            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

            var tv : TextView = findViewById(R.id.textView)
            tv.alpha = 1.0f

            tv.setText("Benign possibility: " + (outputFeature0[0]* 100).toString()  + " %" + "\n" +
                    "Malignant possibility: " + (outputFeature0[1]* 100).toString()  + " %"
            )

            model.close()
        })

    }
}