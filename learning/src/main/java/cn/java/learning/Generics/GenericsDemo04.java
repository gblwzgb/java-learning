package cn.java.learning.Generics;

/**
 * Description: 通配符的使用
 * Author: lxl
 * Date: 2017/2/20 18:45
 */
public class GenericsDemo04 {

    public static void main(String[] args) {
        Demo04<String> demo04 = new Demo04<String>();
        demo04.setVar("呵呵呵");
        fun(demo04);
    }

    public static void fun(Demo04<?> temp) {
        System.out.println("内容:" + temp);
    }
}

class Demo04<T> {
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
