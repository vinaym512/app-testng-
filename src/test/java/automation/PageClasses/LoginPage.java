package automation.PageClasses;

import automation.Hooks;

public class LoginPage extends Hooks{

    public static void enterCredentials() {
        if(client.waitForElement("NATIVE", "xpath=//*[@id='username_edit_text']", 0, 1000)){
            // If statement
            client.elementSendText("NATIVE", "xpath=//*[@id='username_edit_text']", 0, "test@foxsports.com.au");
        }
        if(client.waitForElement("NATIVE", "xpath=//*[@id='password_edit_text']", 0, 1000)){
            // If statement
            client.elementSendText("NATIVE", "xpath=//*[@id='password_edit_text']", 0, "F)x$ports");
        }
    }

    public static void hitLoginBtn()  {
        if(client.waitForElement("NATIVE", "xpath=//*[@text='Log In']", 0, 1000)){
            // If statement
            client.click("NATIVE", "xpath=//*[@text='Log In']", 0,1);
        }
    }

    public static void verifyLogin() {
        boolean found = client.isElementFound("NATIVE","xpath=//*[@id='home_page_recycler_view']");
        //Assert.assertTrue(found == true);
    }

}
