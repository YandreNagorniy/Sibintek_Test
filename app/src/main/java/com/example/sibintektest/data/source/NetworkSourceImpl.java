package com.example.sibintektest.data.source;

import com.example.sibintektest.data.network.NetworkClient;
import com.example.sibintektest.data.pojo.AllCountriesResponse;

import java.util.List;

import io.reactivex.Single;

public class NetworkSourceImpl implements NetworkSource {

    @Override
    public Single<List<AllCountriesResponse>> getData() {
        return NetworkClient.getRetrofit().getAllCountries();
    }
}
