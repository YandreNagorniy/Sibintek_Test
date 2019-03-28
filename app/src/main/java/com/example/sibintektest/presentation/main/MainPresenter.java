package com.example.sibintektest.presentation.main;

public interface MainPresenter {
    void attachView(MainView view);

    void getDataFromDb();

    void detachView();
}
