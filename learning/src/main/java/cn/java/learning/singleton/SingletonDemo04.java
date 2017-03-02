package cn.java.learning.singleton;

/**
 * 双检锁的懒汉式单例模式
 */
public class SingletonDemo04 {

    private static volatile SingletonDemo04 instance = null;

    private SingletonDemo04() {

    }

    public synchronized static SingletonDemo04 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo04.class) {
                if (instance == null) {
                    instance = new SingletonDemo04();
                }
            }
        }
        return instance;
    }

}
