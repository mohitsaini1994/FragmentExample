package com.example.mohitsaini.fragmentexample.part_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.mohitsaini.fragmentexample.MainList;
import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitsaini on 2/5/17.
 */

public class CustomListClickable extends AppCompatActivity {

    ListView listView;

    MainList mainList1 = new MainList();
    String[] list = mainList1.list;

    CustomListClIckableAdapter mAdapter;
    List<String> mListData;
    List<CustomListModelClass> mainList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);

        listView = (ListView) findViewById(R.id.lv);
        mListData = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            mListData.add(list[i]);
        }
        Log.e("FINAL DATA  = ", mListData.toString());
        for (int i = 0; i < mListData.size(); i++) {
            CustomListModelClass customListModelClass = new CustomListModelClass();
            customListModelClass.setData(mListData.get(i));
            customListModelClass.setIschecked("");
            mainList.add(customListModelClass);
        }

        if (CustomListSavable.isSaveData()) {
            mAdapter = new CustomListClIckableAdapter(this, mainList);
        } else {
            mAdapter = new CustomListClIckableAdapter(this, CustomListSavable.getSaveList());
        }

        listView.setAdapter(mAdapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (CustomListSavable.isSaveData()) {
            CustomListSavable.setSaveList(mainList);
            CustomListSavable.setSaveData(false);
//        }
    }
}
