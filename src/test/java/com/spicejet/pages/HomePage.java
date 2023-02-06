package com.spicejet.pages;

import com.spicejet.core.Base;
import com.spicejet.core.PropKey;
import com.spicejet.core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HomePage extends Base {

    @FindBy(css = "div[data-testid='round-trip-radio-button'] > div")
    private WebElement roundTripRadioButton;

    @FindBy(css = "div[data-testid='to-testID-origin']")
    private WebElement fromButton;
    @FindBy(css = "div.css-76zvg2.r-cqee49.r-ubezar.r-1kfrs79")
    private List<WebElement> destinationCityList;

    @FindBy(css = "div[data-testid*='undefined-month']")
    private List<WebElement> months;

    By daysOfMonth = By.cssSelector("div.css-1dbjc4n.r-1awozwy.r-1pi2tsx.r-1777fci.r-13qz1uu");

    @FindBy(css = "div.css-76zvg2.css-bfa6kz.r-homxoj.r-ubezar")
    private List<WebElement> boxList;

    @FindBy(css = "div[data-testid='Adult-testID-plus-one-cta']")
    private WebElement increaseAdultPassengerNumberBtn;

    @FindBy(css = "div[data-testid='Adult-testID-minus-one-cta']")
    private WebElement decreaseAdultPassengerNumberBtn;

    @FindBy(css = "div[data-testid='home-page-travellers-done-cta']")
    private WebElement doneButton;

    @FindBy(css = "div.css-1dbjc4n.r-1habvwh.r-1loqt21.r-1777fci.r-1mi0q7o.r-1yt7n81.r-m611by.r-1otgn73")
    private List<WebElement> currencyOptionList;

    @FindBy(css = "div[data-testid='home-page-flight-cta']")
    private WebElement searchFlightButton;

    @FindBy(css = "div.css-76zvg2.r-homxoj.r-adyw6z.r-1kfrs79")
    private WebElement navigatedPageTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() throws IOException {
        driver.get(PropertyReader.getInstance().getProp(PropKey.URL.getPropVal()));
    }

    public void clickOnRadioButton() {
        roundTripRadioButton.click();
    }

    public void clickOnFromButton() {
        fromButton.click();
    }

    public void selectCityFromList(String city) {
        destinationCityList.stream().filter(c -> Objects.equals(c.getText(), city)).findFirst().get().click();
    }

    public void setDepartureAndReturnDate(String departureDate, String monthOfDepartureDate, String returnDate, String monthOfReturnDate){
        List<WebElement> daysOfDepartureDate = months.stream().filter(m -> m.getText().contains(monthOfDepartureDate)).findFirst().get().findElements(daysOfMonth);
        daysOfDepartureDate.stream().filter(d -> d.getText().equalsIgnoreCase(departureDate)).findFirst().get().click();

        List<WebElement> daysOfReturnDate = months.stream().filter(m -> m.getText().contains(monthOfReturnDate)).findFirst().get().findElements(daysOfMonth);
        daysOfReturnDate.stream().filter(d -> d.getText().equalsIgnoreCase(returnDate)).findFirst().get().click();
    }

    public void addPassengers(int adultNumber){
        boxList.get(2).click();
        setAdultPassengerNumber(adultNumber);
        doneButton.click();
    }

    public void selectCurrency(String currency){
        boxList.get(3).click();
        currencyOptionList.stream().filter(c -> c.getText().equals(currency)).findFirst().get().click();
        waitUntilClickable(doneButton).click();
    }

    public void clickOSearchFlightButton(){
        waitUntilClickable(searchFlightButton).click();
    }

    public String getNavigatedPageTitle(){
        return waitUntilVisible(navigatedPageTitle).getText();
    }

    private void setAdultPassengerNumber(int adultNumber){
        if(adultNumber > 1) {
            for(int i = 0; i < adultNumber-1; i++){
                waitUntilClickable(increaseAdultPassengerNumberBtn).click();
            }
        }else if(adultNumber < 1) {
            for(int j = 0; j < 2 - adultNumber; j++){
                waitUntilClickable(decreaseAdultPassengerNumberBtn).click();
            }
        }
    }

}













