package com.example.mohitsaini.fragmentexample.part_1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 27/12/16.
 */

public class ReceiverFragment extends Fragment implements CommunicationChannel {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout_1, container, false);
        return view;
    }

    void setReceivedText(String msg) {
        TextView textView = (TextView) this.getView().findViewById(R.id.textView1);
        textView.setText(msg);
    }

    @Override
    public void setCommunication(String msg) {
        Toast.makeText(getActivity(), "From Fragment", Toast.LENGTH_SHORT).show();
        TextView textView = (TextView) this.getView().findViewById(R.id.textView1);
        textView.setText(msg);
    }

    @Override
    public boolean findNumber() {
        return true;
    }

    @Override
    public String greet() {
        return null;
    }
}
