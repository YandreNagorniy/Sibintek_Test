package com.example.sibintektest.data.repositories;

import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.List;

import io.reactivex.Flowable;

public interface CountriesRepository {
    Boolean getLocalData();

    void getDataFromServer();

    Flowable<List<CountriesModel>> getDataFromDatabase();
}
