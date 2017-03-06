package com.example.mohitsaini.fragmentexample.part_2;

import com.example.mohitsaini.fragmentexample.part_1.Movie;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by mohitsaini on 7/1/17.
 */

public interface RetrofitApi {

    /*Retrofit get annotation with our URL
       And our method that will return us the list ob Book
    */
//    @GET("/json_encoded/show_faculty.php")
    @GET("/json_encoded/ddd.json")
    public void getData(Callback<List<Movie>> response);
}
