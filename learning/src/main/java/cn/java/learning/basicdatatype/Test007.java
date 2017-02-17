package cn.java.learning.basicdatatype;

/**
 * switch的不写break的陷阱
 */
public class Test007 {
    public static void main(String[] args) {
        int i = 2;
        switch (i){
            case 1:
                System.out.print(1);
            case 2:
                System.out.print(2);
            case 3:
                System.out.print(3);
            default:
                System.out.print(0);
        }
    }
}
