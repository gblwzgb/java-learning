package cn.java.learning.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 改程序可以分析java解释器能够加载的任何类，而不仅仅是编译程序时可以使用的类。
 * 而且可以查看java解释器自动生成的内部类。
 */
public class ReflectionTest {

    public static void main(String[] args) {
        String className = "cn.java.learning.innerclass.Outer05$LocalClass";
        //String className = "cn.java.learning.innerclass.OuterClass04$InnerClass04";
        StringBuffer sb = new StringBuffer();
        try {
            Class cl = Class.forName(className);
            Class superCl = cl.getSuperclass();
            sb.
                    append(Modifier.toString(cl.getModifiers())).
                    append(" class ").
                    append(cl.getName());
            if(superCl!=null&superCl!= Object.class){
                sb.append(" extends ").append(superCl.getName());
            }
            sb.append("{");
            System.out.println(sb);
            ReflectionTest.printFields(cl);
            System.out.println();
            ReflectionTest.printConstructors(cl);
            System.out.println();
            ReflectionTest.printMethods(cl);
            System.out.println();
            System.out.println("}");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印一个类的所有构造方法
     *
     * @param cl 目标类
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getConstructors();

        StringBuffer sb = new StringBuffer();

        for (Constructor c : constructors) {
            sb.append("    ");  //缩进一个tab键的距离
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                sb.append(modifiers).append(" ");  //输出访问修饰符
            }
            sb.append(c.getName()).append("(");  //输出类名
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(paramTypes[i].getName());  //输出形参的类型
            }
            sb.append(");");
            System.out.println(sb);
            sb.delete(0, sb.length());  //清空
        }
    }

    /**
     * 打印一个类的所有方法
     *
     * @param cl 目标类
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        StringBuffer sb = new StringBuffer();

        for (Method m : methods) {
            sb.
                    append("    ").
                    append(Modifier.toString(m.getModifiers())).
                    append(" ").
                    append(m.getReturnType().getName()).
                    append(" ").
                    append(m.getName()).
                    append("(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(paramTypes[i].getName());  //输出形参的类型
            }
            sb.append(");");
            System.out.println(sb);
            sb.delete(0, sb.length());  //清空
        }
    }

    /**
     * 打印一个类中的所有域
     *
     * @param cl 目标类
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        StringBuffer sb = new StringBuffer();

        for (Field f : fields) {
            sb.
                    append("    ").
                    append(Modifier.toString(f.getModifiers())).
                    append(" ").
                    append(f.getType().getName()).
                    append(" ").
                    append(f.getName()).
                    append(";");
            System.out.println(sb);
            sb.delete(0, sb.length());  //清空
        }

    }
}
