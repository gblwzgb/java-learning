package cn.java.learning.rpc.test;

/**
 * Created by l_x_l on 2017-08-22.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
