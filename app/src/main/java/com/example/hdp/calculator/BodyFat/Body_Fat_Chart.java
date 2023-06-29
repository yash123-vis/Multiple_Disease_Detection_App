package com.example.hdp.calculator.BodyFat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hdp.R;

public class Body_Fat_Chart extends AppCompatActivity {

    TextView tv_acceptable;
    TextView tv_acceptable_man;
    TextView tv_acceptable_woman;
    TextView tv_athletes;
    TextView tv_athletes_man;
    TextView tv_athletes_woman;
    TextView tv_avg_fat;
    TextView tv_avg_fat_man;
    TextView tv_avg_fat_woman;
    TextView tv_bodayfat_classification;
    TextView tv_bodayfat_classification_man;
    TextView tv_bodayfat_classification_woman;
    TextView tv_bodayfat_percentage;
    TextView tv_bodyfat;
    TextView tv_essential_fat;
    TextView tv_essential_fat_man;
    TextView tv_essential_fat_woman;
    TextView tv_fat_level;
    TextView tv_fitness;
    TextView tv_fitness_man;
    TextView tv_fitness_woman;
    TextView tv_high_fat;
    TextView tv_high_fat_man;
    TextView tv_high_fat_woman;
    TextView tv_low_fat;
    TextView tv_low_fat_man;
    TextView tv_low_fat_woman;
    TextView tv_men_fatlevel;
    TextView tv_title;
    TextView tv_vhigh_fat;
    TextView tv_vhigh_fat_man;
    TextView tv_vhigh_fat_woman;
    TextView tv_vlow_fat;
    TextView tv_vlow_fat_man;
    TextView tv_vlow_fat_woman;
    TextView tv_women_fatlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat_chart);

//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.tv_bodyfat = (TextView) findViewById(R.id.tv_bodyfat);
        this.tv_fat_level = (TextView) findViewById(R.id.tv_fat_level);
        this.tv_men_fatlevel = (TextView) findViewById(R.id.tv_men_fatlevel);
        this.tv_women_fatlevel = (TextView) findViewById(R.id.tv_women_fatlevel);
        this.tv_vlow_fat = (TextView) findViewById(R.id.tv_vlow_fat);
        this.tv_vlow_fat_man = (TextView) findViewById(R.id.tv_vlow_fat_man);
        this.tv_vlow_fat_woman = (TextView) findViewById(R.id.tv_vlow_fat_woman);
        this.tv_low_fat = (TextView) findViewById(R.id.tv_low_fat);
        this.tv_low_fat_man = (TextView) findViewById(R.id.tv_low_fat_man);
        this.tv_low_fat_woman = (TextView) findViewById(R.id.tv_low_fat_woman);
        this.tv_avg_fat = (TextView) findViewById(R.id.tv_avg_fat);
        this.tv_avg_fat_man = (TextView) findViewById(R.id.tv_avg_fat_man);
        this.tv_avg_fat_woman = (TextView) findViewById(R.id.tv_avg_fat_woman);
        this.tv_high_fat = (TextView) findViewById(R.id.tv_high_fat);
        this.tv_high_fat_man = (TextView) findViewById(R.id.tv_high_fat_man);
        this.tv_high_fat_woman = (TextView) findViewById(R.id.tv_high_fat_woman);
        this.tv_vhigh_fat = (TextView) findViewById(R.id.tv_vhigh_fat);
        this.tv_vhigh_fat_man = (TextView) findViewById(R.id.tv_vhigh_fat_man);
        this.tv_vhigh_fat_woman = (TextView) findViewById(R.id.tv_vhigh_fat_woman);
        this.tv_bodayfat_percentage = (TextView) findViewById(R.id.tv_bodayfat_percentage);
        this.tv_bodayfat_classification = (TextView) findViewById(R.id.tv_bodayfat_classification);
        this.tv_bodayfat_classification_man = (TextView) findViewById(R.id.tv_bodayfat_classification_man);
        this.tv_bodayfat_classification_woman = (TextView) findViewById(R.id.tv_bodayfat_classification_woman);
        this.tv_essential_fat = (TextView) findViewById(R.id.tv_essential_fat);
        this.tv_essential_fat_man = (TextView) findViewById(R.id.tv_essential_fat_man);
        this.tv_essential_fat_woman = (TextView) findViewById(R.id.tv_essential_fat_woman);
        this.tv_athletes = (TextView) findViewById(R.id.tv_athletes);
        this.tv_athletes_man = (TextView) findViewById(R.id.tv_athletes_man);
        this.tv_athletes_woman = (TextView) findViewById(R.id.tv_athletes_woman);
        this.tv_fitness = (TextView) findViewById(R.id.tv_fitness);
        this.tv_fitness_man = (TextView) findViewById(R.id.tv_fitness_man);
        this.tv_fitness_woman = (TextView) findViewById(R.id.tv_fitness_woman);
        this.tv_acceptable = (TextView) findViewById(R.id.tv_acceptable);
        this.tv_acceptable_man = (TextView) findViewById(R.id.tv_acceptable_man);
        this.tv_acceptable_woman = (TextView) findViewById(R.id.tv_acceptable_woman);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}