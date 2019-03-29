package com.example.sibintektest.data.map;

import com.example.sibintektest.data.pojo.AllCountriesResponse;
import com.example.sibintektest.data.pojo.CountriesModelInfo;

import java.util.ArrayList;
import java.util.List;

public class AllCountriesMapper {
    public static List<CountriesModelInfo> mapToCountriesModel(List<AllCountriesResponse> countriesList) {
        List<CountriesModelInfo> list = new ArrayList<>();
        for (AllCountriesResponse countries : countriesList) {
            list.add(new CountriesModelInfo(countries.getName(), countries.getCapital(),
                    countries.getFlag(), countries.getCurrencies()));
        }
        return list;
    }
}
