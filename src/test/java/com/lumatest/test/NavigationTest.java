package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    @Severity(SeverityLevel.BLOCKER)
    @Description("TC01 Open base URL")
    @Story("Navigation")
    @Link(TestData.BASE_URL)
    @Test(groups = "Regression")
    public void testOpenBaseUrl() {
        Allure.step("SetUp expected results");
        final String expectedUrl = TestData.BASE_URL + "/";
        final String expectedTitle = TestData.BASE_URL_TITLE;

        Allure.step("Open Base URL");
        getDriver().get(TestData.BASE_URL);

        Allure.step("Collect actual URL and title");
        String actualUrl = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Allure.step("Verify actual URL and title as expected");
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("TC02 Check navigation menu")
    @Story("Navigation")
    @Test(dataProvider = "navigationData", dataProviderClass = TestData.class)
    public void testNavigationMenu(String baseURL, By navBarMenu, String expectedUrl, String expectedTitle) {
        Allure.step("Open Base URL");
        getDriver().get(baseURL);

        Allure.step("Click on " + navBarMenu.toString());
        getDriver().findElement(navBarMenu).click();

        Allure.step("Collect actual URL and title");
        String actualUrl = getDriver().getCurrentUrl();
        String actualTitle = getDriver().getTitle();

        Allure.step("Verify actual URL and title as expected");
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
