package com.example.mohitsaini.fragmentexample.part_2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohitsaini on 7/1/17.
 */


// for any query go to the below link
// https://www.learn2crack.com/2016/02/recyclerview-json-parsing.html
public class MyRetrofitExample extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Root URL of our web service
    public static final String ROOT_URL = "http://mpsandroidx.tk/";

    private ListView listView;
    ArrayList<HashMap<String, String>> dataList;
    List<MyPost> movies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);
        dataList = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setVisibility(View.GONE);
        listView = (ListView)findViewById(R.id.lv);

        getData();

        listView.setOnItemClickListener(this);
    }

    private void getData() {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Fetching Data", "Please Wait.....");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofitApi request = retrofit.create(MyRetrofitApi.class);
        Call<MyJsonRetrofit> call = request.getJSON();
        call.enqueue(new Callback<MyJsonRetrofit>() {
            @Override
            public void onResponse(Call<MyJsonRetrofit> call, Response<MyJsonRetrofit> response) {
                progressDialog.dismiss();
                Toast.makeText(MyRetrofitExample.this, "datra dome", Toast.LENGTH_SHORT).show();
                movies = response.body().getPosts();
                Toast.makeText(MyRetrofitExample.this, "hiiiiiiiiiiii", Toast.LENGTH_SHORT).show();

                showListData();
            }

            @Override
            public void onFailure(Call<MyJsonRetrofit> call, Throwable t) {
                Log.d("Error",t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(MyRetrofitExample.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showListData(){
        for (int i=0; i<movies.size(); i++){
            MyPost movie= movies.get(i);

            HashMap<String, String> dataHash = new HashMap<>();
            dataHash.put("name", movie.getName());
            dataHash.put("email_id", movie.getEmailId());
            dataHash.put("mobile_no", movie.getMobileNo());
            dataHash.put("department", movie.getDepartment());
            dataHash.put("designation", movie.getDesignation());

            dataList.add(dataHash);
        }
        ListAdapter adapter = new SimpleAdapter(
                MyRetrofitExample.this, dataList,
                R.layout.my_single_view, new String[]{"name", "email_id",
                "mobile_no", "department", "designation"}, new int[]{R.id.tvv1,
                R.id.tvv2, R.id.tvv3, R.id.tvv4, R.id.tvv5});
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        HashMap<String, String> datagain = dataList.get(i);
        Toast.makeText(MyRetrofitExample.this, "Name: "+datagain.get("name")+"\r\n"+"Email ID: "+datagain.get("email_id")+"\r\n"
                +"Mobile No.: "+datagain.get("mobile_no")+"\r\n"+"Department :"+datagain.get("department")+"\r\n"+
                "Designation :"+datagain.get("designation"), Toast.LENGTH_SHORT).show();
    }
}
