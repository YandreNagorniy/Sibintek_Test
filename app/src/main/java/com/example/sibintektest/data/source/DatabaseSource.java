package com.example.sibintektest.data.source;

import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.List;

public interface DatabaseSource  {
    void insertCountriesModelList(List<CountriesModel> countriesModelList);
}
