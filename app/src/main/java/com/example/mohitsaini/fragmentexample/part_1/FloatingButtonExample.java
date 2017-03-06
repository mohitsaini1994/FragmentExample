package com.example.mohitsaini.fragmentexample.part_1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;
import com.example.mohitsaini.fragmentexample.android.picasso.OnSwipeTouchListener;

/**
 * Created by mohitsaini on 5/1/17.
 */

public class FloatingButtonExample extends AppCompatActivity{
String regex="[a-zA-Z]+";
    int length=0;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_button_example);

        editText= (EditText)findViewById(R.id.textwatcher_example);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Toast.makeText(FloatingButtonExample.this, "before", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // Toast.makeText(FloatingButtonExample.this, "on", Toast.LENGTH_SHORT).show();
                length=charSequence.length();
                String editableText=editText.getText().toString().trim();
                String text="";
                if(!editableText.matches(regex)){
                    if(length<4) {
                        editText.setError("please enter a alphabet");
                    }
                }
                if(length>2){
                    if(editableText.length()>2){
                        text=editableText.substring(3);
                    }
                    if(!text.matches(regex)||text.equals("")){;
                        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    }
                    else{
                        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                    }
                } else{
                    editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
               // Toast.makeText(FloatingButtonExample.this, "after", Toast.LENGTH_SHORT).show();
            }
        });

        // for adding the back button to the action bar
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("FloatingButtonExample");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Toast.makeText(FloatingButtonExample.this, "button done", Toast.LENGTH_SHORT).show();
                Toast toast = new Toast(FloatingButtonExample.this);
                ImageView view1 = new ImageView(FloatingButtonExample.this);
                view1.setImageResource(R.mipmap.ic_launcher);
                toast.setView(view1);
                toast.show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
