package com.example.hdp.calculator.HeartRate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hdp.R;

public class Heart_Rate_Chart extends AppCompatActivity {

    TextView tv_50;
    TextView tv_55;
    TextView tv_60;
    TextView tv_65;
    TextView tv_70;
    TextView tv_75;
    TextView tv_80;
    TextView tv_85;
    TextView tv_90;
    TextView tv_95;
    TextView tv_heart_rate;
    TextView tv_heartrate_cal;
    TextView tv_hr;
    TextView tv_hr1;
    TextView tv_hr10;
    TextView tv_hr2;
    TextView tv_hr3;
    TextView tv_hr4;
    TextView tv_hr5;
    TextView tv_hr50;
    TextView tv_hr55;
    TextView tv_hr6;
    TextView tv_hr60;
    TextView tv_hr65;
    TextView tv_hr7;
    TextView tv_hr70;
    TextView tv_hr75;
    TextView tv_hr8;
    TextView tv_hr80;
    TextView tv_hr85;
    TextView tv_hr9;
    TextView tv_hr90;
    TextView tv_hr95;
    TextView tv_intensity;
    TextView tv_intensity1;
    TextView tv_targethr;
    TextView tv_targethr1;
    TextView tv_targethr10;
    TextView tv_targethr2;
    TextView tv_targethr3;
    TextView tv_targethr4;
    TextView tv_targethr5;
    TextView tv_targethr6;
    TextView tv_targethr7;
    TextView tv_targethr8;
    TextView tv_targethr9;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate_chart);

        this.tv_intensity1 = (TextView) findViewById(R.id.tv_intensity1);
        this.tv_heart_rate = (TextView) findViewById(R.id.tv_heart_rate);
        this.tv_hr1 = (TextView) findViewById(R.id.tv_hr1);
        this.tv_hr2 = (TextView) findViewById(R.id.tv_hr2);
        this.tv_hr3 = (TextView) findViewById(R.id.tv_hr3);
        this.tv_hr4 = (TextView) findViewById(R.id.tv_hr4);
        this.tv_hr5 = (TextView) findViewById(R.id.tv_hr5);
        this.tv_hr6 = (TextView) findViewById(R.id.tv_hr6);
        this.tv_hr7 = (TextView) findViewById(R.id.tv_hr7);
        this.tv_hr8 = (TextView) findViewById(R.id.tv_hr8);
        this.tv_hr9 = (TextView) findViewById(R.id.tv_hr9);
        this.tv_hr10 = (TextView) findViewById(R.id.tv_hr10);
        this.tv_50 = (TextView) findViewById(R.id.tv_50);
        this.tv_55 = (TextView) findViewById(R.id.tv_55);
        this.tv_60 = (TextView) findViewById(R.id.tv_60);
        this.tv_65 = (TextView) findViewById(R.id.tv_65);
        this.tv_70 = (TextView) findViewById(R.id.tv_70);
        this.tv_75 = (TextView) findViewById(R.id.tv_75);
        this.tv_80 = (TextView) findViewById(R.id.tv_80);
        this.tv_85 = (TextView) findViewById(R.id.tv_85);
        this.tv_90 = (TextView) findViewById(R.id.tv_90);
        this.tv_95 = (TextView) findViewById(R.id.tv_95);
        this.tv_heartrate_cal = (TextView) findViewById(R.id.tv_heartrate_cal);
        this.tv_targethr = (TextView) findViewById(R.id.tv_targethr);
        this.tv_intensity = (TextView) findViewById(R.id.tv_intensity);
        this.tv_hr = (TextView) findViewById(R.id.tv_hr);
        this.tv_targethr1 = (TextView) findViewById(R.id.tv_targethr1);
        this.tv_targethr2 = (TextView) findViewById(R.id.tv_targethr2);
        this.tv_targethr3 = (TextView) findViewById(R.id.tv_targethr3);
        this.tv_targethr4 = (TextView) findViewById(R.id.tv_targethr4);
        this.tv_targethr5 = (TextView) findViewById(R.id.tv_targethr5);
        this.tv_targethr6 = (TextView) findViewById(R.id.tv_targethr6);
        this.tv_targethr7 = (TextView) findViewById(R.id.tv_targethr7);
        this.tv_targethr8 = (TextView) findViewById(R.id.tv_targethr8);
        this.tv_targethr9 = (TextView) findViewById(R.id.tv_targethr9);
        this.tv_targethr10 = (TextView) findViewById(R.id.tv_targethr10);
        this.tv_hr50 = (TextView) findViewById(R.id.tv_hr50);
        this.tv_hr55 = (TextView) findViewById(R.id.tv_hr55);
        this.tv_hr60 = (TextView) findViewById(R.id.tv_hr60);
        this.tv_hr65 = (TextView) findViewById(R.id.tv_hr65);
        this.tv_hr70 = (TextView) findViewById(R.id.tv_hr70);
        this.tv_hr75 = (TextView) findViewById(R.id.tv_hr75);
        this.tv_hr80 = (TextView) findViewById(R.id.tv_hr80);
        this.tv_hr85 = (TextView) findViewById(R.id.tv_hr85);
        this.tv_hr90 = (TextView) findViewById(R.id.tv_hr90);
        this.tv_hr95 = (TextView) findViewById(R.id.tv_hr95);
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//        if (this.sharedPreferenceManager.get_Remove_Ad().booleanValue()) {
//            this.adView.setVisibility(8);
//        } else {
//            this.adView.setVisibility(0);
//            this.adView.loadAd(new Builder().build());
//            this.adView.setAdListener(new AdListener() {
//                public void onAdLoaded() {
//                    super.onAdLoaded();
//                    Heart_Rate_Chart.this.adView.setVisibility(0);
//                }
//
//                public void onAdFailedToLoad(int i) {
//                    super.onAdFailedToLoad(i);
//                    Heart_Rate_Chart.this.adView.setVisibility(8);
//                }
//            });
//        }

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        this.tv_hr1.setText(String.valueOf((int) HeartRateActivity.lower_rate1));
        this.tv_hr2.setText(String.valueOf((int) HeartRateActivity.lower_rate2));
        this.tv_hr3.setText(String.valueOf((int) HeartRateActivity.lower_rate3));
        this.tv_hr4.setText(String.valueOf((int) HeartRateActivity.lower_rate4));
        this.tv_hr5.setText(String.valueOf((int) HeartRateActivity.lower_rate5));
        this.tv_hr6.setText(String.valueOf((int) HeartRateActivity.lower_rate6));
        this.tv_hr7.setText(String.valueOf((int) HeartRateActivity.lower_rate7));
        this.tv_hr8.setText(String.valueOf((int) HeartRateActivity.lower_rate8));
        this.tv_hr9.setText(String.valueOf((int) HeartRateActivity.lower_rate9));
        this.tv_hr10.setText(String.valueOf((int) HeartRateActivity.lower_rate10));
        this.tv_targethr1.setText(String.valueOf((int) HeartRateActivity.target_heart_rate50));
        this.tv_targethr2.setText(String.valueOf((int) HeartRateActivity.target_heart_rate55));
        this.tv_targethr3.setText(String.valueOf((int) HeartRateActivity.target_heart_rate60));
        this.tv_targethr4.setText(String.valueOf((int) HeartRateActivity.target_heart_rate65));
        this.tv_targethr5.setText(String.valueOf((int) HeartRateActivity.target_heart_rate70));
        this.tv_targethr6.setText(String.valueOf((int) HeartRateActivity.target_heart_rate75));
        this.tv_targethr7.setText(String.valueOf((int) HeartRateActivity.target_heart_rate80));
        this.tv_targethr8.setText(String.valueOf((int) HeartRateActivity.target_heart_rate85));
        this.tv_targethr9.setText(String.valueOf((int) HeartRateActivity.target_heart_rate90));
        this.tv_targethr10.setText(String.valueOf((int) HeartRateActivity.target_heart_rate95));
        
    }
}