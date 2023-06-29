package com.example.hdp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hdp.Login.LoginActivity;
import com.example.hdp.Medi_Consult.MediConsult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class SelectActivity extends AppCompatActivity {


    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    RelativeLayout brainRL, covidRL, skinRL, lungRL, calculatorRL, mediConsultRL;
    LinearLayout languageLL, logout_LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_select);

        brainRL = findViewById(R.id.brain_rel);
        covidRL = findViewById(R.id.covid_rel);
        skinRL = findViewById(R.id.skin_rel);
        lungRL = findViewById(R.id.lung_rel);
        mediConsultRL = findViewById(R.id.medi_consult_rel);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        calculatorRL = findViewById(R.id.calculator_linear);
        languageLL = findViewById(R.id.language_ll);


        languageLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLanguageDialog();
            }
        });

        logout_LL = findViewById(R.id.logout_LL);
        logout_LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SelectActivity.this, LoginActivity.class));
                finish();
            }
        });

        mediConsultRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, MediConsult.class));
            }
        });
        clickEvents();
    }

    private void showLanguageDialog() {
        final String[] langListItems = {"বাংলা", "हिन्दी", "Español", "Français", "English"};
        AlertDialog.Builder builder = new AlertDialog.Builder(SelectActivity.this, R.style.MyDialogTheme);
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

    private void clickEvents() {
        calculatorRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, CalculatorSelectActivity.class));
            }
        });
        brainRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, MainActivity.class));
            }
        });

        covidRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, CovidActivity.class));
            }
        });

        skinRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, SkinActivty.class));
            }
        });

        lungRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, LungCancerActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}