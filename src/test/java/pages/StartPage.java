package pages;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {

    AppiumDriver appiumDriver;

    @FindBy(id = "OS")
    private WebElement osButton;

    @FindBy(id = "Preference")
    private WebElement preferencButton;

    public StartPage(AppiumDriver appiumDriver) throws Exception {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void startPageIsDisplayed() {
        Assert.assertTrue(osButton.isDisplayed());
    }

    public void tapPreferenceButton() {
        preferencButton.click();
    }
}