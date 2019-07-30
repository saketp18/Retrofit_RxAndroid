package com.lite.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private List<Bean> mList = new ArrayList<>();
    private TextView mText;
    private int UPDATEUI = 101;
    private Disposable disposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView)findViewById(R.id.view);
        EndPoints client = RetrofitClientInstance.getInstance().create(EndPoints.class);
        Observable<List<Bean>> observable = client.getPosts("demo");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        observable.subscribeWith(new Observer<List<Bean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(List<Bean> beans) {
                Log.d("Saket", beans.toString());
                mList.addAll(beans);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                mHandler.sendEmptyMessage(UPDATEUI);
            }
        });



    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == UPDATEUI){
                mText.setText(mList.toString());
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!disposable.isDisposed())
            disposable.dispose();
    }
}
