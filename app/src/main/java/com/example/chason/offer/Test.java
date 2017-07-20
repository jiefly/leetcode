package com.example.chason.offer;

/**
 * Created by chgao on 17-7-8.
 */

public class Test {
    public static void main(String[] args){
        Integer a =1 ;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e  =321;
        Integer f =321;
        Long g = 3L;
        //true
        //-128 ~ 127 在常量池中 ，所以地址相同
        System.out.println(c == d);
        //false
        // <-128 || > 127 在堆中
        System.out.println(e == f);
        //true
        System.out.println(c ==(a+b));
        //true
        // c 和 a+b 的类型相同并且 值相同
        System.out.println(c.equals(a+b));
        //true
        System.out.println(g == (a+b));
        //false
        //g为Long a+b 为 int，类型不相同，返回false
        System.out.println(g .equals(a+b));
    }
}
