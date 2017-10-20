package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreferencePage extends BasePage {

    AppiumDriver appiumDriver;

    @FindBy(id = "4. Default values")
    private WebElement defaultValuesButton;

    public PreferencePage(AppiumDriver appiumDriver) throws Exception {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void tapDefaultValuesButton() {
        defaultValuesButton.click();
    }
}