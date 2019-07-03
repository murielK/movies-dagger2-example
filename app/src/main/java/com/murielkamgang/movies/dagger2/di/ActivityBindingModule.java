package com.murielkamgang.movies.dagger2.di;

import com.murielkamgang.movies.dagger2.main.MainActivity;
import com.murielkamgang.movies.dagger2.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by muriel on 9/20/17.
 */

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}