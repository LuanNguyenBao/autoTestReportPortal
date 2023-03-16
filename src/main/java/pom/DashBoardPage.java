package pom;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {
    public By hlkFirstDashBoard = By.cssSelector("a[class*='gridCell__grid-cell']");
    public By btnResizeFirstWidget = By.cssSelector("div:nth-child(2) > span[class*='react-resizable-handle']");
    public By divFirstWidget = By.cssSelector("div[class*='widgetsGrid__widget-view']:nth-child(2)");
    public By divSecondWidget = By.cssSelector("div[class*='widgetsGrid__widget-view']:nth-child(1)");

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public void clickHlkFirstDashBoard() {
        clickToElement(hlkFirstDashBoard);
    }

    public void resizeFirstWidget() {
        resizeElement(btnResizeFirstWidget, 150, 100);
    }

    public String getSizeFirstWidget() {
        return String.valueOf(getSize(divFirstWidget));
    }

    public String getLocationSecondWidget() {
        return String.valueOf(getLocation(divSecondWidget));
    }
}
