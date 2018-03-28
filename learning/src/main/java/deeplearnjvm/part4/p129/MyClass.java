package deeplearnjvm.part4.p129;

/**
 * Created by l_x_l on 2017-12-11.
 */
public class MyClass {

    private int hashCode;

    public MyClass(int hash) {
        this.hashCode = hash;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode;
    }
}
