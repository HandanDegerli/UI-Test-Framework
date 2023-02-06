package com.spicejet.pages;

import com.spicejet.core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightSearchPage extends Base {

    @FindBy(css = "div#list-results-section-0 > div:nth-child(5) > div")
    private List<WebElement> departureList;

    @FindBy(css = "div#list-results-section-1 > div:nth-child(5) > div")
    private List<WebElement> returnList;

    @FindBy(css = "div[data-testid='continue-search-page-cta']")
    private WebElement continueButton;

    @FindBy(css = "div#primary-contact-details div:nth-child(1)")
    private List<WebElement> contactDetails;

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnDepartureAndReturnFlights() throws InterruptedException {
        Thread.sleep(4000);
        WebElement saverPriceList = departureList.get(1).findElement(By.cssSelector("div[data-testid='spicesaver-flight-select-radio-button-1']"));
        waitUntilClickable(saverPriceList).click();
        Thread.sleep(3000);
        WebElement saverPrice = returnList.get(0).findElement(By.cssSelector("div[data-testid='spicesaver-flight-select-radio-button-1']"));
        //scrollToElement(saverPrice).click();
    }
    public void clickOnContinueButton() throws InterruptedException {
        Thread.sleep(3000);
        waitUntilClickable(continueButton).click();
    }
    public String getContactDetailTitle(){
        return contactDetails.get(0).getText();
    }
}
