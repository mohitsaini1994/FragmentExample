package com.example.mohitsaini.fragmentexample.part_2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mohitsaini on 14/1/17.
 */

public class AsyncTaskExample extends AppCompatActivity{
    String jsonStr;

    private String TAG = AsyncTaskExample.class.getSimpleName();

    private ProgressDialog progressDialog;
    private ListView lv;

//    private static String url = "http://mpsandroidx.tk/json_encoded/show_faculty.php";

    private static String url = "http://api.androidhive.info/contacts/";

    ArrayList<HashMap<String, String>> dataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);

        dataList = new ArrayList<>();
        lv = (ListView)findViewById(R.id.lv);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setVisibility(View.GONE);

        new GetData().execute();
    }

    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(AsyncTaskExample.this);
            progressDialog.setMessage("Please wait.....");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();

            //making a request to url & getting response
            jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if(jsonStr != null){
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray jsonArray = jsonObject.getJSONArray("posts");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

//                        String name, email_id, mobile_no, department, designation;
                        String name = jsonObject1.getString("name");
                        String email_id = jsonObject1.getString("email_id");
                        String mobile_no = jsonObject1.getString("mobile_no");
                        String department = jsonObject1.getString("department");
                        String designation = jsonObject1.getString("designation");

                        HashMap<String, String> data = new HashMap<>();

                        data.put("name", name);
                        data.put("email_id", email_id);
                        data.put("mobile_no", mobile_no);
                        data.put("department", department);
                        data.put("designation", designation);

                        dataList.add(data);
                    }

                }catch (final JSONException e){
                    Log.e(TAG, "JSON response error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AsyncTaskExample.this, "JSON response error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }else {
                Log.e(TAG, "Couldn't get json from server..");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AsyncTaskExample.this, "Couldn't get json from server. Check LogCat for possible errors!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            ListAdapter adapter = new SimpleAdapter(
                    AsyncTaskExample.this, dataList,
                    R.layout.my_single_view, new String[]{"name", "email_id",
                    "mobile_no", "department", "designation"}, new int[]{R.id.tvv1,
                    R.id.tvv2, R.id.tvv3, R.id.tvv4, R.id.tvv5});
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    HashMap<String, String> datagain = dataList.get(i);
                    Toast.makeText(AsyncTaskExample.this, "Name: "+datagain.get("name")+"\r\n"+"Email ID: "+datagain.get("email_id")+"\r\n"
                            +"Mobile No.: "+datagain.get("mobile_no")+"\r\n"+"Department :"+datagain.get("department")+"\r\n"+
                            "Designation :"+datagain.get("designation"), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
