package deeplearnjvm.p51;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Desc：测试一下堆内存溢出
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        for (; ; ) {
            list.add(new OOMObject());
        }
    }
}
