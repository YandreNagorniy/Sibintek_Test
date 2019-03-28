package com.example.sibintektest.presentation.splash;

public interface SplashPresenter {
    void attachView(SplashView view);

    void checkData();

    void detachView();
}
