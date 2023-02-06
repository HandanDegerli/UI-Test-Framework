package com.spicejet.pages;

import com.spicejet.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightDetailPage extends Base {

    @FindBy(css = "div[data-testid='baggage']")
    private WebElement baggage;

    @FindBy(css = "div[data-testid='add-ons-continue-footer-button']")
    private List<WebElement> buttonList;

    @FindBy(css = "span#skipfrompopup")
    private List<WebElement> skipList;

    public FlightDetailPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddsOnContinueButton(){
        scrollToElement(baggage);
        buttonList.get(2).click();
        skipList.get(0).click();
    }
}
