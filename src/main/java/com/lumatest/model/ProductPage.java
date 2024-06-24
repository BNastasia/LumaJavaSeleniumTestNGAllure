package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BreadcrumbsMenu{
    @FindBy(css = "[itemprop='name']")
    private WebElement productName;

    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Product Name Text.")
    public String getProductNameText() {
        return productName.getText();
    }
}
