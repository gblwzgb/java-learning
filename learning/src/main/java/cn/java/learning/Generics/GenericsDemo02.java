package cn.java.learning.Generics;

/**
 * Description:泛型类
 * Author: lxl
 * Date: 2017/2/20 18:29
 */
public class GenericsDemo02 {
    public static void main(String[] args) {
        Demo02<String> d = new Demo02<String>();
        d.fun("只能放String");
        Demo02 d2 = new Demo02();   //如果不指定的话，就是默认Object的。
        d2.fun("可以放任意的object");
    }
}

class Demo02<T> {

    public T fun(T t) {
        return t;
    }

    public <T1> T1 study(T1 t1) {   //泛型方法可以选择使用类上声明的泛型标识，也可以选择自己声明一个。
        return t1;
    }
}