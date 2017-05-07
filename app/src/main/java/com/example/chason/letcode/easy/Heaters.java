package com.example.chason.letcode.easy;

import java.util.Arrays;

/**
 * Created by chason on 17-4-24.
 */

public class Heaters {
    public static void main(String[] args) {

    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int[] newHouses = new int[houses[houses.length - 1]];
        int[] newHeaters = new int[heaters[heaters.length - 1]];
        for (int i : houses) {
          if (newHouses[i] == 0){
              newHouses[i] = 1;
          }
        }
        for (int i : heaters) {
            if (newHeaters[i] == 0){
                newHeaters[i] = 1;
            }
        }
        houses = newHouses;
        heaters = newHeaters;
        // TODO: 17-4-24 UnSolved
        int minRadio = 0;
        for (int i = 0 ;i<houses.length;i++){

        }
        return -1;
    }
}
