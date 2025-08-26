package pageObjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.base.Hooks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static stepDefinitions.base.Hooks.getDriver;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(Hooks.getDriver(), this);

    }

    public String getRandomFutureDate(int maxDaysAhead) {
        Random random = new Random();
        int randomDays = random.nextInt(maxDaysAhead) + 1;
        LocalDate futureDate = LocalDate.now().plusDays(randomDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // matches the format "06/25/2025"
        return futureDate.format(formatter);


    }
    public String generateRandomText ( int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomText = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomText.append(characters.charAt(random.nextInt(characters.length())));
        }

        return randomText.toString();
    }

}