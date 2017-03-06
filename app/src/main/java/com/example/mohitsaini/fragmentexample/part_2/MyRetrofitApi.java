package com.example.mohitsaini.fragmentexample.part_2;

import java.util.List;

import retrofit.Callback;
import retrofit2.http.GET;
import retrofit2.Call;

/**
 * Created by mohitsaini on 7/1/17.
 */

public interface MyRetrofitApi {

    @GET("/json_encoded/show_faculty.php")
    Call<MyJsonRetrofit> getJSON();
}
