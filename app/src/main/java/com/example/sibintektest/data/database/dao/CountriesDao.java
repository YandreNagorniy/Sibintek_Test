package com.example.sibintektest.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.pojo.CountriesModelInfo;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCountriesModel(List<CountriesModelInfo> countriesModelInfoList);

    @Query("Select * From CountriesModelInfo where name =:name")
    Single<CountriesModelInfo> getCountriesModelInfo(String name);

    @Query("SELECT name, flag  FROM CountriesModelInfo")
    Single<List<CountriesModel>> getAllCountriesModel();
}
