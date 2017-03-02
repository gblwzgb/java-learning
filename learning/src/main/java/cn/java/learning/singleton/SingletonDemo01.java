package cn.java.learning.singleton;

/**
 * 懒汉式的单例模式
 */
public class SingletonDemo01 {

    private static SingletonDemo01 instance = null;

    private SingletonDemo01() {

    }

    public static SingletonDemo01 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo01();
        }
        return instance;
    }

}
