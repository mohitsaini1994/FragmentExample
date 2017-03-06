package com.example.mohitsaini.fragmentexample.android.hive.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohitsaini on 7/1/17.
 */


//          for any query go to the below link
//          http://www.androidhive.info/2016/05/android-working-with-retrofit-http-library/

public class RetMainActivity extends AppCompatActivity {
        private static final String TAG = RetMainActivity.class.getSimpleName();

        // TODO - insert your themoviedb.org API KEY here
        private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.my_json_example);
            ListView listView = (ListView)findViewById(R.id.lv);
            listView.setVisibility(View.GONE);

            if (API_KEY.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
                return;
            }

            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            ApiInterface apiService = RetApiClient.getClient().create(ApiInterface.class);

            Call<RetMoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
            call.enqueue(new Callback<RetMoviesResponse>() {
                @Override
                public void onResponse(Call<RetMoviesResponse>call, Response<RetMoviesResponse> response) {
                    List<RetMovie> movies = response.body().getResults();
                    recyclerView.setAdapter(new RetMoviesAdapter(movies, R.layout.ret_list_item_movie, getApplicationContext()));
                    Log.d(TAG, "Number of movies received: " + movies.size());
                }

                @Override
                public void onFailure(Call<RetMoviesResponse>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
        }
}
