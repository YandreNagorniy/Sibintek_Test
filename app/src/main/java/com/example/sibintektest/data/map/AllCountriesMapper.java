package com.example.sibintektest.data.map;

import com.example.sibintektest.data.pojo.AllCountriesResponse;
import com.example.sibintektest.data.pojo.CountriesModel;

import java.util.ArrayList;
import java.util.List;

public class AllCountriesMapper {
    public static List<CountriesModel> mapToCountriesModel(List<AllCountriesResponse> countriesList) {
        List<CountriesModel> list = new ArrayList<>();
        for (AllCountriesResponse countries : countriesList) {
            list.add(new CountriesModel(countries.getName(), countries.getCapital(),
                    countries.getFlag(), countries.getCurrencies()));
        }
        return list;
    }
}
