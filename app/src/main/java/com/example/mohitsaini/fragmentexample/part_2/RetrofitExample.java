package com.example.mohitsaini.fragmentexample.part_2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;
import com.example.mohitsaini.fragmentexample.part_1.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by mohitsaini on 7/1/17.
 */

/*for any query go to the below link
*  https://www.simplifiedcoding.net/retrofit-android-tutorial-to-get-json-from-server/#stq=&stp=0
*/

public class RetrofitExample extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Root URL of our web service
    public static final String ROOT_URL = "http://mpsandroidx.tk/";

    private ListView listView;
    private List<Movie> data;
    ArrayList<HashMap<String, String>> dataList;

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

        //creating the restadapter
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        //creating a object of our interface
        RetrofitApi api = restAdapter.create(RetrofitApi.class);

        api.getData(new Callback<List<Movie>>() {
            @Override
            public void success(List<Movie> list, Response response) {
                progressDialog.dismiss();

                data = list;
                Toast.makeText(RetrofitExample.this, "datra dome", Toast.LENGTH_SHORT).show();

                showListData();
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
                Toast.makeText(RetrofitExample.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showListData(){
        for (int i=0; i<data.size(); i++){
            Movie movie= data.get(i);

            HashMap<String, String> dataHash = new HashMap<>();
            dataHash.put("name", movie.getName());
            dataHash.put("email_id", movie.getEmail_id());
            dataHash.put("mobile_no", movie.getMobile_no());
            dataHash.put("department", movie.getDepartment());
            dataHash.put("designation", movie.getDesignation());

            dataList.add(dataHash);
        }
        ListAdapter adapter = new SimpleAdapter(
                RetrofitExample.this, dataList,
                R.layout.my_single_view, new String[]{"name", "email_id",
                "mobile_no", "department", "designation"}, new int[]{R.id.tvv1,
                R.id.tvv2, R.id.tvv3, R.id.tvv4, R.id.tvv5});
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        HashMap<String, String> datagain = dataList.get(i);
        Toast.makeText(RetrofitExample.this, "Name: "+datagain.get("name")+"\r\n"+"Email ID: "+datagain.get("email_id")+"\r\n"
                +"Mobile No.: "+datagain.get("mobile_no")+"\r\n"+"Department :"+datagain.get("department")+"\r\n"+
                "Designation :"+datagain.get("designation"), Toast.LENGTH_SHORT).show();
    }
}
