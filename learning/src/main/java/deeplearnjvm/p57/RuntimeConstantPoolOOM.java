package deeplearnjvm.p57;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);  //1.7以后：true，1.6是false

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);  //都是false

        String str3 = new StringBuilder("呵呵呵").toString();
        System.out.println(str3.intern() == str3);  //false
        System.out.println("呵呵呵" == str3.intern()); //true
        System.out.println("呵呵呵" == str3);  //false
    }
}
/**
 * 1.6以前执行intern()方法，会把字符串实例复制一份到方法区
 * 1.7以后，只复制字符串实例首次出现的引用过去。
 *
 * 为什么要用append呢，因为这样可以确保"计算机软件"这个字符串不会直接在方法区创建，而是通过str1.intern()方法复制一个引用进去。
 *
 * "java"字符串在方法区早就有了，所以str2.intern()返回的是早就有的那个引用，所以和SB创建的那个不是同一个引用。
 *
 * "呵呵呵"直接把字面量放入了方法区，所以str3.intern()返回方法区内的一个引用，不等于SB创建的。
 */
