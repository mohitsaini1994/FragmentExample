package com.example.mohitsaini.fragmentexample.part_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 28/12/16.
 */

public class AnonymousInnerClassExample extends AppCompatActivity {
    TextView ITV;
    Button IB,IB2;
    Myclass myclass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anonymous_inner_class_example);

        ITV = (TextView) findViewById(R.id.innerTV);
        IB = (Button) findViewById(R.id.innerButton);
        IB2 = (Button) findViewById(R.id.innerButton2);

        myclass = new Myclass();

        IB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myclass.passThe(new CommunicationChannel() {
                    @Override
                    public void setCommunication(String msg) {}
                    @Override
                    public boolean findNumber() {
                        return false;
                    }

                    @Override
                    public String greet() {
                        return "hellllo--------1";
                    }
                });
            }
        });
        IB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ITV.setText(communicationChannel.greet());
            }
        });
    }
    CommunicationChannel communicationChannel = new CommunicationChannel() {
        @Override
        public void setCommunication(String msg) {}
        @Override
        public boolean findNumber() {
            return false;
        }
        @Override
        public String greet() {
            return "hellllo--------2";
        }
    };

    class Myclass {
        public void passThe(CommunicationChannel msdg) {
            ITV.setText("" + msdg.greet());
//            return "hello";
        }
    }
}
