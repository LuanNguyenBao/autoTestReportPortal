package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(5); // seconds
    private static final Duration POLLING = Duration.ofMillis(100); // milli seconds

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisible(By locator) {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementClickable(By locator) {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickToElement(By locator) {
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }

    public void clickToElementByJS(By locator) {
        String script = "arguments[0].click();";
        ((JavascriptExecutor) driver).executeScript(script, driver.findElement(locator));
    }

    public void sendKeyToElement(By locator, String text) {
        WebElement element = null;
        waitForElementVisible(locator);
        element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement element = null;
        waitForElementVisible(locator);
        element = driver.findElement(locator);
        return element.getText();
    }

    public Point getLocation(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).getLocation();
    }

    public Dimension getSize(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).getSize();
    }

    public void dragAndDrop(By locatorFrom, By locatorTo) {
        WebElement fromElement = driver.findElement(locatorFrom);
        WebElement toElement = driver.findElement(locatorTo);
        Actions action = new Actions(driver);
        action.dragAndDrop(fromElement, toElement).build().perform();
    }

    public void resizeElement(By locator, int xOffset, int yOffset) {
        WebElement elementToResize = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
    }

    public void scrollToElementByJS(By locator) {
        String script = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor) driver).executeScript(script, driver.findElement(locator));
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = null;
            waitForElementVisible(locator);
            element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isElementVisibleInViewportByJS(By locator) {
        String script = "var elem = arguments[0],         " +
                "  box = elem.getBoundingClientRect(),    " +
                "  cx = box.left + box.width / 2,         " +
                "  cy = box.top + box.height / 2,         " +
                "  e = document.elementFromPoint(cx, cy); " +
                "for (; e; e = e.parentElement) {         " +
                "  if (e === elem)                        " +
                "    return true;                         " +
                "}                                        " +
                "return false;                            ";
        return (Boolean)((JavascriptExecutor) driver).executeScript(script, driver.findElement(locator));
    }
}
