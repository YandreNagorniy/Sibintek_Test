package com.example.sibintektest.presentation.info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sibintektest.R;

public class InfoActivityImpl extends AppCompatActivity implements InfoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_impl);
    }
}
