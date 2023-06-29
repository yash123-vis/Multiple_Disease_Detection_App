package com.example.hdp.calculator.Calorie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdp.R;

import java.io.PrintStream;

public class Calories_Burn_Result extends AppCompatActivity {

    float caloriesburn;
    Bundle extras;
    ImageView iv_close;
    String tips;
    TextView tv_ans_calburn;
    TextView tv_calburn;
    TextView tv_calburnchart;
    TextView tv_recomended;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_burn_result);

        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.tv_ans_calburn = (TextView) findViewById(R.id.tv_ans_calburn);
        this.tv_calburn = (TextView) findViewById(R.id.tv_calburn);
        this.tv_recomended = (TextView) findViewById(R.id.tv_recomended);
        this.tv_calburnchart = (TextView) findViewById(R.id.tv_calburnchart);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.extras = getIntent().getExtras();
        this.caloriesburn = this.extras.getFloat("caloriesburn");
        this.tips = this.extras.getString("tips");
        StringBuilder sb = new StringBuilder();
        sb.append("tips");
        sb.append(this.tips);
        Log.d("tips", sb.toString());
        try {
            TextView textView = this.tv_ans_calburn;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getString(R.string.Calories_burned));
            sb2.append(" : ");
            sb2.append(String.format("%.02f", new Object[]{Float.valueOf(this.caloriesburn)}));
            textView.setText(String.valueOf(sb2.toString()));
            this.tv_recomended.setText(String.valueOf(this.tips));
            this.tv_calburn.setText("");
        } catch (Exception unused) {
        }
        this.tv_calburnchart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int random = ((int) (Math.random() * 2.0d)) + 1;
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("random_number==>");
                sb.append(random);
                printStream.println(sb.toString());
                Calories_Burn_Result.this.startActivity(new Intent(Calories_Burn_Result.this, Calories_Burn_Chart.class));

//                Calories_Burn_Result.this.startActivity(new Intent(Calories_Burn_Result.this, Calories_Burn_Chart.class));
            }
        });
        this.iv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Calories_Burn_Result.this.onBackPressed();
            }
        });
    }
}