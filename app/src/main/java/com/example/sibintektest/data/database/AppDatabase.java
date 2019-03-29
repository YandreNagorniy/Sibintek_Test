package com.example.sibintektest.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.sibintektest.data.database.dao.CountriesDao;
import com.example.sibintektest.data.pojo.CountriesModelInfo;

@Database(entities = {CountriesModelInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CountriesDao countriesDao();
}
