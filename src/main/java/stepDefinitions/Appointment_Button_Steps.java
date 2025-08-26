package stepDefinitions;

import stepDefinitions.base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Appointment_Button_Steps {

    @Given("I access the Cura Healthcare Home Page")
    public void i_access_the_cura_healthcare_home_page() {
        Hooks.getDriver().get("https://katalon-demo-cura.herokuapp.com/");
    }

    @When("I click on make appointment button")
    public void i_click_on() {
        Hooks.getDriver().findElement(By.id("btn-make-appointment")).click();
    }

    @When("I click on toggle menu")
    public void i_click_on_toggle_menu() {
        Hooks.getDriver().findElement(By.id("menu-toggle")).click();
    }

    @And("I click on login")
    public void i_click_on_login() {
        Hooks.getDriver().findElement(By.xpath("(//a[normalize-space()='Login'])")).click();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        boolean isUsernameFieldDisplayed = Hooks.getDriver().findElement(By.id("txt-username")).isDisplayed();
        Assert.assertTrue(isUsernameFieldDisplayed, "Username field is not displayed, not on login page");
    }
}
