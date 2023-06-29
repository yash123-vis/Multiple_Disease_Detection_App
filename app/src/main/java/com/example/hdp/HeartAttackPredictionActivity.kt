package com.example.hdp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.hdp.ml.HeartDisease
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class HeartAttackPredictionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart_attack_prediction)

        var button : Button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {

            var ed1 : EditText = findViewById(R.id.editTextNumberDecimal)
            var ed2 : EditText = findViewById(R.id.editTextNumberDecimal2)
            var ed3 : EditText = findViewById(R.id.editTextNumberDecimal3)
            var ed4 : EditText = findViewById(R.id.editTextNumberDecimal4)

            var v1: Int = ed1.text.toString().toInt()
            var v2: Float = ed2.text.toString().toFloat()
            var v3: Float = ed3.text.toString().toFloat()
            var v4: Int = ed4.text.toString().toInt()



            var byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(4*4)
            byteBuffer.putInt(v1)
            byteBuffer.putFloat(v2)
            byteBuffer.putFloat(v3)
            byteBuffer.putInt(v4)



            val model = HeartDisease.newInstance(this)


            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 4), DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)

            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

            var tv : TextView = findViewById(R.id.textView)
            tv.alpha = 1.0f

            tv.setText("No possibility: " + (outputFeature0[0]* 100).toString()  + " %" + "\n" +
                    "Yes possibility: " + (outputFeature0[1]* 100).toString()  + " %"
            )

            model.close()
        })

    }
}