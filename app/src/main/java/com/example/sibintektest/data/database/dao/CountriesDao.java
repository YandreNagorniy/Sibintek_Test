package com.example.sibintektest.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCountriesModel(List<CountriesModel> countriesModelList);

    @Query("Select * From CountriesModel")
    Flowable<List<CountriesModel>> getAllCountriesModel();
}
