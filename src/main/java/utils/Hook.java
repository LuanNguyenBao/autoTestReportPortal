package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import core.DriverManager;

import java.util.Objects;

public class Hook {
    public String browser;

    @Before
    public void setUp() throws Exception {
        System.out.println("Before annotation");
        String browser = System.getProperty("browser");
        boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote"));
        if (browser == null) {
            browser = new PropertyReader().readGlobalProp("browser");
        }
        if (isRemote) {
            DriverManager.getInstance().initRemoteDriver(browser);
        }
        else {
            DriverManager.getInstance().initDriver(browser);
        }
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            scenario.attach(ScreenCapture.takeScreenShot(DriverManager.getInstance().getDriver()), "image/png", "screenshot: " + scenario.getName());
        }
        DriverManager.getInstance().closeDriver();
    }
}
