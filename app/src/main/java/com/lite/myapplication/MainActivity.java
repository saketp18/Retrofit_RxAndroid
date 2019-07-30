package com.lite.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisposableSingleObserver<List<Beans>> observer = new DisposableSingleObserver<List<Beans>>() {
            @Override
            public void onSuccess(List<Beans> value) {
                Log.d("Saket",value.toString());
            }

            @Override
            public void onError(Throwable e) {

            }
        };
        Posts client = RetrofitClientInstance.getInstance().create(Posts.class);
        client.getPosts("posts").observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
                                        .subscribeWith(observer);

    }
}
