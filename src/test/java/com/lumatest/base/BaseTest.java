package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeSuite
    protected void setUpWebDriverManager() {
        WebDriverManager.chromiumdriver().setup();
    }

    @BeforeMethod
    protected void setup() {
        this.driver = DriverUtils.createChromeDriver(getDriver());
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @AfterMethod(alwaysRun = true)
    protected void teatDown() {
        if(this.driver != null) {
            getDriver().quit();
            this.driver = null;
        }
    }

}
