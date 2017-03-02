package cn.java.learning.singleton;

/**
 * 饿汉式的单例模式
 */
public class SingletonDemo02 {

    private static SingletonDemo02 instance = new SingletonDemo02();

    private SingletonDemo02() {

    }

    public static SingletonDemo02 getInstance() {
        return instance;
    }

}
