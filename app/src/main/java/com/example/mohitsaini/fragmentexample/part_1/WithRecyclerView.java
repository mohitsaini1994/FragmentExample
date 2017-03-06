package com.example.mohitsaini.fragmentexample.part_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mohitsaini.fragmentexample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitsaini on 31/12/16.
 */

public class WithRecyclerView extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    static final String url = "http://mpsandroidx.tk/json_encoded/show_faculty.php";
    MyJSONSingleton myJSONSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ListView lv = (ListView)findViewById(R.id.lv);
        lv.setVisibility(View.GONE);
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(WithRecyclerView.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        Movie movie = movieList.get(position);
                        Toast.makeText(WithRecyclerView.this, "Name: "+movie.getName()+"\r\n"+"Email ID: "+movie.getEmail_id()+"\r\n"
                                +"Mobile No.: "+movie.getMobile_no()+"\r\n"+"Department :"+movie.getDepartment()+"\r\n"+
                                "Designation :"+movie.getDesignation(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                        Toast.makeText(WithRecyclerView.this, "First line of text\r\nSecond line of text", Toast.LENGTH_SHORT).show();
                    }
                })
        );

        prepareMovieData();
    }

    private void prepareMovieData() {

        myJSONSingleton = MyJSONSingleton.getInstance(getApplicationContext());
        StringRequest stringWinRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("posts");
                    Movie movie;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

//                        String name, email_id, mobile_no, department, designation;
                        movie = new Movie(jsonObject1.getString("name"), jsonObject1.getString("email_id"),
                                jsonObject1.getString("mobile_no"), jsonObject1.getString("department"),
                                jsonObject1.getString("designation"));
                        movieList.add(movie);
                    }
                    mAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        myJSONSingleton.getRequestQueue().add(stringWinRequest);
    }
}
