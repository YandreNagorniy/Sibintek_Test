package com.example.sibintektest.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sibintektest.R;

public class MainActivityImpl extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
