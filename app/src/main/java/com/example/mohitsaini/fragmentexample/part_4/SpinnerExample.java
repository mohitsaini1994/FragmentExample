package com.example.mohitsaini.fragmentexample.part_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 12/6/17.
 */

public class SpinnerExample extends AppCompatActivity implements Spinner.OnItemSelectedListener {

    String cat, subCat, lastCat;
    private Spinner spinner1, spinner2, spinner3;
    //JSON Array
    private TextView category;
    private TextView sub_category;
    private TextView last_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_example);

        //Initializing Spinner
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        //Adding an Item Selected Listener to our Spinner
        //As we have implemented the class Spinner.OnItemSelectedListener to this class iteself we are passing this to setOnItemSelectedListener
        spinner1.setOnItemSelectedListener(SpinnerExample.this);
        spinner2.setOnItemSelectedListener(SpinnerExample.this);
        spinner3.setOnItemSelectedListener(SpinnerExample.this);


        //Initializing TextViews
        category = (TextView) findViewById(R.id.textViewName);
        sub_category = (TextView) findViewById(R.id.textViewCourse);
        last_category = (TextView) findViewById(R.id.textViewSession);

        //This method will fetch the data from the URL
        getData();
    }

    private void getData() {
        getFirstList(SpinnerUtils.cat);
    }

    private void getFirstList(String[] cat) {
        spinner1.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                android.R.layout.simple_spinner_dropdown_item, cat));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner1:
                if(spinner1.toString().contains("Select")){

                }
                spinner2.setVisibility(View.VISIBLE);
                cat = SpinnerUtils.cat[position];
                getSecondList(cat);
                break;
            case R.id.spinner2:
                if(spinner2.toString().contains("Select")){

                }
                spinner3.setVisibility(View.VISIBLE);
                subCat = spinner2.getSelectedItem().toString();
                getThirdList(subCat);
                break;
            case R.id.spinner3:
                if(spinner3.toString().contains("Select")){

                }
                lastCat = spinner3.getSelectedItem().toString();
                category.setText(cat);
                sub_category.setText(subCat);
                last_category.setText(lastCat);
                break;
        }

    }

    //When no item is selected this method would execute
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        category.setText("");
        sub_category.setText("");
        last_category.setText("");
    }

    private void getSecondList(String cat) {
        switch (cat) {
            case "A":
                spinner2.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA));
                break;
            case "B":
                spinner2.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB));
                break;
            case "C":
                spinner2.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC));
                break;
            case "D":
                spinner2.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catD));
                break;
            case "E":
                spinner2.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catE));
                break;
        }

    }

    private void getThirdList(String cat) {
        switch (cat) {
            case "A1":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA1));
                break;
            case "A2":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA2));
                break;
            case "A3":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA3));
                break;
            case "A4":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA4));
                break;
            case "A5":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA5));
                break;
            case "A6":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA6));
                break;
            case "A7":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA7));
                break;
            case "A8":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA8));
                break;
            case "A9":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA9));
                break;
            case "A10":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catA10));
                break;
            case "B1":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB1));
                break;
            case "B2":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB2));
                break;
            case "B3":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB3));
                break;
            case "B4":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB4));
                break;
            case "B5":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB5));
                break;
            case "B6":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB6));
                break;
            case "B7":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB7));
                break;
            case "B8":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catB8));
                break;
            case "C1":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC1));
                break;
            case "C2":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC2));
                break;
            case "C3":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC3));
                break;
            case "C4":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC4));
                break;
            case "C5":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC5));
                break;
            case "C6":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC6));
                break;
            case "C7":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC7));
                break;
            case "C8":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC8));
                break;
            case "C9":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC9));
                break;
            case "C10":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC10));
                break;
            case "C11":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catC11));
                break;
            case "D1":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catD1));
                break;
            case "D2":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catD2));
                break;
            case "D3":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catD3));
                break;
            case "D4":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catD4));
                break;
            case "D5":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catD5));
                break;
            case "D6":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catD6));
                break;
            case "E1":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catE1));
                break;
            case "E2":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catE2));
                break;
            case "E3":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catE3));
                break;
            case "E4":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catE4));
                break;
            case "E5":
                spinner3.setAdapter(new ArrayAdapter<>(SpinnerExample.this,
                        android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.catE5));
                break;
        }
    }
}