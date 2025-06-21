package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final String buttonLogin = "a[data-qa='login']";
    private final String buttonLoginInPage = "button[data-qa='submit-button']";
    private final String write = "input[data-qa='magritte-phone-input-national-number-input']";
    private final String inpuCode = "input[data-qa='applicant-login-input-otp']";

    public LoginPage clickButton(WebDriver driver){
        WebElement button = driver.findElement(By.cssSelector(buttonLogin));
        button.click();
        WebElement buttonLogin = driver.findElement(By.cssSelector(buttonLoginInPage));
        buttonLogin.click();
        WebElement writeIn = driver.findElement(By.cssSelector(write));
        writeIn.sendKeys("9996005971");
        buttonLogin.click();
        WebElement input = driver.findElement(By.cssSelector(inpuCode));
        input.sendKeys();
        return this;
    }
}
