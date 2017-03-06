package com.example.mohitsaini.fragmentexample.android.hive.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mohitsaini on 7/1/17.
 */

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<RetMoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    //presently is not use
    @GET("movie/{id}")
    Call<RetMoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
