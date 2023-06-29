package com.example.hdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class CovidPrevention extends AppCompatActivity {

    TextView guidelineTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_prevention);

        guidelineTV = findViewById(R.id.treat_7);
        guidelineTV.setMovementMethod(LinkMovementMethod.getInstance());
    }
}