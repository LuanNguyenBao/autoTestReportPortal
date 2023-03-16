package pom;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    public By txtEmail = By.cssSelector("input[name='email']");
    public By msgEmailIncorrect = By.cssSelector("div[class*='fieldErrorHint__visible'] > div[class*='hint-content']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void forgotPasswordWithEmail(String email) {
        sendKeyToElement(txtEmail, email);
    }

    public boolean isIncorrectEmailFormatMessageDisplayed(String errorMessage) {
        if (isElementDisplayed(msgEmailIncorrect)) {
            return getText(msgEmailIncorrect).matches(errorMessage);
        }
        return false;
    }
}
