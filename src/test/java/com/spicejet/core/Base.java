package com.spicejet.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public abstract class Base{
    protected static WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private final JavascriptExecutor js;

    public Base(WebDriver driver) {
        Base.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        PageFactory.initElements(driver,this);
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public WebElement waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void mouseHoverAndClick(WebElement webElement) {
        actions.moveToElement(webElement).click().perform();
    }

    public WebElement scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
    }
}
