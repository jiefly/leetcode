package com.example.chason.letcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chason on 17-4-23.
 */

public class FizzBuzz {
    public static void main(String[] args){
        List<String> result = new FizzBuzz().fizzBuzz(10);
        for (String s:result){
            System.out.println(s);
        }
    }

    public List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<>(n);
        for (int i=1;i<n+1;i++){
            if ((i & 0x1) == 1){
                if ((i % 15) == 0){
                    result.add("FizzBuzz");
                    continue;
                }else if ((i % 3) == 0){
                    result.add("Fizz");
                    continue;
                }else if ((i % 5) == 0){
                    result.add("Buzz");
                    continue;
                }
            }
            result.add(String.valueOf(i));
        }
        return result;
    }
}
