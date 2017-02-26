package cn.java.learning.Generics;

/**
 * 子类无法使用父类的泛型接受.
 */
public class GenericsDemo07 {
    public static void main(String[] args) {
        Demo07<Object> d1 = null;
        Demo07<String> d2 = new Demo07<String>();
        //d1 = d2;编译失败：不兼容的类型
        //Demo07<Object> d3 = new Demo07<String>();编译失败：不兼容的类型
    }
}

class Demo07<T> {
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
