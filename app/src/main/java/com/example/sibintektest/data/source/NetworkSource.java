package com.example.sibintektest.data.source;

import com.example.sibintektest.data.pojo.AllCountriesResponse;

import java.util.List;

import io.reactivex.Single;

public interface NetworkSource {
    Single<List<AllCountriesResponse>> getData();
}
