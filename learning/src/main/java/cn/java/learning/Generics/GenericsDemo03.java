package cn.java.learning.Generics;

/**
 * Description: 实现泛型接口的两种方式
 * Author: lxl
 * Date: 2017/2/20 18:35
 */
public class GenericsDemo03 {
    public static void main(String[] args) {
        InterfaceDemo03<String> i1 = new ClassDemo01();   //这里接口只能声明成String了。如果不声明就是Object类型的。
        i1.fun("");
        InterfaceDemo03<String> i2 = new ClassDemo02<String>();  //这里new必须加上类型标识（JAVA8中应该不用）
        i2.fun("");
        InterfaceDemo03<String> i3 = new ClassDemo03<Integer>();
        i3.fun("只能String");
        //i3.study();调用不了，因为接口里没有这个方法。
    }
}

interface InterfaceDemo03<T> {
    public T fun(T t);
}

class ClassDemo01 implements InterfaceDemo03<String> {  //实现类可以确定类型
    public String fun(String s) {
        return null;
    }
}

class ClassDemo02<T> implements InterfaceDemo03<T> {   //实现类也不能确定类型
    public T fun(T t) {
        return null;
    }
}

class ClassDemo03<T> implements InterfaceDemo03<String> {   //实现类可以确定类型
    public String fun(String s) {
        return null;
    }

    public T study(T t) {
        return t;
    }
}
