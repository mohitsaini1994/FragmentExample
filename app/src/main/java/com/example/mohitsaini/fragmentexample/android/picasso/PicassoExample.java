package com.example.mohitsaini.fragmentexample.android.picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;

//https://www.learn2crack.com/2016/02/image-loading-recyclerview-picasso.html
public class PicassoExample extends AppCompatActivity {

    private final String actress_name[] = {
            "Parineeti Chopra",
            "Ayesha Takia",
            "Parineeti Chopra",
            "Parineeti Chopra",
            "Kriti Sanon",
            "Parineeti Chopra",
            "Parineeti Chopra",
            "Kriti Sanon",
            "Ayesha Takia",
            "Parineeti Chopra"
    };

    private final String actress_url[] = {
            "http://mpsandroidx.tk/pictures/1.JPG",
            "http://mpsandroidx.tk/pictures/2.JPG",
            "http://mpsandroidx.tk/pictures/3.JPG",
            "http://mpsandroidx.tk/pictures/4.jpg",
            "http://mpsandroidx.tk/pictures/5.jpg",
            "http://mpsandroidx.tk/pictures/6.jpg",
            "http://mpsandroidx.tk/pictures/7.JPG",
            "http://mpsandroidx.tk/pictures/8.jpg",
            "http://mpsandroidx.tk/pictures/9.jpg",
            "http://mpsandroidx.tk/pictures/10.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_example);

        initview();
    }

    private void initview() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList actress = prepareData();
        PicassoDataAdapter adapter = new PicassoDataAdapter(getApplicationContext(),actress);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList prepareData() {
        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<actress_name.length;i++){
            PicassoDataModel androidVersion = new PicassoDataModel();
            androidVersion.setTitle(actress_name[i]);
            androidVersion.setImage_url(actress_url[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
