package com.example.mohitsaini.fragmentexample.android.fragment.m;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mohitsaini.fragmentexample.R;


public class FragmentM extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2;
    int counter = 1;

    FragMOne fragMOne = new FragMOne();
    FragMTwo fragMTwo = new FragMTwo();
    FragMThree fragMThree = new FragMThree();
    FragMFour fragMFour = new FragMFour();

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_m);

        b1 = (Button) findViewById(R.id.m_frag_next);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.m_frag_one);
        b2.setOnClickListener(this);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.m_frag_cont, fragMOne);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.m_frag_next:
                counter++;
                setFragmentOnView(counter);
                break;
            case R.id.m_frag_one:
                counter = 1;
                setFragmentOnView(counter);
                break;
        }
    }

    private void setFragmentOnView(int counter) {
        if (counter == 1) {
            getFragmentManager().beginTransaction().replace(R.id.m_frag_cont, fragMOne).commit();
        } else if (counter == 2) {
            getFragmentManager().beginTransaction().replace(R.id.m_frag_cont, fragMTwo).commit();
        } else if (counter == 3) {
            getFragmentManager().beginTransaction().replace(R.id.m_frag_cont, fragMThree).commit();
        } else if (counter == 4) {
            getFragmentManager().beginTransaction().replace(R.id.m_frag_cont, fragMFour).commit();
        } else
            return;
    }
}
