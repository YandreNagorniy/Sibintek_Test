package com.example.sibintektest.data.repositories;

import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.pojo.CountriesModelInfo;

import java.util.List;

import io.reactivex.Single;

public interface CountriesRepository {
    Boolean getLocalData();

    void getDataFromServer();

    Single<List<CountriesModel>> getAllCountriesModel();

    Single<CountriesModelInfo> getCountriesModelInfo();
}
