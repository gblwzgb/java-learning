package cn.java.learning.innerclass;

/**
 * 成员内部类
 */
public class InnerClassDemo01 {

    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.print();
        new Thread(innerClass).start();
    }

}

class OuterClass {

    private String name;

    public String getName() {
        return name;
    }

    public class InnerClass implements Runnable {

        public InnerClass() {
            name = "lxl";    //注意不要用this.name，this指的是内部类的。
        }

        public void run() {
            System.out.println(name);
        }

        public void print() {
            System.out.println(getName());
        }
    }
}
