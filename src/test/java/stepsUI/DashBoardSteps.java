package stepsUI;

import core.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pom.DashBoardPage;

public class DashBoardSteps {
    public WebDriver driver = DriverManager.getInstance().getDriver();
    public DashBoardPage dashBoardPage = new DashBoardPage(driver);
    public String ORIGINAL_SIZE_1ST_WIDGET = "";
    public String ORIGINAL_LOCATION_2ND_WIDGET = "";

    public DashBoardSteps() throws Exception {
    }

    @When("I click on hyperlink first dashboard")
    public void iClickHyperlinkFirstDashboard() {
        dashBoardPage.clickHlkFirstDashBoard();
    }

    @When("I resize the first widget")
    public void iResizeFirstWidget() {
        ORIGINAL_SIZE_1ST_WIDGET = dashBoardPage.getSizeFirstWidget();
        ORIGINAL_LOCATION_2ND_WIDGET = dashBoardPage.getLocationSecondWidget();
        dashBoardPage.resizeFirstWidget();
    }

    @Then("I verify the size is changed in first widget")
    public void iVerifySizeIsChangedFirstWidget() {
        String latestSize1stWidget = dashBoardPage.getSizeFirstWidget();
        Assert.assertNotEquals(ORIGINAL_SIZE_1ST_WIDGET, latestSize1stWidget);
    }

    @Then("I verify the location is changed in second widget")
    public void iVerifyLocationIsChangedSecondWidget() {
        String latestLocation2ndWidget = dashBoardPage.getLocationSecondWidget();
        Assert.assertNotEquals(ORIGINAL_LOCATION_2ND_WIDGET, latestLocation2ndWidget);
    }
}
