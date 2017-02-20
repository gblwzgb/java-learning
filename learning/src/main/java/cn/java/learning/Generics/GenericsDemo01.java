package cn.java.learning.Generics;

/**
 * Description:泛型方法
 * Author: lxl
 * Date: 2017/2/18 16:52
 */
public class GenericsDemo01 {
    public static void main(String[] args) {
        Demo01 d = new Demo01();
        String str = d.fun("A"); //反射可破http://www.cnblogs.com/lzq198754/p/5780426.html
        int i = d.fun(10);
        System.out.println(str);
        System.out.println(i);
    }
}

class Demo01 {

    /**
     * 访问权限 +<泛型标示>+泛型标示 方法名称（泛型标示 参数名称）
     */
    public <T> T fun(T t) {
        return t;
    }
}
