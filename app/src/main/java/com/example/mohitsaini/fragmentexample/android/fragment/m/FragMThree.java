package com.example.mohitsaini.fragmentexample.android.fragment.m;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 31/1/17.
 */

public class FragMThree extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_m_layout, container, false);
        TextView textView = (TextView)view.findViewById(R.id.fragment_m_tv);
        textView.setText("3");
        return view;

    }
}
