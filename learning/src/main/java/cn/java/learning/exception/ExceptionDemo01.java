package cn.java.learning.exception;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by l_x_l on 2017-01-25.
 */
public class ExceptionDemo01 {

    public static void main(String[] args) {
        print();
        //System.out.println("error");

    }

    private static void print(){
        try{
            System.out.println(10/0);//throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("捕获");
            throw e;
        } finally {
            System.out.println(1111);
        }

    }
}

class B implements A{
    public void open() {
        //InputStream in = new FileInputStream("");
    }
}
