package cn.java.learning.Generics;

/**
 * 泛型的类型擦除
 * <p/>
 * 泛型只是编译的语法糖，在虚拟机里就不存在什么泛型不泛型的。
 * <p/>
 * 查看反编译的class可以看到，编译的时候所有泛型都变成了Object类型，然后到具体的地方帮我们强转了而已。
 */
public class GenericsDemo08 {
    public static void main(String[] args) {
        Demo08<Integer> d1 = new Demo08<Integer>();
        Demo08<String> d2 = new Demo08<String>();
        System.out.println(d1.getClass().getName());  //cn.java.learning.Generics.Demo08
        System.out.println(d2.getClass().getName());  //cn.java.learning.Generics.Demo08
        System.out.println(d1.getClass().getName() == d2.getClass().getName()); //true
    }

//    private void fun(Demo08<String> d1) {
//        由于类型擦除，所以这里重载也是不行的。
//    }
//
//    private void fun(Demo08<Integer> d2) {
//
//    }
}

class Demo08<T> {
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
