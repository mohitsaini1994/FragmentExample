package com.example.mohitsaini.fragmentexample.part_2;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by mohitsaini on 14/1/17.
 */
//http://www.androidhive.info/2012/01/android-json-parsing-tutorial/
public class HttpHandler {

    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler() {
    }

    public String makeServiceCall(String reqUrl) {
        String response = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
/*
* protected String doInBackground(String... params) {
   // TODO Auto-generated method stub
   ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
                 postParameters.add(new BasicNameValuePair("username", params[0] ));
                 postParameters.add(new BasicNameValuePair("password", params[1] ));
                 String res = null;
         try {
            response = CustomHttpClient.executeHttpPost("http://akinads.0fees.net/check.php", postParameters);
            res=response.toString();
            res= res.replaceAll("\\s+","");
         }
         catch (Exception e) {
          txt_Error.setText(e.toString());
         }
   return res;
  }
 */