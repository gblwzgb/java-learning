package cn.java.learning.Generics;

/**
 * Description: 通配符的使用之--extends
 * Author: lxl
 * Date: 2017/2/20 18:48
 */
public class GenericsDemo05 {
    public static void main(String[] args) {
        Demo05<Integer> d1 = new Demo05<Integer>();
        d1.setVar(3);
        fun(d1);
        Demo05<String> d2 = new Demo05<String>();
        d2.setVar("呵呵呵");
        //fun(d2);编译报错，只有继承自Number类型的能过。
    }

    public static void fun(Demo05<? extends Number> temp) {
        System.out.println("内容:" + temp);
    }
}

class Demo05<T> {
    private T var;

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return var;
    }

    @Override
    public String toString() {
        return this.var.toString();
    }
}
