package com.murielkamgang.movies.dagger2.main;

import com.murielkamgang.movies.dagger2.data.model.Movie;

import java.util.List;

public interface MainContract {

    interface View {

        void onMoviesLoaded(List<Movie> movies);
    }

    interface Presenter {

        void setView(View view);

        void destroyView();

    }
}
