package com.example.mohitsaini.fragmentexample.part_1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mohitsaini.fragmentexample.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohitsaini on 30/12/16.
 */

public class RegisterActivity extends AppCompatActivity {
    static final String url = "http://mpsandroidx.tk/webserver/login.php";
    EditText user, pswd;
    Button login;
    ProgressDialog pDialog;
    String TAG = "RegistrationActivity";
    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        user = (EditText) findViewById(R.id.user);
        pswd = (EditText) findViewById(R.id.pswd);
        login = (Button) findViewById(R.id.login);

        pDialog = new ProgressDialog(this);
        mRequestQueue = Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().trim().equalsIgnoreCase("")) {
                    user.setError("Please enter firstname");
                } else if (pswd.getText().toString().trim().equalsIgnoreCase("")) {
                    pswd.setError("Please enter Password");
                } else {
                    registerationtask(user.getText().toString().trim(), pswd.getText().toString().trim());
                }
            }
        });
    }

    public void registerationtask(final String username, final String password) {

        pDialog.setMessage("Registering...");
        pDialog.show();

        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                VolleyLog.d(TAG, "Error: " + response.toString());

                JSONObject jsonObject1 = null;
                try {
                    jsonObject1 = new JSONObject(response.toString());
                } catch (JSONException e) {
                }

                String jsonresponse = jsonObject1.optString("success");
                String jsonmessage = jsonObject1.optString("message");

                if (jsonresponse.toString().equals("1")) {
                    Toast.makeText(RegisterActivity.this, "it's happend", Toast.LENGTH_SHORT).show();
                } else if (jsonresponse.toString().equals("0"))
                    Toast.makeText(RegisterActivity.this, "" + jsonmessage.toString(), Toast.LENGTH_SHORT).show();
                pDialog.hide();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.hide();
                Toast.makeText(RegisterActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);

                return params;
            }
        };
        // Adding request to request queue
        mRequestQueue.add(sr);
    }
}