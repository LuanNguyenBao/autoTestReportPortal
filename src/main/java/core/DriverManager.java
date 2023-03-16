package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverManager {
    private static DriverManager instance = null;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    public void initDriver(String name) throws Exception {
        switch (name.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                threadDriver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                threadDriver.set(new FirefoxDriver());
                break;
            default:
                throw new Exception(String.format("Browser %s is invalid!", name));
        }
        getDriver().manage().window().maximize();
    }

    public void initRemoteDriver(String browserName) throws Exception {
        AbstractDriverOptions options;
        switch (browserName.toLowerCase()) {
            case "chrome":
                options = new ChromeOptions();
                break;
            case "firefox":
                options = new FirefoxOptions();
                break;
            default:
                throw new Exception(String.format("Browser %s is invalid!", browserName));
        }
        threadDriver.set(new RemoteWebDriver(new URL("http://chrome:4444"), options));
    }

    public void closeDriver() {
        try {
            getDriver().quit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            threadDriver.remove();
        }
    }
}
