package com.example.hdp.calculator.Water;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.hdp.R;

import java.io.PrintStream;
import java.util.ArrayList;

public class WaterIntakeActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter_weight;
    ArrayList<String> arraylist_weight = new ArrayList<>();
    EditText et_weight;
    ImageView iv_back;
    ListView listViewWeight;
    private PopupWindow popupWindowWeight;
    TextView tv_calculate_waterintake;
    TextView tv_water_intake;
    TextView tv_weight;
    double water_intake;
    double weight;
    String weight_unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);

//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        this.et_weight = (EditText) findViewById(R.id.et_weight);
        this.tv_weight = (TextView) findViewById(R.id.tv_weight);
        this.tv_calculate_waterintake = (TextView) findViewById(R.id.tv_calculate_waterintake);
        this.arraylist_weight.clear();
        this.arraylist_weight.add(getString(R.string.lbs));
        this.arraylist_weight.add(getString(R.string.kg));
        this.adapter_weight = new ArrayAdapter<>(this, R.layout.spinner_item, R.id.text1, this.arraylist_weight);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        this.tv_calculate_waterintake.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                if (WaterIntakeActivity.this.et_weight.getText().toString().trim().equals("") || WaterIntakeActivity.this.et_weight.getText().toString().trim().equals(".")) {
                    Toast.makeText(WaterIntakeActivity.this.getApplicationContext(), WaterIntakeActivity.this.getString(R.string.Enter_Weight), 0).show();
                    return;
                }
                WaterIntakeActivity.this.weight = Double.parseDouble(WaterIntakeActivity.this.et_weight.getText().toString().trim());
                int random = ((int) (Math.random() * 2.0d)) + 1;
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("random_number==>");
                sb.append(random);
                printStream.println(sb.toString());
                WaterIntakeActivity.this.waterintake();
            
//                else {
//                    WaterIntakeActivity.this.get_waterintake();
//                }
            }
        });
    }

    public void waterintake() {
        this.weight_unit = this.tv_weight.getText().toString().trim();
        if (this.weight_unit.equalsIgnoreCase(getString(R.string.lbs))) {
            this.weight /= 2.204622d;
        }
        this.water_intake = this.weight / 0.024d;
        StringBuilder sb = new StringBuilder();
        sb.append("water_intake");
        sb.append(this.water_intake);
        Log.d("water_intake", sb.toString());
        Intent intent = new Intent(this, Daily_WaterIntake_Result.class);
        intent.putExtra("water_intake", this.water_intake);
        startActivity(intent);
    }

    private View.OnClickListener showPopupWindowWeight() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                WaterIntakeActivity.this.popupWindowWeight().showAsDropDown(view, 0, 0);
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
                WaterIntakeActivity.this.tv_weight.setText((CharSequence) WaterIntakeActivity.this.arraylist_weight.get(i));
                WaterIntakeActivity.this.dismissPopupWeight();
            }
        });
        this.popupWindowWeight.setFocusable(true);
        this.popupWindowWeight.setWidth(this.tv_weight.getMeasuredWidth());
        this.popupWindowWeight.setHeight(-2);
        this.popupWindowWeight.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), 17170443));
        this.popupWindowWeight.setContentView(this.listViewWeight);
        return this.popupWindowWeight;
    }


    public void dismissPopupWeight() {
        if (this.popupWindowWeight != null) {
            this.popupWindowWeight.dismiss();
        }
    }


    public void onBackPressed() {
//        this.adView.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }
}