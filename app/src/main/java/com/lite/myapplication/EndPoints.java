package com.lite.myapplication;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Saket on 28,July,2019
 */
public interface EndPoints {

    @GET("/typicode/{demo}/posts")
    Observable<List<Bean>> getPosts(@Path("demo") String demo);

    @FormUrlEncoded
    @POST("/typicode/demo/posts")
    Call<ResponseBody> putBody(@Field("id") int id, @Field("title") String title);
}
