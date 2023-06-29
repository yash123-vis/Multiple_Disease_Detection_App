package com.example.hdp.calculator.BMI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdp.R;

public class BMI_Chart extends AppCompatActivity {

    ImageView iv_back;
    TextView tv_age_17;
    TextView tv_age_17ext_obese;
    TextView tv_age_17ext_obese_val;
    TextView tv_age_17obese;
    TextView tv_age_17obese_val;
    TextView tv_age_17overweight;
    TextView tv_age_17overweight_val;
    TextView tv_age_17recomonded;
    TextView tv_age_17recomonded_val;
    TextView tv_agegroup35;
    TextView tv_agegroup35_ext_obese;
    TextView tv_agegroup35_ext_obese_val;
    TextView tv_agegroup35_obese;
    TextView tv_agegroup35_obese_val;
    TextView tv_agegroup35_overweight;
    TextView tv_agegroup35_overweight_val;
    TextView tv_agegroup35_recommended;
    TextView tv_agegroup35_recommended_val;
    TextView tv_agegroup45;
    TextView tv_agegroup45_ext_obese;
    TextView tv_agegroup45_ext_obese_val;
    TextView tv_agegroup45_obese;
    TextView tv_agegroup45_obese_val;
    TextView tv_agegroup45_overweight;
    TextView tv_agegroup45_overweight_val;
    TextView tv_agegroup45_recommended;
    TextView tv_agegroup45_recommended_val;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_chart);

        this.tv_age_17 = (TextView) findViewById(R.id.tv_age_17);
        this.tv_age_17recomonded = (TextView) findViewById(R.id.tv_age_17recomonded);
        this.tv_age_17recomonded_val = (TextView) findViewById(R.id.tv_age_17recomonded_val);
        this.tv_age_17overweight = (TextView) findViewById(R.id.tv_age_17overweight);
        this.tv_age_17overweight_val = (TextView) findViewById(R.id.tv_age_17overweight_val);
        this.tv_age_17obese = (TextView) findViewById(R.id.tv_age_17obese);
        this.tv_age_17obese_val = (TextView) findViewById(R.id.tv_age_17obese_val);
        this.tv_age_17ext_obese = (TextView) findViewById(R.id.tv_age_17ext_obese);
        this.tv_age_17ext_obese_val = (TextView) findViewById(R.id.tv_age_17ext_obese_val);
        this.tv_agegroup35 = (TextView) findViewById(R.id.tv_agegroup35);
        this.tv_agegroup35_recommended = (TextView) findViewById(R.id.tv_agegroup35_recommended);
        this.tv_agegroup35_recommended_val = (TextView) findViewById(R.id.tv_agegroup35_recommended_val);
        this.tv_agegroup35_overweight = (TextView) findViewById(R.id.tv_agegroup35_overweight);
        this.tv_agegroup35_overweight_val = (TextView) findViewById(R.id.tv_agegroup35_overweight_val);
        this.tv_agegroup35_obese = (TextView) findViewById(R.id.tv_agegroup35_obese);
        this.tv_agegroup35_obese_val = (TextView) findViewById(R.id.tv_agegroup35_obese_val);
        this.tv_agegroup35_ext_obese = (TextView) findViewById(R.id.tv_agegroup35_ext_obese);
        this.tv_agegroup35_ext_obese_val = (TextView) findViewById(R.id.tv_agegroup35_ext_obese_val);
        this.tv_agegroup45 = (TextView) findViewById(R.id.tv_agegroup45);
        this.tv_agegroup45_recommended = (TextView) findViewById(R.id.tv_agegroup45_recommended);
        this.tv_agegroup45_recommended_val = (TextView) findViewById(R.id.tv_agegroup45_recommended_val);
        this.tv_agegroup45_overweight = (TextView) findViewById(R.id.tv_agegroup45_overweight);
        this.tv_agegroup45_overweight_val = (TextView) findViewById(R.id.tv_agegroup45_overweight_val);
        this.tv_agegroup45_obese = (TextView) findViewById(R.id.tv_agegroup45_obese);
        this.tv_agegroup45_obese_val = (TextView) findViewById(R.id.tv_agegroup45_obese_val);
        this.tv_agegroup45_ext_obese = (TextView) findViewById(R.id.tv_agegroup45_ext_obese);
        this.tv_agegroup45_ext_obese_val = (TextView) findViewById(R.id.tv_agegroup45_ext_obese_val);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
    }
}