package automation.TestClasses;

import automation.PageClasses.HomePage;
import org.testng.annotations.Test;

public class HomePageTest {
    HomePage hp = new HomePage();

    @Test (groups = { "smoke", "e2e" })

    public void testHomePageVideo() {
        hp.ifCarouselPresent();
        hp.swipeDownToVideoCat();
        hp.clickOnAVideo();
    }

}
