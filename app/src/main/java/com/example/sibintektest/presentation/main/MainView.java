package com.example.sibintektest.presentation.main;

import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.List;

public interface MainView {
    void displayCountries(List<CountriesModel> countriesModelList);

    void showError();
}
