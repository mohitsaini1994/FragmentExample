package com.example.mohitsaini.fragmentexample.part_1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
import java.util.HashMap;

/**
 * Created by mohitsaini on 17/12/16.
 */

public class MyJSONExample extends AppCompatActivity {

    static final String url = "http://mpsandroidx.tk/json_encoded/show_faculty.php";
    //    Button button;
    MyJSONSingleton myJSONSingleton;

    ArrayList<HashMap<String, String>> dataList;
    ListView lv;
    RecyclerView card_recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);
        dataList = new ArrayList<>();
        lv = (ListView)findViewById(R.id.lv);
        card_recycler_view = (RecyclerView)findViewById(R.id.card_recycler_view);
        card_recycler_view.setVisibility(View.GONE);

        myJSONSingleton = MyJSONSingleton.getInstance(getApplicationContext());

        StringRequest stringWinRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("posts");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

//                        String name, email_id, mobile_no, department, designation;
                        myJSONSingleton.setName(jsonObject1.getString("name"));
                        myJSONSingleton.setEmail_id(jsonObject1.getString("email_id"));
                        myJSONSingleton.setMobile_no(jsonObject1.getString("mobile_no"));
                        myJSONSingleton.setDepartment(jsonObject1.getString("department"));
                        myJSONSingleton.setDesignation(jsonObject1.getString("designation"));

                        HashMap<String, String> data = new HashMap<>();

                        data.put("name", myJSONSingleton.getName());
                        data.put("email_id", myJSONSingleton.getEmail_id());
                        data.put("mobile_no", myJSONSingleton.getMobile_no());
                        data.put("department", myJSONSingleton.getDepartment());
                        data.put("designation", myJSONSingleton.getDesignation());

                        dataList.add(data);
                    }
                    ListAdapter adapter = new SimpleAdapter(
                            MyJSONExample.this, dataList,
                            R.layout.my_single_view, new String[]{"name", "email_id",
                            "mobile_no", "department", "designation"}, new int[]{R.id.tvv1,
                            R.id.tvv2, R.id.tvv3, R.id.tvv4, R.id.tvv5});
                    lv.setAdapter(adapter);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            HashMap<String, String> datagain = dataList.get(i);
                            Toast.makeText(MyJSONExample.this, "Name: "+datagain.get("name")+"\r\n"+"Email ID: "+datagain.get("email_id")+"\r\n"
                                    +"Mobile No.: "+datagain.get("mobile_no")+"\r\n"+"Department :"+datagain.get("department")+"\r\n"+
                                    "Designation :"+datagain.get("designation"), Toast.LENGTH_SHORT).show();
                        }
                    });
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
