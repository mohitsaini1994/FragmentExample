package com.example.mohitsaini.fragmentexample.part_2;

/**
 * Created by mohitsaini on 7/1/17.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyJsonRetrofit {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("posts")
    @Expose
    private List<MyPost> posts = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MyPost> getPosts() {
        return posts;
    }

    public void setPosts(List<MyPost> posts) {
        this.posts = posts;
    }

}