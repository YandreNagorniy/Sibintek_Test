package com.example.sibintektest.presentation.info;

import com.example.sibintektest.data.pojo.CountriesModelInfo;

public interface InfoView {
    void displayCountryInfo(CountriesModelInfo countriesModelInfo);

    void showError();
}
