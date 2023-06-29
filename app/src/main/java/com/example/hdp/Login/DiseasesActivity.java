package com.example.hdp.Login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.hdp.BreastCancerModeSelect;
import com.example.hdp.CalculatorSelectActivity;
import com.example.hdp.CovidActivity;
import com.example.hdp.HeartAttackPredictionActivity;
import com.example.hdp.LungCancerActivity;
import com.example.hdp.MainActivity;
import com.example.hdp.Medi_Consult.MediConsult;
import com.example.hdp.R;
import com.example.hdp.SkinActivty;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Locale;

public class DiseasesActivity extends AppCompatActivity {

    RelativeLayout brainRl, breastRl, heartRl, skinRl, covidRl, lungRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        loadLocale();

        setContentView(R.layout.activity_diseases);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        brainRl = findViewById(R.id.brain_rel);
        breastRl = findViewById(R.id.breast_rel);
        heartRl = findViewById(R.id.heart_rel);
        skinRl = findViewById(R.id.skin_rel);
        covidRl = findViewById(R.id.covid_rel);
        lungRl = findViewById(R.id.lung_rel);

        startDiseasesActivities();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.detect);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.detect:
                                return true;
                            case R.id.calculators:
                                DiseasesActivity.this.startActivity(new Intent(DiseasesActivity.this,
                                        CalculatorSelectActivity.class));
                                DiseasesActivity.this.finish();
                                DiseasesActivity.this.overridePendingTransition(0, 0);
                                return true;
                            case R.id.medi_consult:
                                DiseasesActivity.this.startActivity(new Intent(DiseasesActivity.this,
                                        MediConsult.class));
                                DiseasesActivity.this.finish();
                                DiseasesActivity.this.overridePendingTransition(0, 0);
                                return true;

                        }
                        return false;
                    }
                });



    }

    private void startDiseasesActivities() {
        brainRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiseasesActivity.this, MainActivity.class));
            }
        });

        breastRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiseasesActivity.this, BreastCancerModeSelect.class));
            }
        });

        heartRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiseasesActivity.this, HeartAttackPredictionActivity.class));
            }
        });

        covidRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiseasesActivity.this, CovidActivity.class));
            }
        });

        skinRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiseasesActivity.this, SkinActivty.class));
            }
        });

        lungRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiseasesActivity.this, LungCancerActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return true;
        }
        if (id == R.id.languageChange){
            showLanguageDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showLanguageDialog() {
        final String[] langListItems = {"বাংলা", "हिन्दी", "Español", "Français", "English"};
        AlertDialog.Builder builder = new AlertDialog.Builder(DiseasesActivity.this, R.style.MyDialogTheme);
        builder.setTitle(R.string.choose_language);
        builder.setSingleChoiceItems(langListItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("bn");
                    recreate();
                } else if (i == 1) {
                    setLocale("hi");
                    recreate();
                } else if (i == 2) {
                    setLocale("es");
                    recreate();
                } else if (i == 3) {
                    setLocale("fr");
                    recreate();
                } else if (i == 4) {
                    setLocale("en");
                    recreate();
                }
            }
        });

        AlertDialog mDialog = builder.create();
        mDialog.show();
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", language);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String lang = preferences.getString("My_Lang", "");
        setLocale(lang);
    }

}