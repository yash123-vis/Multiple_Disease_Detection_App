package com.example.hdp.calculator.Chelosterol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.hdp.R;

import java.io.PrintStream;
import java.util.ArrayList;

public class CHActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter_cholestrol;
    ArrayList<String> arraylist_cholestrol = new ArrayList<>();
    EditText et_hdl;
    EditText et_ldl;
    EditText et_triglyceride;
    ListView listViewHeight;
    private PopupWindow popupWindowTime;
    TextView tv_cholestrol;
    TextView tv_hdl;
    TextView tv_ldl;
    TextView tv_search_cholestrol;
    TextView tv_triglyceride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chactivity);

        this.tv_hdl = (TextView) findViewById(R.id.tv_hdl);
        this.tv_ldl = (TextView) findViewById(R.id.tv_ldl);
        this.tv_triglyceride = (TextView) findViewById(R.id.tv_triglyceride);
        this.tv_search_cholestrol = (TextView) findViewById(R.id.tv_search_cholestrol);
        this.et_hdl = (EditText) findViewById(R.id.et_hdl);
        this.et_ldl = (EditText) findViewById(R.id.et_ldl);
        this.et_triglyceride = (EditText) findViewById(R.id.et_triglyceride);
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        this.tv_hdl.setOnClickListener(showPopupWindowTime(0));
        this.tv_ldl.setOnClickListener(showPopupWindowTime(1));
        this.tv_triglyceride.setOnClickListener(showPopupWindowTime(2));
        this.arraylist_cholestrol.clear();
        this.arraylist_cholestrol.add(getString(R.string.mgdl));
        this.arraylist_cholestrol.add(getString(R.string.mgol_a));
        this.adapter_cholestrol = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_cholestrol);

        this.tv_search_cholestrol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CHActivity.this.et_hdl.getText().toString().trim().equals("")) {
                    CHActivity.this.et_hdl.setError(CHActivity.this.getString(R.string.enter_hdl));
                } else if (CHActivity.this.et_ldl.getText().toString().trim().equals("")) {
                    CHActivity.this.et_ldl.setError(CHActivity.this.getString(R.string.enter_ldl));
                } else if (CHActivity.this.et_triglyceride.getText().toString().trim().equals("")) {
                    CHActivity.this.et_triglyceride.setError(CHActivity.this.getString(R.string.enter_triglyceride));
                } else {
                    int random = ((int) (Math.random() * 2.0d)) + 1;
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("random_number==>");
                    sb.append(random);
                    printStream.println(sb.toString());
                    CHActivity.this.calculate();

//                    else {
//                        CHActivity.this.calculate();
//                    }
                }
            }
        });

    }

    public void calculate() {
        float f;
        float f2;
        float f3;
        if (this.tv_hdl.getText().toString().trim().equals(getString(R.string.mgdl))) {
            f = Float.parseFloat(this.et_hdl.getText().toString().trim());
        } else {
            f = Float.parseFloat(this.et_hdl.getText().toString().trim()) * 18.0f;
        }
        if (this.tv_ldl.getText().toString().trim().equals(getString(R.string.mgdl))) {
            f2 = Float.parseFloat(this.et_ldl.getText().toString().trim());
        } else {
            f2 = Float.parseFloat(this.et_ldl.getText().toString().trim()) * 18.0f;
        }
        if (this.tv_triglyceride.getText().toString().trim().equals(getString(R.string.mgdl))) {
            f3 = Float.parseFloat(this.et_triglyceride.getText().toString().trim());
        } else {
            f3 = Float.parseFloat(this.et_triglyceride.getText().toString().trim()) * 18.0f;
        }
        double d = (double) (f + f2 + (f3 / 5.0f));
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(d);
        Log.d("cholestrol->", sb.toString());
        Intent intent = new Intent(this, Cholestrol_Result.class);
        intent.putExtra("cholestrol", d);
        startActivity(intent);
    }

    private View.OnClickListener showPopupWindowTime(final int i) {
        return new View.OnClickListener() {
            public void onClick(View view) {
                CHActivity.this.popupWindowTime(i).showAsDropDown(view, 0, 0);
            }
        };
    }


    @SuppressLint("ResourceType")
    public PopupWindow popupWindowTime(final int i) {
        this.popupWindowTime = new PopupWindow(this);
        this.listViewHeight = new ListView(this);
        this.listViewHeight.setDividerHeight(0);
        this.listViewHeight.setAdapter(this.adapter_cholestrol);
        this.listViewHeight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    CHActivity.this.tv_hdl.setText((CharSequence) CHActivity.this.arraylist_cholestrol.get(i));
                } else if (i == 1) {
                    CHActivity.this.tv_ldl.setText((CharSequence) CHActivity.this.arraylist_cholestrol.get(i));
                } else {
                    CHActivity.this.tv_triglyceride.setText((CharSequence) CHActivity.this.arraylist_cholestrol.get(i));
                }
                CHActivity.this.dismissPopupTime();
            }
        });
        this.popupWindowTime.setFocusable(true);
        this.popupWindowTime.setWidth(this.tv_hdl.getMeasuredWidth());
        this.popupWindowTime.setHeight(-2);
        this.popupWindowTime.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), 17170443));
        this.popupWindowTime.setContentView(this.listViewHeight);
        return this.popupWindowTime;
    }


    public void dismissPopupTime() {
        if (this.popupWindowTime != null) {
            this.popupWindowTime.dismiss();
        }
    }

    public void onBackPressed() {
//        this.adView.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }

}