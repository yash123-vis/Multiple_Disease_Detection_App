package com.example.hdp.calculator.Calorie;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hdp.R;

import java.io.PrintStream;
import java.util.ArrayList;

public class CalorieIntakeActivity extends AppCompatActivity {

    Double BMR;
    String TAG = getClass().getSimpleName();
    String activity_level = "";
    //    AdView adView;
    ArrayAdapter<String> adapter_gender;
    ArrayAdapter<String> adapter_height;
    ArrayAdapter<String> adapter_weight;
    int age;
    ArrayList<String> arraylist_gender = new ArrayList<>();
    ArrayList<String> arraylist_height = new ArrayList<>();
    ArrayList<String> arraylist_weigth = new ArrayList<>();
    Float cal_height;
    Float cal_weight;
    EditText et_age;
    EditText et_height;
    EditText et_weight;
    String gender;
    String height_unit;
    Float inserted_height;
    Float inserted_weight;
    ListView listViewHeight;
    ListView listViewWeight;
    ListView listViewgender;
    private PopupWindow popupWindowHeight;
    private PopupWindow popupWindowWeight;
    private PopupWindow popupWindowgender;
    RadioGroup rg_activity_level;
    TextView tv_bodyfat;
    TextView tv_gender;
    TextView tv_heightunit;
    TextView tv_search_calories_intake;
    TextView tv_select_level;
    TextView tv_weightunit;
    String weight_unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_intake);

        this.rg_activity_level = (RadioGroup) findViewById(R.id.rg_activity_level);
        this.et_height = (EditText) findViewById(R.id.et_height);
        this.et_weight = (EditText) findViewById(R.id.et_weight);
        this.et_age = (EditText) findViewById(R.id.et_age);
        this.tv_heightunit = (TextView) findViewById(R.id.tv_heightunit);
        this.tv_weightunit = (TextView) findViewById(R.id.tv_weightunit);
        this.tv_bodyfat = (TextView) findViewById(R.id.tv_bodyfat);
        this.tv_gender = (TextView) findViewById(R.id.tv_gender);
        this.tv_search_calories_intake = (TextView) findViewById(R.id.tv_search_calories_intake);
        this.tv_select_level = (TextView) findViewById(R.id.tv_select_level);

//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        this.tv_heightunit.setOnClickListener(showPopupWindowHeight());
        this.tv_weightunit.setOnClickListener(showPopupWindow_Weight());
        this.tv_gender.setOnClickListener(showPopupWindow_gender());
        this.arraylist_height.clear();
        this.arraylist_height.add("Feet");
        this.arraylist_height.add("Cm");
        this.arraylist_weigth.clear();
        this.arraylist_weigth.add("Kg");
        this.arraylist_weigth.add("LBS");
        this.arraylist_gender.clear();
        this.arraylist_gender.add("Male");
        this.arraylist_gender.add("Female");
        this.adapter_height = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_height);
        this.adapter_weight = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_weigth);
        this.adapter_gender = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_gender);

        this.rg_activity_level.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) CalorieIntakeActivity.this.findViewById(i);
                CalorieIntakeActivity.this.activity_level = String.valueOf(radioButton.getText());
            }
        });
        this.tv_search_calories_intake.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                if (CalorieIntakeActivity.this.et_age.getText().toString().trim().equals("")) {
                    CalorieIntakeActivity.this.et_age.setError("Enter Age");
                } else if (CalorieIntakeActivity.this.et_height.getText().toString().trim().equals("") || CalorieIntakeActivity.this.et_height.getText().toString().trim().equals(".")) {
                    CalorieIntakeActivity.this.et_height.setError("Enter Height");
                } else if (CalorieIntakeActivity.this.et_weight.getText().toString().trim().equals("") || CalorieIntakeActivity.this.et_weight.getText().toString().trim().equals(".")) {
                    CalorieIntakeActivity.this.et_weight.setError("Enter Weight");
                } else if (CalorieIntakeActivity.this.activity_level.equals("")) {
                    Toast.makeText(CalorieIntakeActivity.this.getApplicationContext(), "Select Activity Level", 0).show();
                } else {
                    CalorieIntakeActivity.this.height_unit = CalorieIntakeActivity.this.tv_heightunit.getText().toString().trim();
                    CalorieIntakeActivity.this.weight_unit = CalorieIntakeActivity.this.tv_weightunit.getText().toString().trim();
                    if (!CalorieIntakeActivity.this.et_height.getText().toString().equals(".")) {
                        CalorieIntakeActivity.this.inserted_height = Float.valueOf(Float.parseFloat(CalorieIntakeActivity.this.et_height.getText().toString().trim()));
                    }
                    if (!CalorieIntakeActivity.this.et_weight.getText().toString().equals(".")) {
                        CalorieIntakeActivity.this.inserted_weight = Float.valueOf(Float.parseFloat(CalorieIntakeActivity.this.et_weight.getText().toString().trim()));
                    }
                    CalorieIntakeActivity.this.age = Integer.parseInt(CalorieIntakeActivity.this.et_age.getText().toString());
                    CalorieIntakeActivity.this.gender = CalorieIntakeActivity.this.tv_gender.getText().toString().trim();
                    int random = ((int) (Math.random() * 2.0d)) + 1;
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("random_number==>");
                    sb.append(random);
                    printStream.println(sb.toString());
                    CalorieIntakeActivity.this.calculate();
              
//                    else {
//                        CalorieIntakeActivity.this.calculate();
//                    }
                }
            }
        });
        
    }

    private View.OnClickListener showPopupWindowHeight() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                CalorieIntakeActivity.this.popupWindowHeight().showAsDropDown(view, 0, 0);
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
                StringBuilder sb = new StringBuilder();
                sb.append("position->");
                sb.append(i);
                Log.d("position", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("arraylist_height->");
                sb2.append((String) CalorieIntakeActivity.this.arraylist_height.get(i));
                Log.d("arraylist_height", sb2.toString());
                CalorieIntakeActivity.this.tv_heightunit.setText((CharSequence) CalorieIntakeActivity.this.arraylist_height.get(i));
                CalorieIntakeActivity.this.dismissPopupHeight();
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
                CalorieIntakeActivity.this.popupWindowWeight().showAsDropDown(view, 0, 0);
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
                CalorieIntakeActivity.this.tv_weightunit.setText((CharSequence) CalorieIntakeActivity.this.arraylist_weigth.get(i));
                CalorieIntakeActivity.this.dismissPopupTopics();
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

    private View.OnClickListener showPopupWindow_gender() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                CalorieIntakeActivity.this.popupWindowgender().showAsDropDown(view, 0, 0);
            }
        };
    }


    @SuppressLint("ResourceType")
    public PopupWindow popupWindowgender() {
        this.popupWindowgender = new PopupWindow(this);
        this.listViewgender = new ListView(this);
        this.listViewgender.setDividerHeight(0);
        this.listViewgender.setAdapter(this.adapter_gender);
        this.listViewgender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CalorieIntakeActivity.this.tv_gender.setText((CharSequence) CalorieIntakeActivity.this.arraylist_gender.get(i));
                CalorieIntakeActivity.this.dismissPopupgender();
            }
        });
        this.popupWindowgender.setFocusable(true);
        this.popupWindowgender.setWidth(this.tv_gender.getMeasuredWidth());
        this.popupWindowgender.setHeight(-2);
        this.popupWindowgender.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), 17170443));
        this.popupWindowgender.setContentView(this.listViewgender);
        return this.popupWindowgender;
    }


    public void dismissPopupgender() {
        if (this.popupWindowgender != null) {
            this.popupWindowgender.dismiss();
        }
    }

    public void calculate() {
        try {
            if (this.height_unit.equals("Feet")) {
                this.cal_height = Float.valueOf(this.inserted_height.floatValue() * 12.0f);
            } else {
                this.cal_height = Float.valueOf(this.inserted_height.floatValue() * 0.032808f);
                this.cal_height = Float.valueOf(this.cal_height.floatValue() * 12.0f);
            }
            if (this.weight_unit.equals("LBS")) {
                this.cal_weight = this.inserted_weight;
            } else {
                this.cal_weight = Float.valueOf(this.inserted_weight.floatValue() * 2.2046f);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cal_weight");
            sb.append(this.cal_weight);
            Log.d("cal_weight", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cal_height");
            sb2.append(this.cal_height);
            Log.d("cal_height", sb2.toString());
            if (this.gender.equals("Female")) {
                double floatValue = (double) this.cal_weight.floatValue();
                Double.isNaN(floatValue);
                double d = (floatValue * 4.35d) + 655.0d;
                double floatValue2 = (double) this.cal_height.floatValue();
                Double.isNaN(floatValue2);
                double d2 = d + (floatValue2 * 4.7d);
                double d3 = (double) this.age;
                Double.isNaN(d3);
                this.BMR = Double.valueOf(d2 - (d3 * 4.7d));
            } else {
                double floatValue3 = (double) this.cal_weight.floatValue();
                Double.isNaN(floatValue3);
                double d4 = (floatValue3 * 6.23d) + 66.0d;
                double floatValue4 = (double) this.cal_height.floatValue();
                Double.isNaN(floatValue4);
                double d5 = d4 + (floatValue4 * 12.7d);
                double d6 = (double) this.age;
                Double.isNaN(d6);
                this.BMR = Double.valueOf(d5 - (d6 * 6.8d));
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("BMR");
            sb3.append(this.BMR);
            Log.d("BMR", sb3.toString());
            int intValue = this.BMR.intValue();
            Intent intent = new Intent(this, Daily_Calories_Intake_Result.class);
            intent.putExtra("BMR", intValue);
            intent.putExtra("ActivityLevel", this.activity_level);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
//        this.adView.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }
}