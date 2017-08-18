package cn.java.learning.test;

import cn.java.learning.junit.Calculator;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Description: 用来测试junit3.8.1
 * Author: lxl
 * Date: 2017/8/18 14:06
 */
public class CalculatorTest extends TestCase {

    Calculator cal;

    //在“每个”测试方法执行之前被调用
    public void setUp()
    {
        //这段代码在这写比较方便，只写一次就够，
        //不用在每个方法里写，因为这个方法每次都被调用，生成不同的对象，供测试方法使用
        cal = new Calculator();
        //System.out.println("setUp");
    }

    //在“每个”测试方法执行之后被调用
    public void tearDown()
    {
        //System.out.println("testDown");
    }

    //测试方法：方法名要以test为开头，无参数，无返回类型
    public void testAdd()
    {
        //Calculator cal = new Calculator();
        int result = cal.add(1, 2);
        //第一个参数是预期的，第二个参数是真实的
        Assert.assertEquals(3, result);

    }

    public void testSubtract()
    {
        //Calculator cal = new Calculator();
        int result = cal.subtract(1, 2);
        //第一个参数是预期的，第二个参数是真实的
        Assert.assertEquals(-1, result);

    }

    public void testMultiply()
    {
        //Calculator cal = new Calculator();
        int result = cal.multiply(1, 2);
        //第一个参数是预期的，第二个参数是真实的
        Assert.assertEquals(2, result);

    }

    public void testDivide()
    {
        int result = 0;
        //Calculator cal = new Calculator();
        try
        {
            result = cal.divide(4, 2);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            //让测试失败
            Assert.fail();
        }
        //第一个参数是预期的，第二个参数是真实的
        Assert.assertEquals(2, result);

    }

    //除数为0的情况
    public void testDivideByZero()
    {
        Throwable th = null ;

        //Calculator cal = new Calculator();
        try
        {
            cal.divide(1, 0);
            Assert.fail();
        }
        catch(Exception e)
        {
            th = e ;
            //e.printStackTrace();
        }

        //th 不为空 null
        Assert.assertNotNull(th);
        //第一个参数是预期的，第二个参数是真实的
        Assert.assertEquals(Exception.class, th.getClass());
        Assert.assertEquals("除数不能为0", th.getMessage());

    }

    //加了这个main方法，可以直接以 Java Application 方式运行 ，也可以以 JUnit Test 运行
    public static void main(String[] args)
    {
        //命令行形式打印
        junit.textui.TestRunner.run(CalculatorTest.class);

        //awt 界面方式显示
        //junit.awtui.TestRunner.run(CalculatorTest.class);

        //swing 界面方式显示
        //junit.swingui.TestRunner.run(CalculatorTest.class);
    }
}
