package pages;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultValuesPage extends BasePage {
    AppiumDriver appiumDriver;

    @FindBy(className = "android.widget.CheckBox")
    private WebElement checkboxPreference;

    public DefaultValuesPage(AppiumDriver appiumDriver) throws Exception {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver,  this);
    }

    public void defaultValuesPageIsDisplayed() {
        Assert.assertTrue(checkboxPreference.isDisplayed());
    }

    public void tapCheckBox() {
        checkboxPreference.click();
    }

    public void validateCheckBox() {
        if (checkboxPreference.getAttribute("checked").equals("false")) {
            checkboxPreference.click();
            Assert.assertTrue(checkboxPreference.getAttribute("checked").equals("true"));
        } else {
            checkboxPreference.click();
            Assert.assertTrue(checkboxPreference.getAttribute("checked").equals("false"));
        }
    }
}