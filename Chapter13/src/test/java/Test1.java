import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {
    String message = "Manisha";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(groups = {"Test1.test1"})
    public void testPrintMessage() {
        System.out.println("111111");
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(groups = { "functest", "checkintest" })
    public void testMethod1() {
        System.out.println("\"functest\", \"checkintest\" ");
    }

    @Test(groups = {"functest", "checkintest"} )
    public void testMethod2() {
        System.out.println("\"functest\", \"checkintest\" ");
    }

    @Test(groups = { "functest" })
    public void testMethod3() {
        System.out.println("functest");
    }



    @Test(groups = { "windows.checkintest" })
    public void testWindowsOnly() {
        System.out.println("testWindowsOnly");
    }

    @Test(groups = {"linux.checkintest"} )
    public void testLinuxOnly() {
        System.out.println("testLinuxOnly");
    }

    @Test(groups = { "windows.functest" })
    public void testWindowsToo() {
        System.out.println("testWindowsToo");
    }

}