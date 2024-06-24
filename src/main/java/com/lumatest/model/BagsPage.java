package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BagsPage extends SideBar{
    protected BagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click {productName} Img.")
    public ProductPage clickProductImg(String productName) {
        String css = "[alt='" + productName + "']";
        getDriver().findElement(By.cssSelector(css)).click();

        return new ProductPage(getDriver());
    }
}
