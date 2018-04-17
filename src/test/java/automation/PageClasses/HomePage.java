package automation.PageClasses;

import DriverUtils.DriverUtil;
import automation.Hooks;
import com.experitest.client.Client;
import org.junit.Assert;

public class HomePage extends Hooks{
    DriverUtil du = new DriverUtil();
    Client client = du.getClient();

    public void ifCarouselPresent() {
        boolean found = client.swipeWhileNotFound("Right", 100, 2000, "NATIVE", "xpath=//*[@id='item_hero_carousel_pager']//*[@class='android.support.constraint.ConstraintLayout'][3]", 1, 400, 5, true);
        Assert.assertTrue(found == false);
    }

    public void swipeDownToVideoCat() {
        if(client.swipeWhileNotFound("Down", 50, 2000, "NATIVE", "xpath=(//*[@id='home_page_recycler_view']/*/*[@id='item_standard_tile_carousel_text'])[4]", 0, 1000, 5, true)){
            // If statement
            //client.deviceAction("Landscape");
        }
    }

    public void clickOnAVideo() {
        client.click("NATIVE", "xpath=(//*[@id='home_page_recycler_view']/*[./*[@id='item_standard_tile_carousel_text']])[4]/*/*[2]", 0, 1);
        client.sleep(5000);
        //client.deviceAction("Landscape");
        //client.sleep(5000);
    }


}
