package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.base.Hooks;



public class Book_Appointment_PO extends Base_PO {
    //Locators
    private @FindBy(name = "facility")
    WebElement facility_Box;

    private @FindBy(id = "chk_hospotal_readmission")
    WebElement hospitalAdmission_Box;

    private @FindBy(css = "input[type='radio'][value='Medicare']")
    WebElement medicareRadio;
    private @FindBy(css = "input[type='radio'][value='Medicaid']")
    WebElement medicaidRadio;
    private @FindBy(css = "input[type='radio'][value='None']")
    WebElement noneRadio;

    private @FindBy(id = "txt_visit_date")
    WebElement dateBox;

    private @FindBy(id = "txt_comment")
    WebElement commentBox;

    private @FindBy(id = "btn-book-appointment")
    WebElement appointmentButton;

    private @FindBy(xpath = "//h2[normalize-space()='Appointment Confirmation']")
    WebElement appointmentConfirmationText;

    public Book_Appointment_PO() {
        super();
    }

    public void navigateTo_CuraHealthcare_Appointment_Page() {
        Hooks.getDriver().get("https://katalon-demo-cura.herokuapp.com/#appointment");
    }

    public void setfacility_Box(String facility) {
        Select facilityDropdown = new Select(Hooks.getDriver().findElement(By.name("facility")));
        facilityDropdown.selectByVisibleText(facility);
    }

    public void setHospitalAdmission_Box(boolean admission) {
        if (admission && !hospitalAdmission_Box.isSelected()) {
            hospitalAdmission_Box.click();  // Check the box
        } else if (!admission && hospitalAdmission_Box.isSelected()) {
            hospitalAdmission_Box.click();  // Uncheck the box
        }
    }
    public void chooseHealthcareProgram(String healthcareProgram){
        WebElement radioButton = Hooks.getDriver().findElement(By.cssSelector("input[type='radio'][name='programs'][value='" + healthcareProgram + "']"));
        radioButton.click();
    }
    public void chooseDate(){
        String randomDate = getRandomFutureDate(30); // random date within next 30 days

        dateBox.click();
        dateBox.clear(); // optional, to clear any default
        dateBox.sendKeys(randomDate);
    }
    public void setCommentBox (){
        String randomText = generateRandomText(6); // generates 6-letter random text
        String comment = "This is a test comment " + randomText;
        commentBox.sendKeys(comment);
    }

    public void clickAppointmentButton(){
        appointmentButton.click();
    }
    public String getAppointmentConfirmationText() {
        return appointmentConfirmationText.getText();
    }
}