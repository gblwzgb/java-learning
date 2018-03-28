package concurrentprogram.part4.p114;

/**
 * Created by l_x_l on 2018-01-22.
 */
public class SimpleTomcat {
    public static void main(String[] args) throws Exception{
        SimpleHttpServer.setPort(8080);
        SimpleHttpServer.setBasePath("H:/project/java-learning/learning/src/main/java/concurrentprogram/part4/p114");
        SimpleHttpServer.start();
    }
}
