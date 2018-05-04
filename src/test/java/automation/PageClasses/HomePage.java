package automation.PageClasses;

import automation.PageObjectClasses.HomePageObjects;
import com.experitest.client.Client;
import org.testng.Assert;

public class HomePage {

    public void ifCarouselPresent(Client client, String osNameGlobal) {
        boolean found = client.swipeWhileNotFound("Right", 100, 2000, "NATIVE", HomePageObjects.getCarouselId(osNameGlobal), 1, 400, 5, true);
        if(osNameGlobal.equals("android")){
            Assert.assertTrue(!found);
        }else{
            Assert.assertTrue(found);
        }
    }

    public void swipeDownToVideoCat(Client client, String osNameGlobal) {
        if(client.swipeWhileNotFound("Down", 50, 2000, "NATIVE", HomePageObjects.getVideoCatId(osNameGlobal), 0, 1000, 5, true)){
        }
    }

    public void clickOnAVideo(Client client, String osNameGlobal) {
        client.click("NATIVE", HomePageObjects.getVideoToPlayId(osNameGlobal), 0, 1);
        client.sleep(5000);
    }
}
