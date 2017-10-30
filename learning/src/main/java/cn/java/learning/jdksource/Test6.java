package cn.java.learning.jdksource;

/**
 * 可以看到break只能调出一个for循环
 * 如果要全跳出，可以设定一个target，然后break到设定的target
 */
public class Test6 {

    public static void main(String[] args) {
        iterationWithTwoFor();
        System.out.println("------------");
        iterationWithTwoForAndTarget();
    }

    private static void iterationWithTwoFor(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    break;
                }
                System.out.println(i + ":" + j);
            }
        }
    }

    private static void iterationWithTwoForAndTarget(){
        HHH:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    break HHH;
                }
                System.out.println(i + ":" + j);
            }
        }
    }

}
