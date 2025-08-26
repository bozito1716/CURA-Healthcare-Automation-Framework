package stepDefinitions;

import pageObjects.Base_PO;
import pageObjects.Book_Appointment_PO;
import pageObjects.Login_PO;
import stepDefinitions.base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Book_Appointment_Steps extends Base_PO {
    private final Book_Appointment_PO book_appointment_po;
    private final Login_PO login_po;

    public Book_Appointment_Steps(Book_Appointment_PO bookAppointmentPO, Login_PO loginPO) {
        this.book_appointment_po = bookAppointmentPO;
        this.login_po = loginPO;
    }


    @Given("The user is logged in")
    public void the_user_is_logged_in() {
        login_po.login("John Doe", "ThisIsNotAPassword");
}

    @Then("I access the Cura Healthcare Book Appointment Page")
    public void i_access_the_cura_healthcare_book_appointment_page() {
        book_appointment_po.navigateTo_CuraHealthcare_Appointment_Page();
    }

    @And("I choose the facility {}")
    public void i_choose_the_facility(String facility) {
        book_appointment_po.setfacility_Box(facility);
    }

    @And("I {string} the \"applying for hospital admission\" checkbox")
    public void i_toggle_the_checkbox(String checkboxState) {
        boolean admission = checkboxState.equalsIgnoreCase("check");
        book_appointment_po.setHospitalAdmission_Box(admission);
    }

    @And("I choose the Healthcare Program {}")
    public void i_choose_the_healthcare_program(String healthcareProgram) {
        book_appointment_po.chooseHealthcareProgram((healthcareProgram));
    }

    @And("I choose the visit date")
    public void i_choose_the_visit_date() {
        book_appointment_po.chooseDate();
    }


    @And("I leave a comment")
    public void i_leave_a_comment() {
        book_appointment_po.setCommentBox();
    }

    @And("I click on book appointment button")
    public void i_click_on_book_appointment_button() {
        book_appointment_po.clickAppointmentButton();
    }

    @Then("I should be redirected to the Appointment Confirmation page")
    public void i_should_be_redirected_to_the_appointment_confirmation_page() {
        String actualText = book_appointment_po.getAppointmentConfirmationText();

        if (actualText.equals("Appointment Confirmation")) {
            System.out.println("✅ Text matches: " + actualText);
        } else {
            System.out.println("❌ Text does not match. Found: " + actualText);
        }

    }
}