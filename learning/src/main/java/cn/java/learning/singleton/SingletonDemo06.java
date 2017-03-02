package cn.java.learning.singleton;

/**
 * 静态内部类实现的单例模式
 */
public enum SingletonDemo06 {

    INSTANCE;

    private Resource instance;

    SingletonDemo06() {
        instance = new Resource();
    }

    public Resource getInstance() {
        return instance;
    }

}

class Resource {
}


