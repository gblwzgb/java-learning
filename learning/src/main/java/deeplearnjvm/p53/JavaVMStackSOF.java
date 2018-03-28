package deeplearnjvm.p53;

/**
 * VM Args：-Xss16k
 * Desc：测试一下栈溢出
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }

    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


}
