package com.example.sibintektest.presentation.info;

public interface InfoPresenter {
    void attachView(InfoView view);

    void detachView();

    void getCountryData(String countryName);
}
