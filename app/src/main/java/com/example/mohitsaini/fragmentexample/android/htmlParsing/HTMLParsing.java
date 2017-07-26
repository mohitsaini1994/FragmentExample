package com.example.mohitsaini.fragmentexample.android.htmlParsing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mohitsaini.fragmentexample.R;
import com.example.mohitsaini.fragmentexample.part_1.MyJSONSingleton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by mohitsaini on 10/7/17.
 */

public class HTMLParsing extends AppCompatActivity {
//    static final String url = "https://jsoup.org/cookbook/input/parse-document-from-string";
//    static final String url = "https://www.survivingwithandroid.com/2014/02/android-weather-app-tutorial-step-by.html";
    String url = "https://www.gktoday.in/gk-current-affairs-quiz-july-8-9-2017/";
//    String url = "http://www.petroldieselprice.com/petrol-diesel-lpg-cng-fuel-oil-price" +
//            "/Pratapgarh-City/Sadar/Pratapgarh/Uttar-Pradesh/230002";
//    String url = "http://www.google.com";
    EditText start_date, end_date, no_of_nights;
    TextView tv_calender_with_future;
    MyJSONSingleton myJSONSingleton;
    Document doc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_with_only_future_date);
        myJSONSingleton = MyJSONSingleton.getInstance(HTMLParsing.this);

        start_date = (EditText) findViewById(R.id.start_date);
        end_date = (EditText) findViewById(R.id.end_date);
        no_of_nights = (EditText) findViewById(R.id.no_of_nights);
        tv_calender_with_future = (TextView) findViewById(R.id.tv_calender_with_future);

        end_date.setVisibility(View.GONE);
        start_date.setVisibility(View.GONE);
        no_of_nights.setVisibility(View.GONE);
        tv_calender_with_future.setVisibility(View.VISIBLE);

        getData();
//        (new ParseURL() ).execute(new String[]{url});
//        (new htmlWithAsyncTask() ).execute(new String[]{url});
    }

    private void getData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(HTMLParsing.this, "done", Toast.LENGTH_SHORT).show();
                tv_calender_with_future.setText("" + response);
//                Log.i("HTML------>>>", "" + response);
                doc = Jsoup.parse(response);
                Toast.makeText(HTMLParsing.this, "---> " + doc.title(), Toast.LENGTH_SHORT).show();

                fetchAllData();
//                fetchPrice();
                again();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HTMLParsing.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        myJSONSingleton.getRequestQueue().add(stringRequest);
    }

    private void again() {
        getData();
    }

//    private void fetchPrice() {
//        Elements price = doc.getElementsByClass("shop_table");
////        for (int ii=0;ii<price.size();ii++){
//
//            Toast.makeText(this, "dflgjkhsdiu", Toast.LENGTH_SHORT).show();
////            String dpc = price.toString().trim();
//            String data = price.get(0).getElementsByClass("cart-subtotal").toString().trim();
////            Log.i("---------<<<", data);
////            Toast.makeText(this, ""+price.size(), Toast.LENGTH_SHORT).show();
//        Elements todayPrice = price.get(0).getElementsByClass("amount");
//        String finalTodayPricePatrol = todayPrice.get(2).getElementsByClass("amount").text();
//        String finalTodayPriceDiesel = todayPrice.get(3).getElementsByClass("amount").text();
//        Log.i("Today Price Petrol---->", finalTodayPricePatrol);
//        Log.i("Today Price Diesel---->", finalTodayPriceDiesel);
////        }
//    }

    private void fetchAllData() {
        Elements document = doc.getElementsByClass("sques_quiz");
        String html = "";
        for (int i = 0; i < document.size(); i++) {
//            String data = document.get(i).getElementsByTag("div").toString().trim();
//            tv_calender_with_future.setText(data);

            String que = document.get(i).getElementsByClass("wp_quiz_question").text();
            String opt = document.get(i).getElementsByClass("wp_quiz_question_options").toString().trim();

//            for (int j=0;j<opt.size();j++){
//
//            }


//            Log.i("---->>", que);/
//            Log.i("---->>", opt);

        }
        Elements links = doc.select("a[href]");
        int counter = 0;
        String shortLink = "https://www.gktoday.in/gk-current-affairs-quiz";
        for (int j = 0; j < links.size(); j++) {
            String chk = links.get(j).toString().trim();
            if (chk.contains(shortLink)) {
//                Log.i("----0--->", links.get(j).toString().trim());
                counter = j;
            }
        }
//        Log.i("-------->>>>>>", String.valueOf(counter));
        for (int k = 0; k < links.size(); k++) {
            String link = links.get(k).toString().trim();
            if (link.contains("Next Quiz")) {
                html = links.get(k).outerHtml().toString();
                Elements finalHTML = links.get(k).getAllElements();
                url = finalHTML.attr("href");
                Log.i("---11----->>>>>>", url);
            }
        }

//        Log.i("---11----->>>>>>", html);
    }

}
//    private class ParseURL extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... strings) {
//            StringBuffer buffer = new StringBuffer();
//            try {
//                Log.d("JSwa", "Connecting to [" + strings[0] + "]");
//                Document doc = Jsoup.connect(strings[0]).get();
//                Log.d("JSwa", "Connected to [" + strings[0] + "]");
//                // Get document (HTML page) title
//                String title = doc.title();
//                Log.d("JSwA", "Title [" + title + "]");
//                buffer.append("Title: " + title + "rn");
//                // Get meta info
//                Elements metaElems = doc.select("meta");
//                buffer.append("META DATArn");
//                for (Element metaElem : metaElems) {
//                    String name = metaElem.attr("name");
//                    String content = metaElem.attr("content");
//                    buffer.append("name [" + name + "] - content [" + content + "] rn");
//                }
//                Elements topicList = doc.select("h2.topic");
//                buffer.append("Topic listrn");
//                for (Element topic : topicList) {
//                    String data = topic.text();
//                    buffer.append("Data [" + data + "] rn");
//                }
//            } catch (Throwable t) {
//                t.printStackTrace();
//            }
//            return buffer.toString();
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            tv_calender_with_future.setText(s);
//            Toast.makeText(HTMLParsing.this, "" + s, Toast.LENGTH_SHORT).show();
//        }
//    }

//class htmlWithAsyncTask extends AsyncTask<String, Void, String>{
//    @Override
//    protected String doInBackground(String... strings) {
//        try {
//            Document ascyncDoc = Jsoup.connect(strings[0]).get();
//            asyncFetchPrice(ascyncDoc);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private void asyncFetchPrice(Document ascyncDoc) {
//        Elements price = ascyncDoc.getElementsByClass("shop_table");
////        for (int ii=0;ii<price.size();ii++){
//
////            String dpc = price.toString().trim();
//        String data = price.get(0).getElementsByClass("cart-subtotal").toString().trim();
////            Log.i("---------<<<", data);
////            Toast.makeText(this, ""+price.size(), Toast.LENGTH_SHORT).show();
//        Elements todayPrice = price.get(0).getElementsByClass("amount");
//        String finalTodayPricePatrol = todayPrice.get(2).getElementsByClass("amount").text();
//        String finalTodayPriceDiesel = todayPrice.get(3).getElementsByClass("amount").text();
//        Log.i("Today Price Petrol---->", finalTodayPricePatrol);
//        Log.i("Today Price Diesel---->", finalTodayPriceDiesel);
////        }
//    }
//}
