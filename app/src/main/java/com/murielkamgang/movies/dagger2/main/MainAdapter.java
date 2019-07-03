package com.murielkamgang.movies.dagger2.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.murielkamgang.movies.dagger2.BuildConfig;
import com.murielkamgang.movies.dagger2.R;
import com.murielkamgang.movies.dagger2.data.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainVH> {

    private final Picasso picasso;

    private List<Movie> movies;

    @Inject
    public MainAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    @NonNull
    @Override
    public MainVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainVH holder, int position) {
        holder.bind(movies.get(position));
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    class MainVH extends RecyclerView.ViewHolder {

        private TextView textViewMovieTitle;
        private ImageView imageViewMoviePoster;

        MainVH(@NonNull View itemView) {
            super(itemView);

            textViewMovieTitle = itemView.findViewById(R.id.textViewMovieTitle);
            imageViewMoviePoster = itemView.findViewById(R.id.imageViewMoviePoster);
        }

        void bind(Movie movie) {
            textViewMovieTitle.setText(movie.getTitle());
            picasso.load(BuildConfig.BASE_POSTER_URL + movie.getPosterPath())
                    .centerCrop()
                    .fit()
                    .into(imageViewMoviePoster);
        }
    }


}
