package com.example.sibintektest.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.List;

@Dao
public interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCountriesModel(List<CountriesModel> countriesModelList);

}
