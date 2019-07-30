package com.lite.myapplication;


import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Saket on 30,July,2019
 */
public interface Posts {

    @GET("/typicode/demo/{path}")
    Single<List<Beans>> getPosts(@Path("path") String path);
}
