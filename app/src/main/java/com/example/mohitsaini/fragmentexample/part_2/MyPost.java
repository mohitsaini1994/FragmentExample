package com.example.mohitsaini.fragmentexample.part_2;

/**
 * Created by mohitsaini on 7/1/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPost {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email_id")
    @Expose
    private String emailId;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("designation")
    @Expose
    private String designation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
