package com.example.hdp.calculator.BMR;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hdp.R;

public class BMR_Result extends AppCompatActivity {

    double bmr;
    Bundle extras;
    String from = "";
    ImageView iv_close;
    LinearLayout rl_main;
    TextView tv_ans_bmr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_result);

//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.rl_main = (LinearLayout) findViewById(R.id.rl_main);
        this.extras = getIntent().getExtras();
        this.bmr = this.extras.getDouble("bmr");
        this.from = this.extras.getString("from", "");
//        if (this.sharedPreferenceManager.get_Remove_Ad().booleanValue()) {
//            this.adView.setVisibility(8);
//        } else {
//            this.adView.setVisibility(0);
//            this.adView.loadAd(new Builder().build());
//            this.adView.setAdListener(new AdListener() {
//                public void onAdLoaded() {
//                    super.onAdLoaded();
//                    BMR_Result.this.adView.setVisibility(0);
//                }
//
//                public void onAdFailedToLoad(int i) {
//                    super.onAdFailedToLoad(i);
//                    BMR_Result.this.adView.setVisibility(8);
//                }
//            });
//        }
        this.tv_ans_bmr = (TextView) findViewById(R.id.tv_ans_bmr);
        if (this.from.equals("bmr")) {
//            this.rl_main.setBackgroundResource(R.drawable.popup_background_gradient1);
        } else {
//            this.rl_main.setBackgroundResource(R.drawable.popup_background_gradient7);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.bmr);
        Log.d("bmr_val->", sb.toString());
        if (this.from.equals("bmr")) {
            TextView textView = this.tv_ans_bmr;
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getString(R.string.Your_BMR_is));
            sb3.append(" :  \n");
            sb3.append(String.format("%.0f", new Object[]{Double.valueOf(this.bmr)}));
            sb2.append(String.valueOf(sb3.toString()));
            sb2.append(" ");
            sb2.append(getString(R.string.cal_per_day));
            textView.setText(sb2.toString());
        } else {
            TextView textView2 = this.tv_ans_bmr;
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getString(R.string.Your_RMR_is));
            sb5.append(" :  \n");
            sb5.append(String.format("%.0f", new Object[]{Double.valueOf(this.bmr)}));
            sb4.append(String.valueOf(sb5.toString()));
            sb4.append(" ");
            sb4.append(getString(R.string.cal_per_day));
            textView2.setText(sb4.toString());
        }
        this.iv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BMR_Result.this.onBackPressed();
            }
        });
    }
}