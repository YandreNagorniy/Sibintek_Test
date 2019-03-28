package com.example.sibintektest.presentation.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sibintektest.R;
import com.example.sibintektest.data.pojo.CountriesModel;
import com.example.sibintektest.data.repositories.CountriesRepositoryImpl;
import com.example.sibintektest.data.source.DatabaseSourceImpl;
import com.example.sibintektest.data.source.LocalSourceImpl;
import com.example.sibintektest.data.source.NetworkSourceImpl;
import com.example.sibintektest.databinding.ActivityMainBinding;
import com.example.sibintektest.presentation.adapters.CountriesRvAdapter;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainActivityImpl extends AppCompatActivity implements MainView {
    private ActivityMainBinding binding;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(new CountriesRepositoryImpl(
                new LocalSourceImpl(new WeakReference<>(this)),
                new DatabaseSourceImpl(), new NetworkSourceImpl()));
        binding.rvCountries.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter.attachView(this);
        mainPresenter.getDataFromDb();
    }

    @Override
    public void displayCountries(List<CountriesModel> countriesModelList) {
        RecyclerView.Adapter adapter = new CountriesRvAdapter(MainActivityImpl.this, countriesModelList);
        binding.rvCountries.setAdapter(adapter);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Список пуст", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.detachView();
        super.onDestroy();
    }
}
