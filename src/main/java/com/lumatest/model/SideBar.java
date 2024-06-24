package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract class SideBar extends BreadcrumbsMenu{
    @FindBy(linkText = "Bags")
    private WebElement bagsSideBar;
    protected SideBar(WebDriver driver) {
        super((driver));
    }

    @Step("Click Bags SideBar.")
    public BagsPage clickBagsSideBar() {
        bagsSideBar.click();

        return new BagsPage(getDriver());
    }
}
