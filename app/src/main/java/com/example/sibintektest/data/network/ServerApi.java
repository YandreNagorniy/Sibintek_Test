package com.example.sibintektest.data.network;

import com.example.sibintektest.data.pojo.AllCountriesResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ServerApi {
    @GET("all")
    Single<List<AllCountriesResponse>> getAllCountries();
}
