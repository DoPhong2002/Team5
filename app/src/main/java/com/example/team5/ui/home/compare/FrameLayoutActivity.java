package com.example.team5.ui.home.compare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.team5.R;


public class FrameLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame_example);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
