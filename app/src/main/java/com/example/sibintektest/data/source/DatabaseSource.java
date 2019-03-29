package com.example.sibintektest.data.source;

import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.pojo.CountriesModelInfo;

import java.util.List;

import io.reactivex.Single;

public interface DatabaseSource {
    Single<List<CountriesModel>> getAllCountriesModel();

    Single<CountriesModelInfo> getCountriesModelInfo(String name);

    void insertCountriesModelList(List<CountriesModelInfo> countriesModelInfoList);
}
