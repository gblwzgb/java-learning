package cn.java.learning.innerclass;

/**
 * 外部类调用内部类的方法
 */
public class InnerClassDemo04 {
    public static void main(String[] args) {
        new OuterClass04();
    }
}

class OuterClass04 {

    private String name;

    //定义个内部类
    public class InnerClass04 {

        private String name;

        private void print() {
            System.out.println(name);
        }
    }

    public OuterClass04() {
        InnerClass04 innerClass = new InnerClass04();
        innerClass.name = "lxl";
        innerClass.print();
    }

}
