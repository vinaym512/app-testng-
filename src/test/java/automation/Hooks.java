package automation;

import DriverUtils.DriverUtil;
import org.testng.annotations.*;


public class Hooks extends DriverUtil {
    //protected static Client client;

    @BeforeClass
    public static void startAppium() {
        System.out.println("++++++++++++++++++++++++++++++++++ Before Class+++++++++++++++++++");
        //DriverUtil.startDriver(tn, dq);
//        DriverUtil du = new DriverUtil();
//        du.startDriver(tn, dq);
//          client = DriverUtil.getClient();
    }
   @Parameters({"testName", "deviceQuery"})

    @BeforeMethod
    public static void setUp(String tn, String dq) {
        System.out.println("++++++++++++++++++++++++++++++++++ Before Method+++++++++++++++++++");
        DriverUtil.startDriver(tn, dq);
        client = DriverUtil.getClient();
        client.setReporter("xml", "reports", "testName");
        client.applicationClearData("au.com.foxsports.martian");
        client.launch("au.com.foxsports.martian/.login.LoginActivity", true, true);

    }

    @AfterMethod
    public static void tearDownMethod() {
        DriverUtil.getClient().generateReport(false);
    }

    @AfterClass
    public static void tearDown() {
//         if (client.applicationClose("au.com.foxsports.martian")) {
//            // If statement
//        }
        DriverUtil.getClient().releaseClient();
//
    }
}
