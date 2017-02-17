package cn.java.learning.basicdatatype;

/**
 * switch的枚举类型
 */
public class Test005 {

    static enum E {
        A, B, C, D
    }

    public static void main(String[] args) {
        E e = E.B;    //注意不要写成Enum e = E.b; 否则case那句会编译报错
        switch (e) {
            case A:
                System.out.println(1);
                break;
            default:
                System.out.println(0);
        }
    }

}
