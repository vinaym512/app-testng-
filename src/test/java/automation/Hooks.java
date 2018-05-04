package automation;

import DriverUtils.DriverUtil;
import com.experitest.client.Client;
import org.testng.annotations.*;
import java.lang.reflect.Method;


public class Hooks {
    public String osNameGlobal;
    public Client clientHooks;

    @Parameters({"testName", "deviceQuery"})
    @BeforeTest(alwaysRun = true)
    public void startBeforeTest(String testName, String deviceQuery) {
        DriverUtil.startDriver(testName, deviceQuery);
    }

   @Parameters({ "osName", "appPackageNameOrApplicationName", "appActivity"})
   @BeforeMethod(alwaysRun = true)
   public void setUp(String osName, String appPackage, @Optional("Optional") String appActivity, Method method) {
       clientHooks = DriverUtil.getClient();
       osNameGlobal = osName;
       clientHooks.setReporter("xml", "reports", "Test-"+method.getName() );
        if(osNameGlobal.toLowerCase().equals("android")) {
            clientHooks.deviceAction("Portrait");
            clientHooks.applicationClearData(appPackage);
            clientHooks.launch(appPackage + "/" + appActivity, true, true);
        }else{
            clientHooks.deviceAction("Unlock");
            clientHooks.deviceAction("Portrait");
            clientHooks.applicationClearData(appPackage);
            clientHooks.launch(appPackage, true, true);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        clientHooks.generateReport(false);
    }

    @AfterTest(alwaysRun = true)
    public void tearDownClass() {
        clientHooks.releaseClient();
    }

}
