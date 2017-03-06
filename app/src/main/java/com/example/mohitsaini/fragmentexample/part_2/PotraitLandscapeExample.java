package com.example.mohitsaini.fragmentexample.part_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 6/1/17.
 */

public class PotraitLandscapeExample extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potrait_landscape_example);
        TextView textView = (TextView) findViewById(R.id.potraitextViewtextView);
        textView.setText("There are multiple ways to do it. If you have the string " +
                "which you want to replace you can use the replace or replaceAll methods " +
                "of the String class. If you are looking to replace a substring you can " +
                "get the substring using the substring API.");
    }
}
