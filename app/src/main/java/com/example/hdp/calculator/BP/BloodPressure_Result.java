package com.example.hdp.calculator.BP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdp.R;

import java.io.PrintStream;

public class BloodPressure_Result extends AppCompatActivity {

    String diastolic_result;
    Float diastolic_val;
    Bundle extras;
    ImageView iv_close;
    String syastolic_result;
    Float systolic_val;
    TextView tv_bloodpressure_chart;
    TextView tv_diastolic_ans;
    TextView tv_systolic_ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_result);

        this.tv_systolic_ans = (TextView) findViewById(R.id.tv_systolic_ans);
        this.tv_diastolic_ans = (TextView) findViewById(R.id.tv_diastolic_ans);
        this.tv_bloodpressure_chart = (TextView) findViewById(R.id.tv_bloodpressure_chart);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.extras = getIntent().getExtras();
        this.systolic_val = Float.valueOf(this.extras.getFloat("systolic_val"));
        this.diastolic_val = Float.valueOf(this.extras.getFloat("diastolic_val"));

        if (this.systolic_val.floatValue() < 120.0f) {
            this.syastolic_result = getString(R.string.Normal_Blood_Pressure);
        } else if (this.systolic_val.floatValue() >= 120.0f && this.systolic_val.floatValue() <= 139.0f) {
            this.syastolic_result = getString(R.string.Prehypertension);
        } else if (this.systolic_val.floatValue() >= 140.0f && this.systolic_val.floatValue() <= 159.0f) {
            this.syastolic_result = getString(R.string.High_Blood_Pressure_Stage_1);
        } else if (this.systolic_val.floatValue() >= 160.0f && this.systolic_val.floatValue() <= 180.0f) {
            this.syastolic_result = getString(R.string.High_Blood_Pressure_Stage_2);
        } else if (this.systolic_val.floatValue() > 180.0f) {
            this.syastolic_result = getString(R.string.Hypertensive_Crisis_Emergency_care_needed);
        }
        if (this.diastolic_val.floatValue() < 80.0f) {
            this.diastolic_result = getString(R.string.Normal_Blood_Pressure);
        } else if (this.diastolic_val.floatValue() >= 80.0f && this.diastolic_val.floatValue() <= 89.0f) {
            this.diastolic_result = getString(R.string.Prehypertension);
        } else if (this.diastolic_val.floatValue() >= 90.0f && this.diastolic_val.floatValue() <= 99.0f) {
            this.diastolic_result = getString(R.string.High_Blood_Pressure_Stage_1);
        } else if (this.diastolic_val.floatValue() >= 100.0f && this.diastolic_val.floatValue() <= 110.0f) {
            this.diastolic_result = getString(R.string.High_Blood_Pressure_Stage_2);
        } else if (this.diastolic_val.floatValue() > 110.0f) {
            this.diastolic_result = getString(R.string.Hypertensive_Crisis_Emergency_care_needed);
        }
        TextView textView = this.tv_systolic_ans;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.upper_result));
        sb.append("\n");
        sb.append(this.syastolic_result);
        textView.setText(sb.toString());
        TextView textView2 = this.tv_diastolic_ans;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.lower_result));
        sb2.append("\n");
        sb2.append(this.diastolic_result);
        textView2.setText(sb2.toString());
        this.tv_bloodpressure_chart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int random = ((int) (Math.random() * 2.0d)) + 1;
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("random_number==>");
                sb.append(random);
                printStream.println(sb.toString());
                BloodPressure_Result.this.startActivity(new Intent(BloodPressure_Result.this, Bloodpressure_Chart.class));

//                BloodPressure_Result.this.startActivity(new Intent(BloodPressure_Result.this, Bloodpressure_Chart.class));
            }
        });

    }
}