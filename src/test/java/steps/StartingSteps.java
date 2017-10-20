package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartingSteps extends BaseSteps {

    @Before
    public void setCapabilities() throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "4.4");
        cap.setCapability("deviceName", "172.17.70.42:5555");
        cap.setCapability("noReset", false);
        cap.setCapability("fullReset", true);
        cap.setCapability("app", "C:/Users/jvanblokland/Google Drive/Workspace/TestAutomation/app/ApiDemos-debug.apk");

        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = appiumDriver.getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            appiumDriver.quit();
        } catch (Exception e) {
            System.out.println("Exception while running Tear Down: " + e.getMessage());
        }
    }
}