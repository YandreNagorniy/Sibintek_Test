package com.example.sibintektest.data.repositories;

import com.example.sibintektest.data.map.AllCountriesMapper;
import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.pojo.CountriesModelInfo;
import com.example.sibintektest.data.source.DatabaseSource;
import com.example.sibintektest.data.source.LocalSource;
import com.example.sibintektest.data.source.NetworkSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CountriesRepositoryImpl implements CountriesRepository {
    private LocalSource localSource;
    private DatabaseSource databaseSource;
    private NetworkSource networkSource;

    public CountriesRepositoryImpl(LocalSource localSource, DatabaseSource databaseSource, NetworkSource networkSource) {
        this.localSource = localSource;
        this.databaseSource = databaseSource;
        this.networkSource = networkSource;
    }

    @Override
    public Boolean getLocalData() {
        return localSource.getLocalData();
    }

    @Override
    public void getDataFromServer() {
        networkSource.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(AllCountriesMapper::mapToCountriesModel)
                .doOnSuccess(countriesModels -> {
                    databaseSource.insertCountriesModelList(countriesModels);
                    localSource.setLocalData(true);
                })
                .subscribe();

    }

    @Override
    public Single<List<CountriesModel>> getAllCountriesModel() {
        return databaseSource.getAllCountriesModel();
    }

    @Override
    public Single<CountriesModelInfo> getCountriesModelInfo() {
        return databaseSource.getCountriesModelInfo();
    }

}
