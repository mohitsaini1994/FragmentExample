package com.example.mohitsaini.fragmentexample.part_3.clickable.list;

/**
 * Created by rahultripathi on 8/5/17.
 */

public class NewModel {

    String heading;
    private boolean isApprovedChecked = false;
    private boolean isDisapproveChecked = false;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public boolean isApprovedChecked() {
        return isApprovedChecked;
    }

    public void setApprovedChecked(boolean approvedChecked) {
        isApprovedChecked = approvedChecked;
    }

    public boolean isDisapproveChecked() {
        return isDisapproveChecked;
    }

    public void setDisapproveChecked(boolean disapproveChecked) {
        isDisapproveChecked = disapproveChecked;
    }

}
