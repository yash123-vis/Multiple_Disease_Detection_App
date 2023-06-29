
package com.example.hdp.calculator.HeartRate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdp.R;

import java.io.PrintStream;

public class Heart_Rate_Result extends AppCompatActivity {

    ImageView iv_close;
    TextView tv_ans_heartrate;
    TextView tv_heartrate_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate_result);

        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.tv_ans_heartrate = (TextView) findViewById(R.id.tv_ans_heartrate);
        this.tv_heartrate_chart = (TextView) findViewById(R.id.tv_heartrate_chart);
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        TextView textView = this.tv_ans_heartrate;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.heart_rate));
        sb.append(String.valueOf(HeartRateActivity.HRmax));
        sb.append(" bpm");
        textView.setText(sb.toString());
        this.tv_heartrate_chart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int random = ((int) (Math.random() * 2.0d)) + 1;
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("random_number==>");
                sb.append(random);
                printStream.println(sb.toString());
                Heart_Rate_Result.this.startActivity(new Intent(Heart_Rate_Result.this, Heart_Rate_Chart.class));

//                Heart_Rate_Result.this.startActivity(new Intent(Heart_Rate_Result.this, Heart_Rate_Chart.class));
            }
        });
        this.iv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Heart_Rate_Result.this.onBackPressed();
            }
        });
    }
}