package com.example.mohitsaini.fragmentexample.part_3;

import java.util.List;

/**
 * Created by mohitsaini on 13/5/17.
 */

public class CustomListSavable {

    static boolean saveData = true;
    private static List<CustomListModelClass> saveList;

    public static boolean isSaveData() {
        return saveData;
    }

    public static void setSaveData(boolean saveData) {
        CustomListSavable.saveData = saveData;
    }

    public static List<CustomListModelClass> getSaveList() {
        return saveList;
    }

    public static void setSaveList(List<CustomListModelClass> saveList) {
        CustomListSavable.saveList = saveList;
    }
}
