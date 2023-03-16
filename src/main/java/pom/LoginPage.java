package pom;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public By txtUserName = By.cssSelector("input[name='login']");
    public By txtPassword = By.cssSelector("input[name='password']");
    public By btnLogin = By.cssSelector("button[type='submit']");
    public By btnForgotPassword = By.cssSelector("a[class*='loginForm__forgot-pass']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        sendKeyToElement(txtUserName, username);
        sendKeyToElement(txtPassword, password);
        clickToElement(btnLogin);
    }

    public void clickButtonForgotPassword() {
        clickToElement(btnForgotPassword);
    }
}