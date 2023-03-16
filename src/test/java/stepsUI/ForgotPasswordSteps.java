package stepsUI;

import core.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pom.ForgotPasswordPage;

public class ForgotPasswordSteps {
    public WebDriver driver = DriverManager.getInstance().getDriver();
    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    public ForgotPasswordSteps() throws Exception {
    }

    @When("I forgot password with given email (.*)$")
    public void iForgotPasswordWithGivenEmail(String email) {
        forgotPasswordPage.forgotPasswordWithEmail(email);
    }

    @Then("The message (.*) which incorrect email format displayed$")
    public void theMessageWhichIncorrectEmailFormatDisplayed(String errorMessage) {
        Assert.assertTrue(forgotPasswordPage.isIncorrectEmailFormatMessageDisplayed(errorMessage));
    }
}
