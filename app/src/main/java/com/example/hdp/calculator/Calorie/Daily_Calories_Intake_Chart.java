package com.example.hdp.calculator.Calorie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdp.R;

public class Daily_Calories_Intake_Chart extends AppCompatActivity {

    TextView active1;
    //    AdView adView;
    TextView age1;
    Bundle extras;
    int gain;
    ImageView iv_back;
    int lose;
    int maintain;
    TextView tv_Active;
    TextView tv_age;
    TextView tv_cal_require;
    TextView tv_curr_weight;
    TextView tv_gain;
    TextView tv_gain_weight;
    TextView tv_lose;
    TextView tv_lose_weight;
    TextView tv_lowactivity;
    TextView tv_lowactivity1;
    TextView tv_maintain;
    TextView tv_sedentary;
    TextView tv_sedentary1;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_calories_intake_chart);

        this.tv_maintain = (TextView) findViewById(R.id.tv_maintain);
        this.tv_gain = (TextView) findViewById(R.id.tv_gain);
        this.tv_lose = (TextView) findViewById(R.id.tv_lose);
        this.tv_curr_weight = (TextView) findViewById(R.id.tv_curr_weight);
        this.tv_lose_weight = (TextView) findViewById(R.id.tv_lose_weight);
        this.tv_gain_weight = (TextView) findViewById(R.id.tv_gain_weight);
        this.tv_cal_require = (TextView) findViewById(R.id.tv_cal_require);
        this.tv_age = (TextView) findViewById(R.id.tv_age);
        this.tv_sedentary = (TextView) findViewById(R.id.tv_sedentary);
        this.tv_lowactivity = (TextView) findViewById(R.id.tv_lowactivity);
        this.tv_Active = (TextView) findViewById(R.id.tv_Active);
        this.age1 = (TextView) findViewById(R.id.age1);
        this.tv_sedentary1 = (TextView) findViewById(R.id.tv_sedentary1);
        this.tv_lowactivity1 = (TextView) findViewById(R.id.tv_lowactivity1);
        this.active1 = (TextView) findViewById(R.id.active1);
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }

        this.extras = getIntent().getExtras();
        this.maintain = this.extras.getInt("maintain");
        this.gain = this.extras.getInt("gain");
        this.lose = this.extras.getInt("lose");
        TextView textView = this.tv_maintain;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.You_need));
        sb.append(" ");
        sb.append(String.valueOf(this.maintain));
        sb.append(" ");
        sb.append(getString(R.string.Calories_per_day));
        textView.setText(sb.toString());
        TextView textView2 = this.tv_gain;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.You_need));
        sb2.append(" ");
        sb2.append(String.valueOf(this.gain));
        sb2.append(" ");
        sb2.append(getString(R.string.Calories_per_day_will_cause_you_to_gain_one_pound_a_week));
        textView2.setText(sb2.toString());
        TextView textView3 = this.tv_lose;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(R.string.You_need));
        sb3.append(" ");
        sb3.append(String.valueOf(this.lose));
        sb3.append(" ");
        sb3.append(getString(R.string.Calories_per_day_will_cause_you_to_Lose_one_pound_a_week));
        textView3.setText(sb3.toString());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}