package com.lumatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Map;

public class DriverUtils {
    private static final ChromeOptions chromeOptions;
    private static final FirefoxOptions firefoxOptions;
    private static final SafariOptions safariOptions;

    static {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--ignore-certificate-errors");

        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--window-size=1920,1080");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");
        firefoxOptions.addArguments("--ignore-certificate-errors");

        safariOptions = new SafariOptions();
    }
    private static WebDriver createChromeDriver(WebDriver driver) {
        if(driver != null) {
            driver.quit();
        }

        ChromeDriver chromeDriver =  new ChromeDriver(chromeOptions);

        chromeDriver.executeCdpCommand("Network.enable", Map.of());
        chromeDriver.executeCdpCommand(
                "Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9")));

        return chromeDriver;
    }

    private static WebDriver createFirefoxDriver(WebDriver driver) {
        if(driver != null) {
            driver.quit();
        }
        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver createSafariDriver(WebDriver driver) {
        if(driver != null) {
            driver.quit();
        }
        return new SafariDriver(safariOptions);
    }

    public static WebDriver createDriver(String browser, WebDriver driver) {
        switch (browser) {
            case "chrome" -> {
                return createChromeDriver(driver);
            }
            case "firefox" -> {
                return createFirefoxDriver(driver);
            }
            case "safari" -> {
                return createSafariDriver(driver);
            }
            default -> {
                return null;
            }
        }
    }
}
