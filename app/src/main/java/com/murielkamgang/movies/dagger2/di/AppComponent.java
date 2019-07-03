package com.murielkamgang.movies.dagger2.di;/*
 * Copyright 2018 AG04 INNOVATIVE SOLUTIONS d.o.o. All rights reserved.
 */

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by muriel on 25/05/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }
}
