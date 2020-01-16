package dep;

import org.testng.annotations.Test;

public class TestDep {
// hard dependency:
    @Test(groups = {"parent"})
    public void serverStartedOk() {
        System.out.println("serverStartedOk");
    }

    @Test(dependsOnMethods = { "serverStartedOk" },groups = {"child"})
    public void method1() {
        System.out.println("This method1 depends on serverStartedOk");
    }

}
