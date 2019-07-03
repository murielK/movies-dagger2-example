package com.murielkamgang.movies.dagger2.data.source;

import java.util.List;

public interface DataSource<T> {

    void getAll(OnSuccessListener<T> onSuccessListener, OnErrorListener onErrorListener);

    interface OnSuccessListener<T> {

        void onSuccess(List<T> tList);
    }

    interface OnErrorListener {

        void onError(Throwable throwable);
    }

}
