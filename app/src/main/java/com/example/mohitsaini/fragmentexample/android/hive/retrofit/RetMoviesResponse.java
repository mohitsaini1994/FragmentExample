package com.example.mohitsaini.fragmentexample.android.hive.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mohitsaini on 7/1/17.
 */

public class RetMoviesResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<RetMovie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<RetMovie> getResults() {
        return results;
    }

    public void setResults(List<RetMovie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
