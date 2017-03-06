package com.example.mohitsaini.fragmentexample.android.picasso;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mohitsaini on 19/1/17.
 */

public class PicassoDataModel {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    private String image_url;

}
