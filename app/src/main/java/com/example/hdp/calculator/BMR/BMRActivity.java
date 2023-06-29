package com.example.hdp.calculator.BMR;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hdp.R;

import java.io.PrintStream;
import java.util.ArrayList;

public class BMRActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter_gender;
    ArrayAdapter<String> adapter_height;
    ArrayAdapter<String> adapter_weight;
    double age;
    ArrayList<String> arraylist_gender = new ArrayList<>();
    ArrayList<String> arraylist_height = new ArrayList<>();
    ArrayList<String> arraylist_weigth = new ArrayList<>();
    double bmr;
    double bmr_height;
    double bmr_weight;
    EditText et_age;
    EditText et_height;
    EditText et_weight;
    Bundle extras;
    String gender;
    String height_unit;
    float inserted_height;
    float inserted_weight;
    ImageView iv_back;
    ListView listViewGender;
    ListView listViewHeight;
    ListView listViewWeight;
    private PopupWindow popupWindowGender;
    private PopupWindow popupWindowHeight;
    private PopupWindow popupWindowWeight;
    RelativeLayout rl_main;
    TextView tv_bmr;
    TextView tv_gender;
    TextView tv_genderunit;
    TextView tv_heightunit;
    TextView tv_search_bmr;
    TextView tv_weightunit;
    String weight_unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmractivity);

        this.et_height = (EditText) findViewById(R.id.et_height);
        this.et_weight = (EditText) findViewById(R.id.et_weight);
        this.et_age = (EditText) findViewById(R.id.et_age);
        this.rl_main = (RelativeLayout) findViewById(R.id.rl_main);
        this.tv_heightunit = (TextView) findViewById(R.id.tv_heightunit);
        this.tv_weightunit = (TextView) findViewById(R.id.tv_weightunit);
        this.tv_search_bmr = (TextView) findViewById(R.id.tv_search_bmr);
        this.tv_genderunit = (TextView) findViewById(R.id.tv_genderunit);
        this.tv_gender = (TextView) findViewById(R.id.tv_gender);
        this.extras = getIntent().getExtras();
        if (this.extras != null) {
            if (this.extras.getString("from", "bmr").equals("bmr")) {
                this.tv_bmr.setText(getString(R.string.bmr_Calculator));
                this.tv_search_bmr.setText(getString(R.string.Calculate_BMR));
//                this.rl_main.setBackgroundResource(R.drawable.background_gradient1);
            } else {
                this.tv_bmr.setText(getString(R.string.rmr_Calculator));
                this.tv_search_bmr.setText(getString(R.string.Calculate_RMR));
//                this.rl_main.setBackgroundResource(R.drawable.background_gradient7);
            }
        }

        this.height_unit = getString(R.string.feet);
        this.weight_unit = getString(R.string.lbs);
        this.tv_heightunit.setOnClickListener(showPopupWindowHeight());
        this.tv_weightunit.setOnClickListener(showPopupWindow_Weight());
        this.tv_gender.setOnClickListener(showPopupWindowGender());
        this.arraylist_gender.clear();
        this.arraylist_gender.add(getString(R.string.Male));
        this.arraylist_gender.add(getString(R.string.Female));
        this.adapter_gender = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_gender);
        this.arraylist_height.clear();
        this.arraylist_height.add(getString(R.string.feet));
        this.arraylist_height.add(getString(R.string.cm));
        this.arraylist_weigth.clear();
        this.arraylist_weigth.add(getString(R.string.kg));
        this.arraylist_weigth.add(getString(R.string.lbs));
        this.adapter_height = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_height);
        this.adapter_weight = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_weigth);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }

        this.tv_search_bmr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BMRActivity.this.et_age.getText().toString().trim().equals("")) {
                    BMRActivity.this.et_age.setError(BMRActivity.this.getString(R.string.Enter_Age));
                } else if (BMRActivity.this.et_height.getText().toString().trim().equals("") || BMRActivity.this.et_height.getText().toString().trim().equals(".")) {
                    BMRActivity.this.et_height.setError(BMRActivity.this.getString(R.string.Enter_Height));
                } else if (BMRActivity.this.et_weight.getText().toString().trim().equals("") || BMRActivity.this.et_weight.getText().toString().trim().equals(".")) {
                    BMRActivity.this.et_weight.setError(BMRActivity.this.getString(R.string.Enter_Weight));
                } else {
                    BMRActivity.this.height_unit = BMRActivity.this.tv_heightunit.getText().toString();
                    BMRActivity.this.weight_unit = BMRActivity.this.tv_weightunit.getText().toString();
                    BMRActivity.this.inserted_weight = Float.parseFloat(BMRActivity.this.et_weight.getText().toString());
                    BMRActivity.this.inserted_height = Float.parseFloat(BMRActivity.this.et_height.getText().toString());
                    BMRActivity.this.age = (double) Integer.parseInt(BMRActivity.this.et_age.getText().toString());
                    BMRActivity.this.gender = BMRActivity.this.tv_gender.getText().toString().trim();
                    int random = ((int) (Math.random() * 2.0d)) + 1;
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("random_number==>");
                    sb.append(random);
                    printStream.println(sb.toString());
                    BMRActivity.this.calculate();
//                    if (random == 1) {
//                        BMRActivity.this.calculate();
//                    }
                }
            }
        });
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
        if (this.height_unit.equalsIgnoreCase(getString(R.string.cm))) {
            this.bmr_height = (double) this.inserted_height;
        } else {
            this.bmr_height = (double) (this.inserted_height / 0.032808f);
        }
        if (this.weight_unit.equalsIgnoreCase(getString(R.string.kg))) {
            this.bmr_weight = (double) this.inserted_weight;
        } else {
            this.bmr_weight = (double) (this.inserted_weight / 2.2046f);
        }
        if (this.gender.equalsIgnoreCase(getString(R.string.Male))) {
            this.bmr = (((this.bmr_weight * 10.0d) + (this.bmr_height * 6.25d)) - (this.age * 5.0d)) + 5.0d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bmr_male->");
            sb5.append(this.bmr);
            Log.d("bmr_male->", sb5.toString());
        } else {
            this.bmr = (((this.bmr_weight * 10.0d) + (this.bmr_height * 6.25d)) - (this.age * 5.0d)) - 161.0d;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("bmr_female->");
            sb6.append(this.bmr);
            Log.d("bmr_female->", sb6.toString());
        }
        Intent intent = new Intent(this, BMR_Result.class);
        intent.putExtra("bmr", this.bmr);
//        intent.putExtra("from", this.extras.getString("from", "bmr"));
        startActivity(intent);
    }

    private View.OnClickListener showPopupWindowHeight() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                BMRActivity.this.popupWindowHeight().showAsDropDown(view, 0, 0);
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
                BMRActivity.this.tv_heightunit.setText((CharSequence) BMRActivity.this.arraylist_height.get(i));
                BMRActivity.this.dismissPopupHeight();
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
                BMRActivity.this.popupWindowWeight().showAsDropDown(view, 0, 0);
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
                sb2.append((String) BMRActivity.this.arraylist_weigth.get(i));
                Log.d("arraylist_weigth", sb2.toString());
                BMRActivity.this.tv_weightunit.setText((CharSequence) BMRActivity.this.arraylist_weigth.get(i));
                BMRActivity.this.dismissPopupTopics();
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


    @SuppressLint("ResourceType")
    public PopupWindow popupWindowGender() {
        this.popupWindowGender = new PopupWindow(this);
        this.listViewGender = new ListView(this);
        this.listViewGender.setDividerHeight(0);
        this.listViewGender.setAdapter(this.adapter_gender);
        this.listViewGender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BMRActivity.this.tv_gender.setText((CharSequence) BMRActivity.this.arraylist_gender.get(i));
                BMRActivity.this.tv_genderunit.setText((CharSequence) BMRActivity.this.arraylist_gender.get(i));
                BMRActivity.this.dismissPopupGender();
            }
        });
        this.popupWindowGender.setFocusable(true);
        this.popupWindowGender.setWidth(this.tv_gender.getMeasuredWidth());
        this.popupWindowGender.setHeight(-2);
        this.popupWindowGender.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), 17170443));
        this.popupWindowGender.setContentView(this.listViewGender);
        return this.popupWindowGender;
    }


    public void dismissPopupGender() {
        if (this.popupWindowGender != null) {
            this.popupWindowGender.dismiss();
        }
    }

    private View.OnClickListener showPopupWindowGender() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                BMRActivity.this.popupWindowGender().showAsDropDown(view, 0, 0);
            }
        };
    }

    public void onBackPressed() {
//        this.adView.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }


}