package com.example.mohitsaini.fragmentexample.part_1;

/**
 * Created by mohitsaini on 2/1/17.
 */

public class Movie {

    String name, email_id, mobile_no, department, designation;

    public Movie() {
    }

    public Movie(String name, String email_id, String mobile_no, String department, String designation) {
        this.name = name;
        this.email_id = email_id;
        this.mobile_no = mobile_no;
        this.department= department;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
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