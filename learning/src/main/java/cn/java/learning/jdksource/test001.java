package cn.java.learning.jdksource;

/**
 * Description: 实验Math里的ceil,floor,round
 * Author: lxl
 * Date: 2017/2/7 13:35
 */
public class test001 {

    public static void main(String[] args) {
        System.out.println(Math.floor(-10.4));  //-11.0
        System.out.println(Math.floor(-10.6));  //-11.0
        System.out.println(Math.floor(10.4));   //10.0
        System.out.println(Math.floor(10.6));   //10.0
        System.out.println(Math.ceil(-10.4));  //-10.0
        System.out.println(Math.ceil(-10.6));  //-10.0
        System.out.println(Math.ceil(10.4));   //11.0
        System.out.println(Math.ceil(10.6));   //11.0
        System.out.println(Math.round(-10.1));  //-10
        System.out.println(Math.round(-10.5));  //-10
        System.out.println(Math.round(-10.9));  //-11
        System.out.println(Math.round(10.1));   //10
        System.out.println(Math.round(10.5));   //11
        System.out.println(Math.round(10.9));   //11
    }

}
