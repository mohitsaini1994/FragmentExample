package com.example.mohitsaini.fragmentexample.part_1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mohitsaini.fragmentexample.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    static final String url = "http://api.androidhive.info/volley/person_object.json";
    TextView textView1,textview2,textview3;
    MySingleton singleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1= (TextView) findViewById(R.id.textview1);
        textview2= (TextView) findViewById(R.id.textview2);
        textview3= (TextView) findViewById(R.id.textview3);

        singleton=MySingleton.getInstance(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObj = new JSONObject(response);
                    String email = jsonObj.getString("email");
                    JSONObject jsonOb=jsonObj.getJSONObject("phone");
                    String phone=jsonOb.getString("home");
                    String mobile=jsonOb.getString("mobile");

                    singleton.setEmail(email);
                    singleton.setPhone(phone);
                    singleton.setMobile(mobile);

                    textView1.setText(singleton.getEmail());
                    textview2.setText(singleton.getPhone());
                    textview3.setText(singleton.getPhone());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        singleton.getRequestQueue().add(stringRequest);
    }
}
