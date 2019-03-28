package com.example.sibintektest.data.database.converters;

import android.arch.persistence.room.TypeConverter;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.sibintektest.data.pojo.Currency;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CurrencyConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Currency> stringToCurrency(String data) {
        if (data == null) return Collections.emptyList();

        Type listType = new TypeToken<List<Currency>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String CurrencyToString(List<Currency> list) {
        return gson.toJson(list);
    }

}
