package cn.java.learning.basicdatatype;

/**
 * 实验基本类型的默认值
 */
public class Test002 {

    private static byte defaultByte;  //如果是final类型的话就必须初始化了，没有默认值
    private static short defaultShort;
    private static int defaultInt;
    private static long defaultLong;
    private static float defaultFloat;
    private static double defaultDouble;
    private static char defaultChar;
    private static boolean defaultBoolean;
    private static String str;

    public static void main(String[] args) {
        System.out.println(defaultByte);
        System.out.println(defaultShort);
        System.out.println(defaultInt);
        System.out.println(defaultLong);
        System.out.println(defaultFloat);
        System.out.println(defaultDouble);
        System.out.println(defaultChar);
        System.out.println(defaultBoolean);
        System.out.println("输出" + str);
    }
}
