package com.example.sibintektest.presentation.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sibintektest.R;

public class SplashActivityImpl extends AppCompatActivity implements SplashView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
