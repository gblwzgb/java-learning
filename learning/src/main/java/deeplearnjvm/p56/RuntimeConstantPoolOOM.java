package deeplearnjvm.p56;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=5M
 * Desc：这段代码在Java1.7以后不会OOM。。
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) throws Exception {
        //保持引用
        List<String> list = new ArrayList<>();
        int i = 0;
        String.valueOf(i++).intern();
        for (; ; ) {
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }
    }
}
/**
 * 如果加上-Xms5m -Xmx5m，就会OOM
 * 因为1.7以后的intern()方法不会把字符串实例复制到方法区了。
 * 仅仅只是复制了一个字符串实例的引用过去。
 */
