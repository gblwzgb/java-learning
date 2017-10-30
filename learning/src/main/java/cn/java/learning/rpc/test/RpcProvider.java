package cn.java.learning.rpc.test;

import cn.java.learning.rpc.framework.RpcFramework;

/**
 * Created by l_x_l on 2017-08-22.
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
