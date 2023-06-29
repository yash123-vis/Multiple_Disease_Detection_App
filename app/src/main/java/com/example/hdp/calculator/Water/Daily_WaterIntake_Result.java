package com.example.hdp.calculator.Water;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdp.R;

public class Daily_WaterIntake_Result extends AppCompatActivity {

    Bundle extras;
    ImageView iv_close;
    TextView tv_waterintake_result;
    Double water_intake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_water_intake_result);

        this.tv_waterintake_result = (TextView) findViewById(R.id.tv_waterintake_result);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.extras = getIntent().getExtras();
        this.water_intake = Double.valueOf(this.extras.getDouble("water_intake"));
        StringBuilder sb = new StringBuilder();
        sb.append("water_intake");
        sb.append(this.water_intake);
        Log.d("water_intake", sb.toString());
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        TextView textView = this.tv_waterintake_result;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(R.string.Daily_Water_Intake));
        sb3.append("  : %.0f");
        sb2.append(String.format(sb3.toString(), new Object[]{this.water_intake}));
        sb2.append("ml");
        textView.setText(sb2.toString());
        this.iv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Daily_WaterIntake_Result.this.onBackPressed();
            }
        });
    }
}