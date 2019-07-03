package com.murielkamgang.movies.dagger2.main;

import androidx.recyclerview.widget.RecyclerView;

import com.murielkamgang.movies.dagger2.data.model.Movie;
import com.murielkamgang.movies.dagger2.data.source.DataSource;
import com.murielkamgang.movies.dagger2.data.source.MovieRemoteDataSource;
import com.murielkamgang.movies.dagger2.di.ActivityScoped;
import com.murielkamgang.movies.dagger2.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import retrofit2.Retrofit;

@Module
public abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainFragment provideMainFragment();

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter provideMainPresenter(MainPresenter mainPresenter);

    @ActivityScoped
    @Binds
    abstract RecyclerView.Adapter<MainAdapter.MainVH> provideMainAdapter(MainAdapter mainAdapter);

    @ActivityScoped
    @Binds
    abstract DataSource<Movie> provideModieDataSource(MovieRemoteDataSource movieRemoteDataSource);

    @ActivityScoped
    @Provides
    static MovieRemoteDataSource.MovieApi provideMovieApi(Retrofit retrofit) {
        return retrofit.create(MovieRemoteDataSource.MovieApi.class);
    }

}
