package automation.TestClasses;

import automation.PageClasses.VideoControlsPage;
import org.testng.annotations.Test;

public class VideoControlsTest {
    VideoControlsPage vc = new VideoControlsPage();

    @Test (groups = { "reg" })

    public void testVideoControlPlaynPause() {
        vc.pauseNPlayAVideo();
    }

}
