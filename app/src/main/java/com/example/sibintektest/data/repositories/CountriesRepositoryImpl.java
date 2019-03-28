package com.example.sibintektest.data.repositories;

import com.example.sibintektest.data.map.AllCountriesMapper;
import com.example.sibintektest.data.source.DatabaseSource;
import com.example.sibintektest.data.source.LocalSource;
import com.example.sibintektest.data.source.NetworkSource;

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
                .map(AllCountriesMapper::mapToCountriesModel)
                .doOnSuccess(countriesModels -> {
                    databaseSource.insertCountriesModelList(countriesModels);
                    localSource.setLocalData(true);
                })
                .subscribe();
    }
}
