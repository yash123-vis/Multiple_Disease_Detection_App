package com.example.hdp.calculator.BloodVolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hdp.R;

public class BloodVolume_Result extends AppCompatActivity {

    //    AdView adView;
    double blood_volume;
    Bundle extras;
    ImageView iv_close;
    LinearLayout rl_main;
    TextView tv_ans_bmr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_volume_result);

//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.rl_main = (LinearLayout) findViewById(R.id.rl_main);
        this.extras = getIntent().getExtras();
        this.blood_volume = this.extras.getDouble("blood_volume");
        this.tv_ans_bmr = (TextView) findViewById(R.id.tv_ans_bmr);
//        this.rl_main.setBackgroundResource(R.drawable.popup_background_gradient6);
//        if (this.sharedPreferenceManager.get_Remove_Ad().booleanValue()) {
//            this.adView.setVisibility(8);
//        } else {
//            this.adView.setVisibility(0);
//            this.adView.loadAd(new Builder().build());
//            this.adView.setAdListener(new AdListener() {
//                public void onAdLoaded() {
//                    super.onAdLoaded();
//                    BloodVolume_Result.this.adView.setVisibility(0);
//                }
//
//                public void onAdFailedToLoad(int i) {
//                    super.onAdFailedToLoad(i);
//                    BloodVolume_Result.this.adView.setVisibility(8);
//                }
//            });
//        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.blood_volume);
        Log.d("bmr_val->", sb.toString());
        TextView textView = this.tv_ans_bmr;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(R.string.Your_bloodvolume_is));
        sb3.append(" :\n");
        sb3.append(String.format("%.02f", new Object[]{Double.valueOf(this.blood_volume)}));
        sb2.append(String.valueOf(sb3.toString()));
        sb2.append(" ");
        sb2.append(getString(R.string.liter));
        textView.setText(sb2.toString());
        this.iv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BloodVolume_Result.this.onBackPressed();
            }
        });
    }
}