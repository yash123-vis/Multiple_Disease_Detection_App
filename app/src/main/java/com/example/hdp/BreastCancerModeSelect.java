package com.example.hdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BreastCancerModeSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breast_cancer_mode_select);

        CardView traditional = findViewById(R.id.traditionalCard);
        traditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BreastCancerModeSelect.this, BreastCancerActivity.class));
            }
        });

        CardView mammography = findViewById(R.id.mamographyCard);
        mammography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BreastCancerModeSelect.this, BreastCancerMammoActivity.class));
            }
        });


    }
}