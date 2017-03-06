package com.example.mohitsaini.fragmentexample.part_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity implements CommunicationChannel {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void setCommunication(String msg) {
        // TODO Auto-generated method stub
        ReceiverFragment recFragment = (ReceiverFragment)getFragmentManager().findFragmentById(R.id.fragment1);
        if(null != recFragment  && recFragment.isInLayout()) {
            Toast.makeText(MainActivity2.this, "From Activity", Toast.LENGTH_SHORT).show();
            recFragment.setReceivedText(msg);
        }
    }

    @Override
    public boolean findNumber() {
        Random rand = new Random();
        int n = rand.nextInt(50);
        if ( n % 2 == 0 ){
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public String greet() {
        return null;
    }
}