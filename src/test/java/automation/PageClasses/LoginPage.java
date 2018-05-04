package automation.PageClasses;

import automation.PageObjectClasses.LoginPageObjects;
import com.experitest.client.Client;
import org.testng.Assert;

public class LoginPage {
 
    public void enterCredentials(Client client, String osNameGlobal) {
        String uId = LoginPageObjects.getUserIdId(osNameGlobal);
        String pwdId = LoginPageObjects.getPasswordId(osNameGlobal);
        if(client.waitForElement("NATIVE", uId, 0, 3000)){
            client.elementSendText("NATIVE", uId, 0, "");
            client.elementSendText("NATIVE", uId, 0, "test@foxsports.com.au");
        }
        if(client.waitForElement("NATIVE", pwdId, 0, 3000)){
            client.elementSendText("NATIVE", pwdId, 0, "");
            client.elementSendText("NATIVE", pwdId, 0, "F)x$ports");
        }
    }

    public void hitLoginBtn(Client client, String osNameGlobal)  {
        String loginId = LoginPageObjects.getLoginId(osNameGlobal);
        if(client.isElementFound("NATIVE", loginId, 0)){
            client.click("NATIVE", loginId, 0,1);
        }
    }

    public void verifyLogin(Client client, String osNameGlobal) {
        String homeId = LoginPageObjects.getHomeId(osNameGlobal);
        if(client.waitForElement("NATIVE", homeId, 0,5000)) {
            boolean found = client.isElementFound("NATIVE", homeId);
            Assert.assertTrue(found == true);
        }
    }

}
