package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.StartPage;
import pages.PreferencePage;
import pages.DefaultValuesPage;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePageSteps extends BaseSteps {

    @When("^I launch the ApiDemos app$")
    public void iLaunchTheApiDemosApp() throws Throwable {
        new StartPage(appiumDriver).startPageIsDisplayed();
    }

    @And("^I select Preference$")
    public void iSelectPreference() throws Throwable {
        new StartPage(appiumDriver).tapPreferenceButton();
    }

    @And("^I select 4. Default values$")
    public void iSelectDefaultValues() throws Throwable {
        new PreferencePage(appiumDriver).tapDefaultValuesButton();
    }

    @And("^I select the checkbox$")
    public void iSelectTheCheckbox() throws Throwable {
        new DefaultValuesPage(appiumDriver).tapCheckBox();
    }

    @Then("^the checkbox is validated$")
    public void theCheckboxIsValidated() throws Throwable {
        new DefaultValuesPage(appiumDriver).validateCheckBox();
    }
}
/*
public class HomePageSteps extends BaseSteps {
    String boxstate = appiumDriver.findElement(By.className("android.widget.CheckBox")).getAttribute("checked");

    @When("^I launch the ApiDemos app$")
    public void iLaunchTheApiDemosApp() throws Throwable {
        Assert.assertTrue(appiumDriver.findElement(By.id("OS")).isDisplayed());
        throw new PendingException();
    }

    @And("^I select Preference$")
    public void iSelectPreference() throws Throwable {
        appiumDriver.findElement(By.id("Preference")).click();
        throw new PendingException();
    }

    @And("^I select 4. Default values$")
    public void iSelectDefaultValues() throws Throwable {
        appiumDriver.findElement(By.id("4. Default values")).click();
        throw new PendingException();
    }

    @And("^I select the checkbox$")
    public void iSelectTheCheckbox() throws Throwable {
        appiumDriver.findElement(By.className("android.widget.CheckBox")).click();
        throw new PendingException();
    }

    @Then("^the checkbox is either checked or unchecked$")
    public void theCheckboxIsEitherCheckedOrUnchecked() throws Throwable {
        Assert.assertTrue(appiumDriver.findElement(By.className("android.widget.CheckBox")).equals(boxstate));
        throw new PendingException();
    }
}
*/
