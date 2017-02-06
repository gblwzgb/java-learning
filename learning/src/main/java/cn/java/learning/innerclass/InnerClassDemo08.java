package cn.java.learning.innerclass;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * 最简单的一个内部类
 */
public class InnerClassDemo08 {

    private String name;

    public class InnerClass {

        public InnerClass() {
            name = "lxl";
        }
    }

}
