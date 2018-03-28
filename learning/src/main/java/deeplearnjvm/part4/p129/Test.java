package deeplearnjvm.part4.p129;

import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * 在线红黑树演示：http://sandbox.runjs.cn/show/2nngvn8w
 */
public class Test {
    public static void main(String[] args) {
        TreeMap<MyClass,String> map = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.hashCode()-o2.hashCode();
            }
        });
        for(int i=0;i<100000;i++){
            map.put(new MyClass(new Random().nextInt(10000)),"");
        }
        for(int i=0;i<100000;i++){
            map.remove(new MyClass(new Random().nextInt(10000)));
        }
    }
}
