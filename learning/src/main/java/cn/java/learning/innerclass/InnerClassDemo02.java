package cn.java.learning.innerclass;

/**
 * 内部类的访问修饰符
 */
public class InnerClassDemo02 {
    public static void main(String[] args) {
        new OuterClass02().get(); //编译报错
    }
}

class OuterClass02 {

    private class InnerClass02 {
        //内部类
        public void print(){
            System.out.println("成功取得内部类");
        }
    }

    public InnerClass02 get() {
        return new InnerClass02();
    }
}
