package com.example.mohitsaini.fragmentexample.android.picasso;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;
import com.squareup.picasso.Picasso;

/**
 * Created by mohitsaini on 19/1/17.
 */
//http://stackoverflow.com/questions/29259726/loading-multiple-images-with-picasso-on-background

public class PicassoSimple extends AppCompatActivity{

    ImageView imageView;
    TextView textView;
    private final String actress_name[] = {
            "Parineeti Chopra",
            "Ayesha Takia",
            "Parineeti Chopra", "Parineeti Chopra",
            "Kriti Sanon",
            "Parineeti Chopra", "Parineeti Chopra",
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
    Picasso picasso;
    int c = 0;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picasso_screen);

        imageView = (ImageView)findViewById(R.id.picasso_imageView);
        textView = (TextView)findViewById(R.id.picasso_title);

        picasso = Picasso.with(this);
        setUrl();

        imageView.setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onSwipeLeft() {
//                Toast.makeText(PicassoSimple.this, "left", Toast.LENGTH_SHORT).show();
                if(c<actress_name.length-1){
                    c++;
                    setUrl();
                }
            }
            @Override
            public void onSwipeRight() {
//                Toast.makeText(PicassoSimple.this, "right", Toast.LENGTH_SHORT).show();
                if(c>0){
                    c--;
                    setUrl();
                }
            }
        });
    }
    public void setUrl(){
        picasso.load(""+actress_url[c])
                    .into(imageView);
        textView.setText(actress_name[c]);
    }
}
