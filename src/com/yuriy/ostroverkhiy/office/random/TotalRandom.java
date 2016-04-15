package com.yuriy.ostroverkhiy.office.random;


import java.util.ArrayList;

public class TotalRandom {
    public static ArrayList<Integer> rand(int number, int min, int max) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            arrayList.add((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return arrayList;
    }
}
