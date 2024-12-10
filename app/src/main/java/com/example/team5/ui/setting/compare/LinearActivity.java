package com.example.team5.ui.setting.compare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.team5.R;

public class LinearActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
