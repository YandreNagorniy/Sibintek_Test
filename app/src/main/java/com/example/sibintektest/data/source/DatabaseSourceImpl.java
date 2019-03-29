package com.example.sibintektest.data.source;

import com.example.sibintektest.App;
import com.example.sibintektest.data.database.dao.CountriesDao;
import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.pojo.CountriesModelInfo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class DatabaseSourceImpl implements DatabaseSource {
    private CountriesDao countriesDao;

    public DatabaseSourceImpl() {
        countriesDao = App.getInstance().getDatabase().countriesDao();
    }

    @Override
    public Single<List<CountriesModel>> getAllCountriesModel() {
        return countriesDao.getAllCountriesModel();
    }
    @Override
    public Single<CountriesModelInfo> getCountriesModelInfo() {
        return countriesDao.getCountriesModelInfo();
    }

    @Override
    public void insertCountriesModelList(List<CountriesModelInfo> countriesModelInfoList) {
        Completable.fromAction(() -> countriesDao.insertCountriesModel(countriesModelInfoList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
