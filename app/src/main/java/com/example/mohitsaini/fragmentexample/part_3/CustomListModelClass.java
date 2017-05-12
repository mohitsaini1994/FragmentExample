package com.example.mohitsaini.fragmentexample.part_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitsaini on 11/5/17.
 */

public class CustomListModelClass {

    String data;
    String ischecked="";

//    static boolean saveData = true;
//    private static List<CustomListModelClass> saveList;


    public String getIschecked() {
        return ischecked;
    }

    public void setIschecked(String ischecked) {
        this.ischecked = ischecked;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


//    public static List<CustomListModelClass> getSaveList() {
//        return saveList;
//    }
//
//    public static void setSaveList(List<CustomListModelClass> saveList) {
//        CustomListModelClass.saveList = saveList;
//    }
//
//    public static boolean isSaveData() {
//        return saveData;
//    }
//
//    public static void setSaveData(boolean saveData) {
//        CustomListModelClass.saveData = saveData;
//    }
}
