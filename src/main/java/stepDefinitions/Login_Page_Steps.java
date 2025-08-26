package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Base_PO;
import pageObjects.Login_PO;
import stepDefinitions.base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;

public class Login_Page_Steps extends Base_PO {
    private Login_PO login_po;
    public Login_Page_Steps (Login_PO login_po){
        this.login_po = login_po;

    }
    @Given("I access the Cura Healthcare Login Page")
    public void i_access_the_cura_healthcare_login_page() {
        login_po.navigateTo_CuraHealthcare_Login_Page();

    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
        //Hooks.getDriver().findElement(By.id("txt-username")).click();
        //Hooks.getDriver().findElement(By.id("txt-username")).sendKeys(username);
    }

    @And("I enter a password {word}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
        //Hooks.getDriver().findElement(By.id("txt-password")).click();
        //Hooks.getDriver().findElement(By.id("txt-password")).sendKeys(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        login_po.clickOn_Login_Button();
        //Hooks.getDriver().findElement(By.id("btn-login")).click();
    }

    @Then("I should be redirected to the appointment page")
    public void i_should_be_redirected_to_the_appointment_page() {
        WebDriver driver = Hooks.getDriver();
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));

        WebElement appointmentTitle = Hooks.getDriver().findElement(By.xpath("//h2[normalize-space()='Make Appointment']"));
        String actualText = appointmentTitle.getText();
        String expectedText = "Make Appointment";
        Assert.assertEquals(actualText, expectedText, "Text validation failed. Expected: '"
                + expectedText + "', but found: '" + actualText + "'.");
    }


    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessage = Hooks.getDriver().findElement(By.xpath("(//p[@class='lead text-danger'])"));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage.trim(), "Login failed! Please ensure the username and password are valid.");
    }
}

