package automation.TestClasses;

import automation.Hooks;
import automation.PageClasses.HomePage;
import automation.PageClasses.LoginPage;
import org.testng.annotations.Test;

public class HomePageTest extends Hooks{
    HomePage hp = new HomePage();
    LoginPage lp = new LoginPage();

    @Test (groups = { "e2e" })

    public void testHomePageVideo() {
        lp.enterCredentials(clientHooks, osNameGlobal);
        lp.hitLoginBtn(clientHooks, osNameGlobal);
        lp.verifyLogin(clientHooks, osNameGlobal);
        hp.ifCarouselPresent(clientHooks, osNameGlobal);
    }

}
