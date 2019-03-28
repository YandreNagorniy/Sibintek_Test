package com.example.sibintektest.data.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.sibintektest.data.database.converters.CurrencyConverter;

import java.util.List;

@Entity
public class CountriesModel {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String capital;
    private String flag;
    @TypeConverters(CurrencyConverter.class)
    private List<Currency> currencyInfo;

    public CountriesModel( String name, String capital, String flag, List<Currency> currencyInfo) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.currencyInfo = currencyInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Currency> getCurrencyInfo() {
        return currencyInfo;
    }

    public void setCurrencyInfo(List<Currency> currencyInfo) {
        this.currencyInfo = currencyInfo;
    }
}
