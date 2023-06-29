package com.example.hdp.Medi_Consult;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.hdp.CalculatorSelectActivity;
import com.example.hdp.Login.DiseasesActivity;
import com.example.hdp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.checkerframework.checker.nullness.qual.NonNull;

public class MediConsult extends AppCompatActivity {

    CardView diseaseCard, hospitalCard, sosCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_consult);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        diseaseCard = findViewById(R.id.disease_checker);
        hospitalCard = findViewById(R.id.nearby_hospitals);
        sosCard = findViewById(R.id.sos);

        hospitalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.google.com/maps/search/hospitals+near+me"));
                startActivity(browserIntent);
            }
        });

        diseaseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MediConsult.this, DiseaseChecker.class));
            }
        });

        sosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MediConsult.this, SOSCall.class));
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.medi_consult);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.detect:
                                MediConsult.this.startActivity(new Intent(MediConsult.this,
                                        DiseasesActivity.class));
                                MediConsult.this.finish();
                                MediConsult.this.overridePendingTransition(0, 0);
                                return true;
                            case R.id.calculators:
                                MediConsult.this.startActivity(new Intent(MediConsult.this,
                                        CalculatorSelectActivity.class));
                                MediConsult.this.finish();
                                MediConsult.this.overridePendingTransition(0, 0);
                                return true;
                            case R.id.medi_consult:
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