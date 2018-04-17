package automation.PageClasses;

import DriverUtils.DriverUtil;
import automation.Hooks;
import com.experitest.client.Client;

public class VideoControlsPage extends Hooks{
    DriverUtil du = new DriverUtil();
    Client client = du.getClient();

    public void pauseNPlayAVideo() {

        if (client.waitForElement("NATIVE", "xpath=//*[@id='exo_subtitles']", 0, 60000)) {
            // If statement
            client.click("NATIVE", "xpath=//*[@id='exo_subtitles']", 0, 1);
            client.sleep(5000);
        }
        if (client.waitForElement("NATIVE", "xpath=//*[@id='exo_pause']", 0, 60000)) {
            // If statement
            client.click("NATIVE", "xpath=//*[@id='exo_pause']", 0, 1);
            client.sleep(5000);
        }
        if (client.waitForElement("NATIVE", "xpath=//*[@id='exo_play']", 0, 60000)) {
            // If statement
            client.click("NATIVE", "xpath=//*[@id='exo_play']", 0, 1);
            client.sleep(5000);
        }
    }

}
