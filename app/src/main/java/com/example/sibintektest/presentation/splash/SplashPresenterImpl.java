package com.example.sibintektest.presentation.splash;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.sibintektest.data.repositories.CountriesRepository;

import java.lang.ref.WeakReference;

public class SplashPresenterImpl implements SplashPresenter {
    private CountriesRepository countriesRepository;
    private SplashView splashView;
    private WeakReference<Context> mContext;

    SplashPresenterImpl(WeakReference<Context> mContext, CountriesRepository countriesRepository) {
        this.mContext = mContext;
        this.countriesRepository = countriesRepository;
    }

    @Override
    public void attachView(SplashView view) {
        splashView = view;
    }

    @Override
    public void checkData() {
        boolean isDatabaseFull = countriesRepository.getLocalData();
        if (isDatabaseFull) splashView.goToMainActivity();
        else if (isOnline()) {
            countriesRepository.getDataFromServer();
            splashView.goToMainActivity();
        } else splashView.displayError();
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) mContext.get().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    @Override
    public void detachView() {
        splashView = null;
    }
}
