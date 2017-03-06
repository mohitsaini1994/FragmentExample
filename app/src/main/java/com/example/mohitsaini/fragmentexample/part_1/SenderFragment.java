package com.example.mohitsaini.fragmentexample.part_1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 27/12/16.
 */

public class SenderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_layout_2, container);
        final EditText editText = (EditText) view.findViewById(R.id.editText1);
        Button mButton = (Button) view.findViewById(R.id.button1);
        Button oButton = (Button) view.findViewById(R.id.button3);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String str = editText.getText().toString();

                CommunicationChannel communicationChannel = (CommunicationChannel) getActivity();
                boolean status = communicationChannel.findNumber();
                communicationChannel.setCommunication(str);

                if(status){
                    Toast.makeText(getActivity(), "true", Toast.LENGTH_SHORT).show();
                    communicationChannel.setCommunication(str);
                } else {
                    Toast.makeText(getActivity(), "false", Toast.LENGTH_SHORT).show();
                    CommunicationChannel communicationChannel1 = (CommunicationChannel)getFragmentManager()
                            .findFragmentById(R.id.fragment1);
                    communicationChannel1.setCommunication(str);
                }
            }
        });
        oButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                from fragment directly
                String str = editText.getText().toString();

                ReceiverFragment recFragment = (ReceiverFragment)getFragmentManager().findFragmentById(R.id.fragment1);
                recFragment.setReceivedText(str);
            }
        });
        return view;
    }
}
