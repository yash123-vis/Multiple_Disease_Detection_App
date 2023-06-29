package com.example.hdp.calculator.BP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hdp.R;

import java.io.PrintStream;

public class BPActivity extends AppCompatActivity {

    String diastolic_val;
    EditText et_diastolic_pressure;
    EditText et_systolic_pressure;
    ImageView iv_back;
    String systolic_val;
    TextView tv_bloodpressure;
    TextView tv_calculate_bloodpressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpactivity);

        this.et_systolic_pressure = (EditText) findViewById(R.id.et_systolic_pressure);
        this.et_diastolic_pressure = (EditText) findViewById(R.id.et_diastolic_pressure);
        this.tv_calculate_bloodpressure = (TextView) findViewById(R.id.tv_calculate_bloodpressure);
//        this.adView = (AdView) findViewById(R.id.adView);
//
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        this.tv_calculate_bloodpressure.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                if (BPActivity.this.et_systolic_pressure.getText().toString().trim().equals("") || BPActivity.this.et_systolic_pressure.getText().toString().trim().equals(".")) {
                    Toast.makeText(BPActivity.this.getApplicationContext(), BPActivity.this.getString(R.string.Enter_systolic_value), 0).show();
                } else if (BPActivity.this.et_diastolic_pressure.getText().toString().trim().equals("") || BPActivity.this.et_diastolic_pressure.getText().toString().trim().equals(".")) {
                    Toast.makeText(BPActivity.this.getApplicationContext(), BPActivity.this.getString(R.string.Enter_diastolic_value), 0).show();
                } else {
                    BPActivity.this.systolic_val = BPActivity.this.et_systolic_pressure.getText().toString().trim();
                    BPActivity.this.diastolic_val = BPActivity.this.et_diastolic_pressure.getText().toString().trim();
                    int random = ((int) (Math.random() * 2.0d)) + 1;
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("random_number==>");
                    sb.append(random);
                    printStream.println(sb.toString());
                    Intent intent = new Intent(BPActivity.this, BloodPressure_Result.class);
                    intent.putExtra("systolic_val", Float.parseFloat(BPActivity.this.systolic_val));
                    intent.putExtra("diastolic_val", Float.parseFloat(BPActivity.this.diastolic_val));
                    BPActivity.this.startActivity(intent);

//                    Intent intent = new Intent(BloodPressure_Calculator.this, BloodPressure_Result.class);
//                    intent.putExtra("systolic_val", Float.parseFloat(BloodPressure_Calculator.this.systolic_val));
//                    intent.putExtra("diastolic_val", Float.parseFloat(BloodPressure_Calculator.this.diastolic_val));
//                    BloodPressure_Calculator.this.startActivity(intent);
                }
            }
        });


    }
    public void onBackPressed() {
//        this.adView.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }
}