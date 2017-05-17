package com.example.chason.letcode.medium;

import java.util.Scanner;

/**
 * Created by chgao on 17-5-17.
 */

public class MultiplyStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new MultiplyStrings().multiply(scanner.next(), scanner.next()));
        }
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        char[] longNum;
        char[] shortNum;
        if (num1.length() > num2.length()) {
            longNum = num1.toCharArray();
            shortNum = num2.toCharArray();
        } else {
            longNum = num2.toCharArray();
            shortNum = num1.toCharArray();
        }
        String result = "0";
        for (int i = 0; i < shortNum.length; i++) {
            String s = multiply(longNum, shortNum[i], shortNum.length - i - 1);
            result = add(s, result);
        }
        return result;
    }

    private String add(String num1, String num2) {
        char[] longNum;
        char[] shortNum;
        if (num1.length() > num2.length()) {
            longNum = num1.toCharArray();
            shortNum = num2.toCharArray();
        } else {
            longNum = num2.toCharArray();
            shortNum = num1.toCharArray();
        }
        int current;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = longNum.length - 1; i > -1; i--) {
            if (i >longNum.length - shortNum.length-1) {
                current = shortNum[i-(longNum.length - shortNum.length)] + longNum[i] - 2 * '0' + add;
            } else {
                current = longNum[i] - '0' + add;
            }
            add = current / 10;
            current = current % 10;
            sb.insert(0, current);
        }
        if (add !=0){
            sb.insert(0,add);
        }
        //System.out.println(num1 +"+"+num2+"="+sb.toString());
        return sb.toString();
    }

    private String multiply(char[] num, char x, int n) {
        StringBuilder sb = new StringBuilder();
        int current;
        int add = 0;
        for (int i = num.length - 1; i > -1; i--) {
            current = (num[i] - '0') * (x - '0') + add;
            add = current / 10;
            current = current % 10;
            sb.insert(0, current);
        }

        if (add != 0) {
            sb.insert(0, add);
        }

        for (int i = 0; i < n; i++) {
            sb.append(0);
        }
        //System.out.println(new String(num)+"*"+x+"*10^"+n+"="+sb.toString());
        return sb.toString();
    }
}
