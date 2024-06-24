package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract class BreadcrumbsMenu extends TopMenu {
    @FindBy(css = "ul.items")
    private WebElement breadcrumbsMenu;
    protected BreadcrumbsMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Get Breadcrumbs Menu.")
    public String getBreadcrumbsMenu() {
        return getWait5().until(ExpectedConditions.visibilityOf(breadcrumbsMenu)).getText();
    }
}
