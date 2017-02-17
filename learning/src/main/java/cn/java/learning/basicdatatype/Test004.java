package cn.java.learning.basicdatatype;

/**
 * switch的default试验
 */
public class Test004 {
    public static void main(String[] args) {
        int i = 4;
        switch (i){
            case 1:      //这个值要和括号里变量的类型一样，不然编译报错
                System.out.println(1);
                break;
            default:
                System.out.println(0);
            case 5:
                System.out.println(5);
        }
    }
}
