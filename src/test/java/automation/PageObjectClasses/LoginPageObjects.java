package automation.PageObjectClasses;

public class LoginPageObjects {

    public static String getUserIdId(String osNameGlobal){
        if(osNameGlobal.equals("android")) {
            return "xpath=//*[@id='username_edit_text']";
        }
        else {
            return "xpath=//*[@placeholder='Username']";
        }
    }

    public static String getPasswordId(String osNameGlobal){
        if(osNameGlobal.equals("android")) {
            return "xpath=//*[@id='password_edit_text']";
        }
        else {
            return "xpath=//*[@placeholder='Password']";
        }
    }

    public static String getLoginId(String osNameGlobal){
        if(osNameGlobal.equals("android")) {
            return "xpath=//*[@text='Log In']";
        }
         else {
            return "xpath=//*[@class='UIButton']";
        }
    }

    public static String getHomeId(String osNameGlobal){
        if(osNameGlobal.equals("android")) {
            return "xpath=//*[@id='home_page_recycler_view']";
        }
        else {
            return "xpath=//Martian.HomeSectionHeaderView/UIImageView";
        }
    }
}
