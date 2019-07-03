package com.murielkamgang.movies.dagger2.data.source;

import com.murielkamgang.movies.dagger2.BuildConfig;
import com.murielkamgang.movies.dagger2.data.model.Movie;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MovieRemoteDataSource implements DataSource<Movie> {

    private final MovieApi movieApi;

    @Inject
    MovieRemoteDataSource(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    @Override
    public void getAll(final OnSuccessListener<Movie> onSuccessListener, final OnErrorListener onErrorListener) {
        movieApi.getPopular(BuildConfig.API_KEY, 1).enqueue(new Callback<MoviePage>() {
            @Override
            public void onResponse(Call<MoviePage> call, Response<MoviePage> response) {
                if (response.isSuccessful() && onSuccessListener != null) {
                    onSuccessListener.onSuccess(response.body().results);
                } else if (onErrorListener != null) {
                    String errorMsg = null;
                    if (response.errorBody() != null) {
                        try {
                            errorMsg = response.errorBody().string();
                        } catch (IOException e) {
                            //Ignore
                        }
                    }

                    if (errorMsg == null) {
                        errorMsg = "Unknown: HTTP status code: " + response.code();
                    }
                    onErrorListener.onError(new DataSourceException(errorMsg));
                }
            }

            @Override
            public void onFailure(Call<MoviePage> call, Throwable t) {
                if (onErrorListener != null) {
                    onErrorListener.onError(t);
                }
            }
        });
    }

    public interface MovieApi {

        @GET("movie/popular")
        Call<MoviePage> getPopular(@Query("api_key") String apiKey, @Query("page") int page);

    }

    private class MoviePage {

        private List<Movie> results;
    }
}
