package com.example.sibintektest.presentation.info;

import com.example.sibintektest.data.repositories.CountriesRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class InfoPresenterImpl implements InfoPresenter {
    private CountriesRepository countriesRepository;
    private InfoView infoView;
    private CompositeDisposable compositeDisposable;

    InfoPresenterImpl(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void attachView(InfoView view) {
        infoView = view;
    }

    @Override
    public void getCountryData(String countryName) {
        compositeDisposable.add(countriesRepository.getCountriesModelInfo(countryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(countriesModelInfo -> infoView.displayCountryInfo(countriesModelInfo),
                        throwable -> infoView.showError()));
    }

    @Override
    public void detachView() {
        compositeDisposable.clear();
        infoView = null;
    }

}
