package com.example.sibintektest.data.source;

import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.List;

import io.reactivex.Flowable;

public interface DatabaseSource  {
    Flowable<List<CountriesModel>> getAllCountriesModel();

    void insertCountriesModelList(List<CountriesModel> countriesModelList);
}
