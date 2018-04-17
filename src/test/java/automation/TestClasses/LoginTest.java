package automation.TestClasses;

import automation.Hooks;
import automation.PageClasses.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {
    LoginPage lp = new LoginPage();

    @Test (groups = { "smoke" })
    public void testLogin() {
        lp.enterCredentials();
        client.sleep(5000);
        lp.hitLoginBtn();
        client.sleep(5000);
        lp.verifyLogin();
    }
}
