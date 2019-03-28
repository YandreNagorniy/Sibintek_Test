package com.example.sibintektest.presentation.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sibintektest.R;
import com.example.sibintektest.data.repositories.CountriesRepositoryImpl;
import com.example.sibintektest.data.source.DatabaseSourceImpl;
import com.example.sibintektest.data.source.LocalSourceImpl;
import com.example.sibintektest.data.source.NetworkSourceImpl;
import com.example.sibintektest.presentation.main.MainActivityImpl;

import java.lang.ref.WeakReference;

public class SplashActivityImpl extends AppCompatActivity implements SplashView {
    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashPresenter = new SplashPresenterImpl(new WeakReference<>(this),
                new CountriesRepositoryImpl(new LocalSourceImpl(new WeakReference<>(this)),
                        new DatabaseSourceImpl(), new NetworkSourceImpl()));
        splashPresenter.attachView(this);
        splashPresenter.checkData();
    }

    @Override
    public void goToMainActivity() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivityImpl.this,
                    MainActivityImpl.class);
            startActivity(intent);
            finish();
        }, 2 * 1000);
    }

    @Override
    public void displayError() {
        Toast.makeText(this, "Отсутсвует интернет-соединение",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        splashPresenter.detachView();
        super.onDestroy();
    }
}
