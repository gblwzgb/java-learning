package cn.java.learning.datastructure;

import java.util.Stack;

/**
 * 用栈实现十进制转化为八进制
 * (1348)10=(2504)8
 * (1349)10=(2505)8
 */
public class DataStructureDemo003 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("请输入要转的目标");
            System.exit(1);
        }

        Stack<Integer> oct = new Stack<Integer>();
        for (String arg : args) {
            System.out.print("(" + arg + ")10=(");
            int dec = Integer.valueOf(arg);
            do {
                oct.push(dec % 8);
                dec /= 8;
            } while (dec != 0);
            while (!oct.empty()) {
                System.out.print(oct.pop());
            }
            System.out.println(")8");
        }


    }

}
