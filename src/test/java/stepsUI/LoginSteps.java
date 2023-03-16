package stepsUI;

import core.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import pom.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginSteps {
    public WebDriver driver = DriverManager.getInstance().getDriver();
    private static final Logger log = LogManager.getLogger(LoginSteps.class);
    public LoginPage loginPage = new LoginPage(driver);

    public LoginSteps() throws Exception {
    }

    @Given("I open Report Portal page")
    public void iOpenReportPortalPage() {
        String url = "https://reportportal.epam.com/";
        driver.get(url);
        log.info("Open Report Portal");
    }

    @When("I log in with given credentials")
    public void iLogInWithGivenCredentials() {
        loginPage.login("luanrptesting", "1q2w3e");
    }

    @When("I click button forgot password")
    public void iClickButtonForgotPassword() {
        loginPage.clickButtonForgotPassword();
    }

    @Then("I am able to log successfully")
    public void iAmAbleToLogSuccessfully() {
        String expectedTitle = "Report Portal";
        String currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, expectedTitle);
    }
}
