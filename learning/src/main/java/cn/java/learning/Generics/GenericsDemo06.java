package cn.java.learning.Generics;

/**
 * Description: 通配符的使用之--super设置下限
 * Author: lxl
 * Date: 2017/2/20 18:48
 */
public class GenericsDemo06 {

    public static void main(String[] args) {
        Demo06<Integer> d1 = new Demo06<Integer>();
        //fun(d1);编译失败，只能是String类型的或是Object类型的。
        Demo06<String> d2 = new Demo06<String>();
        fun(d2);
        Demo06 d3 = new Demo06();
        fun(d3);
    }

    public static void fun(Demo06<? super String> temp) {
        System.out.println("内容:" + temp);
    }
}

class Demo06<T> {
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
