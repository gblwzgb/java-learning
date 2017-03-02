package cn.java.learning.singleton;

/**
 * 单检锁的懒汉式单例模式
 */
public class SingletonDemo03 {

    private static SingletonDemo03 instance = null;

    private SingletonDemo03() {

    }

    public synchronized static SingletonDemo03 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo03();
        }
        return instance;
    }

}
