package cn.java.learning.jdksource;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description: 用栈来实现括号的校验
 * Author: lxl
 * Date: 2017/1/18 13:48
 */
public class test3 {

    public static void main(String[] args) {
        String str = "({[]})[]";
        char[] c = str.toCharArray();
        Map<Character, Character> m = new HashMap<Character, Character>();
        m.put(')', '(');
        m.put('}', '{');
        m.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (char c1 : c) {
            if (c1 == '(' || c1 == '{' || c1 == '[') {
                stack.push(c1);
            } else if (c1 == ')' || c1 == '}' || c1 == ']') {
                if (!stack.empty() && stack.lastElement() == m.get(c1)) {
                    stack.pop();
                } else {
                    System.out.println("校验失败");
                    System.exit(1);
                }
            }
        }
        if (!stack.empty()) {
            System.out.println("校验失败");
            System.exit(1);
        }
    }
}
