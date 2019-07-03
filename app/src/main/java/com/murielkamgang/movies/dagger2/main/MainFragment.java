package com.murielkamgang.movies.dagger2.main;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.murielkamgang.movies.dagger2.R;
import com.murielkamgang.movies.dagger2.data.model.Movie;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class MainFragment extends DaggerFragment implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;
    @Inject
    RecyclerView.Adapter<MainAdapter.MainVH> adapter;

    @Inject
    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter.setView(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter.destroyView();
    }

    @Override
    public void onMoviesLoaded(List<Movie> movies) {
        ((MainAdapter) adapter).setMovies(movies);
    }
}
