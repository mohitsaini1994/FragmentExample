package com.example.mohitsaini.fragmentexample.android.learn2crack.send;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by mohitsaini on 10/1/17.
 */

public interface RequestInterface {

    @POST("android/login_registration/")
    Call<ServerResponse> operation(@Body ServerRequest request);


}
