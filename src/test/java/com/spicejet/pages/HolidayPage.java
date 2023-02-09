package com.spicejet.pages;

import com.spicejet.core.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class HolidayPage extends Base {

    @FindBy(linkText = "Holidays")
    private WebElement holidayButton;

    @FindBy(tagName = "h1")
    private WebElement bestDealsText;

    @FindBy(css = "input#txtDesCity")
    private WebElement destinationCityInput;

    @FindBy(css = "li.ng-scope")
    private List<WebElement> destinationCities;

    @FindBy(css = "div[title='Filter'] > img")
    private WebElement filterButton;

    @FindBy(css = "ul#menu2 > li > a")
    private List<WebElement> packageTypeList;

    @FindBy(css = "div.ful-img-m")
    private List<WebElement> holidayPackages;

    @FindBy(css = "li#pdhlv > a")
    private WebElement hotelDetailText;

    public HolidayPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnHolidayButton() {
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(driver.getWindowHandle())) {
                driver.switchTo().window(actual);
            }
        }
        waitUntilClickable(holidayButton).click();
    }

        public String getWelcomeText () {
            return waitUntilVisible(bestDealsText).getText();
        }

        public void enterDestinationCity (String city){
            destinationCityInput.sendKeys(city);
            WebElement destinationCity = destinationCities.stream().filter(c -> c.getText().equalsIgnoreCase(city)).findFirst().orElseThrow(null);
            waitUntilClickable(destinationCity).click();
        }

        public void filterTripResults(String packageType){
        waitUntilClickable(filterButton).click();
        waitUntilClickable(packageTypeList.stream().filter(p ->p.getText().equalsIgnoreCase(packageType)).findFirst().orElseThrow(null)).click();
        }

        public void ViewFirstOption(){
            waitUntilClickable(holidayPackages.get(0)).click();
        }

        public String getHotelDetailText(){
        return waitUntilVisible(hotelDetailText).getText();
        }

}
