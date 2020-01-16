import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
    String message = "Manisha";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(dependsOnGroups = {"checkintest"})
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Manisha";
        Assert.assertEquals(message,messageUtil.salutationMessage());
    }

    @Test(groups = { "broken"} )
    public void testMethod1() {
        System.out.println(" broken");
    }
    @Test(groups = {"checkintest", "broken"} )
    public void testMethod2() {
        System.out.println("checkintest broken");
    }
    @Test(groups = {"checkintest"} )
    public void testMethod3() {
        System.out.println("checkintest");
    }
}