package automation.TestClasses;

import automation.Hooks;
import automation.PageClasses.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends Hooks{
    LoginPage lp = new LoginPage();

    @Test (groups = { "smoke"})
    public void testLogin() {
        lp.enterCredentials(clientHooks, osNameGlobal);
        lp.hitLoginBtn(clientHooks, osNameGlobal);
        lp.verifyLogin(clientHooks, osNameGlobal);

    }
}
