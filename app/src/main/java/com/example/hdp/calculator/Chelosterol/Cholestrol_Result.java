package com.example.hdp.calculator.Chelosterol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hdp.R;

public class Cholestrol_Result extends AppCompatActivity {

    double cholestrol;
    Bundle extras;
    ImageView iv_close;
    LinearLayout rl_main;
    TextView tv_ans_bmr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cholestrol_result);

        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.rl_main = (LinearLayout) findViewById(R.id.rl_main);
//        this.rl_main.setBackgroundResource(R.drawable.popup_background_gradient7);
        this.extras = getIntent().getExtras();
        this.cholestrol = this.extras.getDouble("cholestrol");
        this.tv_ans_bmr = (TextView) findViewById(R.id.tv_ans_bmr);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.cholestrol);
        Log.d("cholestrol->", sb.toString());
        TextView textView = this.tv_ans_bmr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.your_cholestrol));
        sb2.append(" : ");
        sb2.append(String.format("%.0f", new Object[]{Double.valueOf(this.cholestrol)}));
        textView.setText(String.valueOf(sb2.toString()));
        this.iv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Cholestrol_Result.this.onBackPressed();
            }
        });
    }
}