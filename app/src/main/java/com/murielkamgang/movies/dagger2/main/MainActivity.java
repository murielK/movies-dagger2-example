package com.murielkamgang.movies.dagger2.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.murielkamgang.movies.dagger2.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    MainFragment mainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayoutRoot, mainFragment)
                    .commit();
        }
    }
}
