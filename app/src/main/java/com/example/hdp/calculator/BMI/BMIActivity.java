package com.example.hdp.calculator.BMI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.hdp.R;

import java.io.PrintStream;
import java.util.ArrayList;

public class BMIActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter_height;
    ArrayAdapter<String> adapter_weight;
    int age;
    ArrayList<String> arraylist_height = new ArrayList<>();
    ArrayList<String> arraylist_weigth = new ArrayList<>();
    float bmi;
    float bmi_height;
    float bmi_weight;
    EditText et_age;
    EditText et_height;
    EditText et_weight;
    String height_unit;
    float inserted_height;
    float inserted_weight;
    ImageView iv_back;
    ListView listViewHeight;
    ListView listViewWeight;
    private PopupWindow popupWindowHeight;
    private PopupWindow popupWindowWeight;
    TextView tv_bmi;
    TextView tv_heightunit;
    TextView tv_search_bmi;
    TextView tv_weightunit;
    String weight_unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.et_height = (EditText) findViewById(R.id.et_height);
        this.et_weight = (EditText) findViewById(R.id.et_weight);
        this.et_age = (EditText) findViewById(R.id.et_age);
        this.tv_heightunit = (TextView) findViewById(R.id.tv_heightunit);
        this.tv_weightunit = (TextView) findViewById(R.id.tv_weightunit);
        this.tv_search_bmi = (TextView) findViewById(R.id.tv_search_bmi);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        this.height_unit = getString(R.string.feet);
        this.weight_unit = getString(R.string.lbs);
        this.tv_heightunit.setOnClickListener(showPopupWindowHeight());
        this.tv_weightunit.setOnClickListener(showPopupWindow_Weight());
        this.arraylist_height.clear();
        this.arraylist_height.add(getString(R.string.feet));
        this.arraylist_height.add(getString(R.string.cm));
        this.arraylist_weigth.clear();
        this.arraylist_weigth.add(getString(R.string.kg));
        this.arraylist_weigth.add(getString(R.string.lbs));
        this.adapter_height = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_height);
        this.adapter_weight = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_weigth);
        this.tv_search_bmi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BMIActivity.this.et_age.getText().toString().trim().equals("")) {
                    BMIActivity.this.et_age.setError(BMIActivity.this.getString(R.string.Enter_Age));
                } else if (BMIActivity.this.et_height.getText().toString().trim().equals("") || BMIActivity.this.et_height.getText().toString().trim().equals(".")) {
                    BMIActivity.this.et_height.setError(BMIActivity.this.getString(R.string.Enter_Height));
                } else if (BMIActivity.this.et_weight.getText().toString().trim().equals("") || BMIActivity.this.et_weight.getText().toString().trim().equals(".")) {
                    BMIActivity.this.et_weight.setError(BMIActivity.this.getString(R.string.Enter_Weight));
                } else {
                    BMIActivity.this.height_unit = BMIActivity.this.tv_heightunit.getText().toString();
                    BMIActivity.this.weight_unit = BMIActivity.this.tv_weightunit.getText().toString();
                    BMIActivity.this.inserted_weight = Float.parseFloat(BMIActivity.this.et_weight.getText().toString());
                    BMIActivity.this.inserted_height = Float.parseFloat(BMIActivity.this.et_height.getText().toString());
                    BMIActivity.this.age = Integer.parseInt(BMIActivity.this.et_age.getText().toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append("inserted_weight");
                    sb.append(BMIActivity.this.inserted_weight);
                    Log.d("inserted_weight", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("inserted_height");
                    sb2.append(BMIActivity.this.inserted_height);
                    Log.d("inserted_height", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("age");
                    sb3.append(BMIActivity.this.age);
                    Log.d("age", sb3.toString());
                    int random = ((int) (Math.random() * 2.0d)) + 1;
                    PrintStream printStream = System.out;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("random_number==>");
                    sb4.append(random);
                    printStream.println(sb4.toString());
                    BMIActivity.this.calculate();
//                    if (random == 1) {
//                        BMIActivity.this.calculate();
//                    }
//                    else {
//                        BMI_Calculator.this.calculate();
//                    }
                }
            }
        });
    }

    private View.OnClickListener showPopupWindowHeight() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                BMIActivity.this.popupWindowHeight().showAsDropDown(view, 0, 0);
            }
        };
    }


    @SuppressLint("ResourceType")
    public PopupWindow popupWindowHeight() {
        this.popupWindowHeight = new PopupWindow(this);
        this.listViewHeight = new ListView(this);
        this.listViewHeight.setDividerHeight(0);
        this.listViewHeight.setAdapter(this.adapter_height);
        this.listViewHeight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BMIActivity.this.tv_heightunit.setText((CharSequence) BMIActivity.this.arraylist_height.get(i));
                BMIActivity.this.dismissPopupHeight();
            }
        });
        this.popupWindowHeight.setFocusable(true);
        this.popupWindowHeight.setWidth(this.tv_heightunit.getMeasuredWidth());
        this.popupWindowHeight.setHeight(-2);
        this.popupWindowHeight.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), 17170443));
        this.popupWindowHeight.setContentView(this.listViewHeight);
        return this.popupWindowHeight;
    }


    public void dismissPopupHeight() {
        if (this.popupWindowHeight != null) {
            this.popupWindowHeight.dismiss();
        }
    }

    private View.OnClickListener showPopupWindow_Weight() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                BMIActivity.this.popupWindowWeight().showAsDropDown(view, 0, 0);
            }
        };
    }


    @SuppressLint("ResourceType")
    public PopupWindow popupWindowWeight() {
        this.popupWindowWeight = new PopupWindow(this);
        this.listViewWeight = new ListView(this);
        this.listViewWeight.setDividerHeight(0);
        this.listViewWeight.setAdapter(this.adapter_weight);
        this.listViewWeight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                StringBuilder sb = new StringBuilder();
                sb.append("position->");
                sb.append(i);
                Log.d("position", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("arraylist_weigth->");
                sb2.append((String) BMIActivity.this.arraylist_weigth.get(i));
                Log.d("arraylist_weigth", sb2.toString());
                BMIActivity.this.tv_weightunit.setText((CharSequence) BMIActivity.this.arraylist_weigth.get(i));
                BMIActivity.this.dismissPopupTopics();
            }
        });
        this.popupWindowWeight.setFocusable(true);
        this.popupWindowWeight.setWidth(this.tv_weightunit.getMeasuredWidth());
        this.popupWindowWeight.setHeight(-2);
        this.popupWindowWeight.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), 17170443));
        this.popupWindowWeight.setContentView(this.listViewWeight);
        return this.popupWindowWeight;
    }


    public void dismissPopupTopics() {
        if (this.popupWindowWeight != null) {
            this.popupWindowWeight.dismiss();
        }
    }


    public void calculate() {
        StringBuilder sb = new StringBuilder();
        sb.append("inserted_weight");
        sb.append(this.inserted_weight);
        Log.d("inserted_weight", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("inserted_height");
        sb2.append(this.inserted_height);
        Log.d("inserted_height", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("height_unit");
        sb3.append(this.height_unit);
        Log.d("height_unit", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("weight_unit");
        sb4.append(this.weight_unit);
        Log.d("weight_unit", sb4.toString());
        if (this.height_unit.equalsIgnoreCase(getString(R.string.feet))) {
            this.bmi_height = this.inserted_height;
        } else {
            this.bmi_height = this.inserted_height * 0.032808f;
        }
        if (this.weight_unit.equalsIgnoreCase(getString(R.string.lbs))) {
            this.bmi_weight = this.inserted_weight;
        } else {
            this.bmi_weight = this.inserted_weight * 2.2046f;
        }
        this.bmi = calculateBMI(this.bmi_weight, this.bmi_height);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("bmi value");
        sb5.append(this.bmi);
        Log.d("bmi value", sb5.toString());
        Intent intent = new Intent(this, BMI_Result.class);
        intent.putExtra("age", this.age);
        intent.putExtra("bmi", this.bmi);
        startActivity(intent);
    }

    private float calculateBMI(float f, float f2) {
        double d = (double) f;
        Double.isNaN(d);
        double d2 = d * 4.88d;
        double d3 = (double) (f2 * f2);
        Double.isNaN(d3);
        return (float) (d2 / d3);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
//        this.adView.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }
}