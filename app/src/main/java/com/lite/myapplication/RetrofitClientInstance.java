package com.lite.myapplication;


import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Saket on 28,July,2019
 */
public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE = "https://my-json-server.typicode.com/";
    private RetrofitClientInstance(){
    }

    public static Retrofit getInstance(){

        if(retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder().baseUrl(BASE).addConverterFactory(GsonConverterFactory.create()).client(client)
                                            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())).build();
        }
        return retrofit;
    }
}
