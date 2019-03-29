package com.example.sibintektest.presentation.info;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sibintektest.R;
import com.example.sibintektest.data.pojo.CountriesModelInfo;
import com.example.sibintektest.data.repositories.CountriesRepositoryImpl;
import com.example.sibintektest.data.source.DatabaseSourceImpl;
import com.example.sibintektest.data.source.LocalSourceImpl;
import com.example.sibintektest.data.source.NetworkSourceImpl;
import com.example.sibintektest.databinding.ActivityInfoBinding;
import com.example.sibintektest.presentation.main.MainPresenterImpl;

import java.lang.ref.WeakReference;

public class InfoActivityImpl extends AppCompatActivity implements InfoView {
    private InfoPresenter infoPresenter;
    private ActivityInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info);
        infoPresenter = new InfoPresenterImpl(new CountriesRepositoryImpl(
                new LocalSourceImpl(new WeakReference<>(this)),
                new DatabaseSourceImpl(), new NetworkSourceImpl()));

        infoPresenter.attachView(this);
        if (getIntent() != null) {
            String countryName = getIntent().getStringExtra("countryName");
            infoPresenter.getCountryData(countryName);
        } else Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayCountryInfo(CountriesModelInfo countriesModelInfo) {
        binding.setCountry(countriesModelInfo);
        Glide.with(this)
                .load(countriesModelInfo.getFlag())
                .into(binding.ivInfoFlag);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Данных о стране нет", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        infoPresenter.detachView();
        super.onDestroy();
    }
}
