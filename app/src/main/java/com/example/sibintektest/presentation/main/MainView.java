package com.example.sibintektest.presentation.main;

import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.pojo.CountriesModelInfo;

import java.util.List;

public interface MainView {

    void displayCountries(List<CountriesModel> countriesModelInfoList);

    void showError();
}
