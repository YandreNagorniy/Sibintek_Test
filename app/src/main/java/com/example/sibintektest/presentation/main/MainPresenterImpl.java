package com.example.sibintektest.presentation.main;

import com.example.sibintektest.data.repositories.CountriesRepository;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter {
    private CountriesRepository countriesRepository;
    private MainView mainView;
    private CompositeDisposable compositeDisposable;

    MainPresenterImpl(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
        compositeDisposable =new CompositeDisposable();
    }

    @Override
    public void attachView(MainView view) {
        mainView = view;
    }

    @Override
    public void getDataFromDb() {
        compositeDisposable.add(countriesRepository.getDataFromDatabase()
                .observeOn(Schedulers.io())
                .subscribe(countriesModels ->
                                mainView.displayCountries(countriesModels),
                        throwable -> mainView.showError()));
    }

    @Override
    public void detachView() {
        compositeDisposable.clear();
        mainView = null;
    }
}
