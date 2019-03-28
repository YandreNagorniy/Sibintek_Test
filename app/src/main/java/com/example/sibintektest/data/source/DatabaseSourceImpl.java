package com.example.sibintektest.data.source;

import com.example.sibintektest.App;
import com.example.sibintektest.data.database.dao.CountriesDao;
import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class DatabaseSourceImpl implements DatabaseSource {
    private CountriesDao countriesDao;

    public DatabaseSourceImpl() {
        countriesDao = App.getInstance().getDatabase().countriesDao();
    }

    public Flowable<List<CountriesModel>> getAllCountriesModel() {
        return countriesDao.getAllCountriesModel();
    }

    @Override
    public void insertCountriesModelList(List<CountriesModel> countriesModelList) {
        Completable.fromAction(() -> countriesDao.insertCountriesModel(countriesModelList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
