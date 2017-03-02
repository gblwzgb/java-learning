package cn.java.learning.singleton;

/**
 * 静态内部类实现的单例模式
 */
public class SingletonDemo05 {

    private SingletonDemo05() {

    }

    private static final class SingletonManager {
        private static SingletonDemo05 instance = new SingletonDemo05();
    }

    public static SingletonDemo05 getInstance() {
        return SingletonManager.instance;
    }

}


