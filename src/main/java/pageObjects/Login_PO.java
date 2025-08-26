package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepDefinitions.base.Hooks;

public class Login_PO extends Base_PO {
    private @FindBy(id = "txt-username")
    WebElement username_TextField;

    private @FindBy(id = "txt-password")
    WebElement password_TextField;

    private @FindBy(id = "btn-login")
    WebElement btn_Login;


    public Login_PO() {
        super();
    }

    public void navigateTo_CuraHealthcare_Login_Page (){
        Hooks.getDriver().get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    }

    public void setUsername(String username){
        Hooks.getDriver().findElement(By.id("txt-username")).click();
        Hooks.getDriver().findElement(By.id("txt-username")).sendKeys(username);
    }

    public void setPassword(String password){
        Hooks.getDriver().findElement(By.id("txt-password")).click();
        Hooks.getDriver().findElement(By.id("txt-password")).sendKeys(password);
    }

    public void clickOn_Login_Button(){
        Hooks.getDriver().findElement(By.id("btn-login")).click();
    }
    public void login(String username, String password){
        navigateTo_CuraHealthcare_Login_Page();
        setUsername(username);
        setPassword(password);
        clickOn_Login_Button();
    }
}

