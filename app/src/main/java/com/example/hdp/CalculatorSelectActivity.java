package com.example.hdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.hdp.Login.DiseasesActivity;
import com.example.hdp.Medi_Consult.MediConsult;
import com.example.hdp.calculator.BMI.BMIActivity;
import com.example.hdp.calculator.BMR.BMRActivity;
import com.example.hdp.calculator.BP.BPActivity;
import com.example.hdp.calculator.BloodVolume.BVActivity;
import com.example.hdp.calculator.BodyFat.BodyFatActivity;
import com.example.hdp.calculator.Calorie.CalorieBurnActivity;
import com.example.hdp.calculator.Calorie.CalorieIntakeActivity;
import com.example.hdp.calculator.Chelosterol.CHActivity;
import com.example.hdp.calculator.HeartRate.HeartRateActivity;
import com.example.hdp.calculator.Water.WaterIntakeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.checkerframework.checker.nullness.qual.NonNull;

public class CalculatorSelectActivity extends AppCompatActivity {

    RelativeLayout basalRl, bmiRl, bpRl, bvRl, bfRl, cbRl, ciRl, wiRl, chRl, htRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_select);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        basalRl = findViewById(R.id.basal_rl);
        bmiRl = findViewById(R.id.bmi_rl);
        bpRl = findViewById(R.id.bp_rl);
        bvRl = findViewById(R.id.bv_rl);
        bfRl = findViewById(R.id.bf_rl);
        cbRl = findViewById(R.id.cb_rl);
        ciRl = findViewById(R.id.ci_rl);
        wiRl = findViewById(R.id.wt_rl);
        chRl = findViewById(R.id.ch_rl);
        htRl = findViewById(R.id.ht_rl);

        basalRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, BMRActivity.class));
            }
        });
        bmiRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, BMIActivity.class));
            }
        });
        bpRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, BPActivity.class));
            }
        });
        bvRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, BVActivity.class));
            }
        });
        bfRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, BodyFatActivity.class));
            }
        });
        cbRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, CalorieBurnActivity.class));
            }
        });
        ciRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, CalorieIntakeActivity.class));
            }
        });
        wiRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, WaterIntakeActivity.class));
            }
        });
        chRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, CHActivity.class));
            }
        });
        htRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorSelectActivity.this, HeartRateActivity.class));
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.calculators);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.detect:
                                CalculatorSelectActivity.this.startActivity(new Intent(CalculatorSelectActivity.this,
                                        DiseasesActivity.class));
                                CalculatorSelectActivity.this.finish();
                                CalculatorSelectActivity.this.overridePendingTransition(0, 0);
                                return true;
                            case R.id.calculators:
                                return true;
                            case R.id.medi_consult:
                                CalculatorSelectActivity.this.startActivity(new Intent(CalculatorSelectActivity.this,
                                        MediConsult.class));
                                CalculatorSelectActivity.this.finish();
                                CalculatorSelectActivity.this.overridePendingTransition(0, 0);
                                return true;
                        }
                        return false;
                    }
                });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}