package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    private WebDriver driver;
//    private final String browser = "chrome";

    @BeforeSuite
    protected void setUpWebDriverManager() {
        WebDriverManager.chromiumdriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.safaridriver().setup();
    }

    @Parameters("browser")
    @BeforeMethod
    protected void setupDriver(String browser) {
        Reporter.log("_____________________________________________________", true);
        this.driver = DriverUtils.createDriver(browser, this.driver);

        if(getDriver() == null) {
            Reporter.log("ERROR: Unknown parameter 'browser' - " + browser + ".", true);

            System.exit(1);
        }
        Reporter.log("INFO: " + browser.toUpperCase() +  " driver created.", true);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void teatDown(String browser) {
        if(this.driver != null) {
            getDriver().quit();

            Reporter.log("INFO: " + browser.toUpperCase() + " driver was closed.", true);
            this.driver = null;
        } else {
            Reporter.log("INFO: Driver is null.", true);
        }
    }
}
