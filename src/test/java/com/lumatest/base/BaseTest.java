package com.lumatest.base;

import com.lumatest.data.TestData;
import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class BaseTest {
    private WebDriver driver;
//    private final String browser = "chrome";

    @BeforeSuite
    protected void setUpWebDriverManager() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.safaridriver().setup();
    }

    @Parameters("browser")
    @BeforeMethod
    protected void setupDriver(@Optional("chrome") String browser) {
        Reporter.log("_____________________________________________________", true);
        this.driver = DriverUtils.createDriver(browser, this.driver);

        if(getDriver() == null) {
            Reporter.log("ERROR: Unknown parameter 'browser' - " + browser + ".", true);

            System.exit(1);
        }
        Reporter.log("INFO: " + browser.toUpperCase() +  " driver created.", true);

        Reporter.log("INFO: BASE_URL " + TestData.BASE_URL + " opened.");
        Allure.step("Open Base URL");
        getDriver().get(TestData.BASE_URL);
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void teatDown(@Optional("chrome") String browser) {
        if(this.driver != null) {
            getDriver().quit();

            Reporter.log("INFO: " + browser.toUpperCase() + " driver was closed.", true);
            this.driver = null;
        } else {
            Reporter.log("INFO: Driver is null.", true);
        }
    }

    protected WebDriver getDriver() {
        return this.driver;
    }
}
