package com.murielkamgang.movies.dagger2.main;

import android.util.Log;

import com.murielkamgang.movies.dagger2.data.model.Movie;
import com.murielkamgang.movies.dagger2.data.source.DataSource;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = MainFragment.class.getSimpleName();

    private final DataSource<Movie> dataSource;

    private MainContract.View view;

    @Inject
    MainPresenter(DataSource<Movie> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
        loadMovies();
    }

    @Override
    public void destroyView() {
        view = null;
    }

    private void loadMovies() {
        dataSource.getAll(new DataSource.OnSuccessListener<Movie>() {
            @Override
            public void onSuccess(List<Movie> movies) {
                if (view != null) {
                    view.onMoviesLoaded(movies);
                }
            }
        }, new DataSource.OnErrorListener() {
            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "error while loading movies", throwable);
            }
        });
    }
}
