/*
 * Copyright 2018 AG04 INNOVATIVE SOLUTIONS d.o.o. All rights reserved.
 */

package com.murielkamgang.movies.dagger2.di;

import android.app.Application;
import android.content.Context;

import com.murielkamgang.movies.dagger2.BuildConfig;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by muriel on 25/05/2018.
 */

@Module
abstract class ApplicationModule {

    @Singleton
    @Provides
    static Picasso providePicasso(Context context) {
        return new Picasso.Builder(context).build();
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build();
    }

    @Binds
    @Singleton
    abstract Context bindContext(Application application);

}
