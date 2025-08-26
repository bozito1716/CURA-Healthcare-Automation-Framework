import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;


public class cura_helthcare {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");


// Disable Chrome password manager
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(2000);
        Select facilityDropdown = new Select(driver.findElement(By.name("facility")));
        facilityDropdown.selectByVisibleText("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("txt_visit_date")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("04/25/2025");
        driver.findElement(By.id("txt_comment")).sendKeys("This is a test comment");
        driver.findElement(By.id("btn-book-appointment")).click();
    }
}