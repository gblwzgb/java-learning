package cn.java.learning.innerclass;

/**
 * 内部类获取外部类的引用
 */
public class InnerClassDemo03 {
    public static void main(String[] args) {
        OuterClass03 outer = new OuterClass03();
        OuterClass03.InnerClass03 inner = outer.new InnerClass03();
        System.out.println(outer == inner.getOuterClass());  //true
        System.out.println(outer == inner.getNewOuterClass());  //false
    }
}

class OuterClass03 {

    public class InnerClass03 {
        //获取外部类的引用
        public OuterClass03 getOuterClass() {
            return OuterClass03.this;
        }

        public OuterClass03 getNewOuterClass() {
            return new OuterClass03();
        }
    }

}
