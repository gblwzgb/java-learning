package cn.java.learning.exception;

/**
 * 测试finally的返回
 */
public class ExceptionDemo02 {

    public static void main(String[] args) {
        System.out.println(returnTest());
    }

    private static boolean returnTest() {
        try {
            return true;
        } catch (Exception e) {

        } finally {
            return false;
        }
        //return true;   加上这句的话编译报错，因为这句永远不会执行。
    }
}
