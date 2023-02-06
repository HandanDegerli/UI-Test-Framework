package com.spicejet.pages;

import com.spicejet.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PassengerDetailPage extends Base {

    @FindBy(css = "div#primary-contact-details div:nth-child(1)")
    private List<WebElement> contactDetails;

    @FindBy(css = "div[data-testid='title-contact-detail-card']")
    private WebElement titleDropdown;

    @FindBy(css = "div.css-76zvg2.r-homxoj.r-poiln3.r-ubezar")
    private List<WebElement> titleList;

    @FindBy(css = "input[data-testid='first-inputbox-contact-details']")
    private WebElement nameInput;

    @FindBy(css = "input[data-testid='last-inputbox-contact-details']")
    private WebElement lastnameInput;

    @FindBy(css = "input[data-testid='contact-number-input-box']")
    private WebElement contactNumberInput;

    @FindBy(css = "input[data-testid='emailAddress-inputbox-contact-details']")
    private WebElement emailInput;

    @FindBy(css = "div.css-76zvg2.css-bfa6kz.r-homxoj.r-poiln3.r-ubezar")
    private List<WebElement> textWithDropdownList;

    @FindBy(css = "input.css-1cwyjr8.r-19fu0aa.r-kicko2.r-1862ga2.r-13awgt0.r-poiln3.r-1enofrn.r-10paoce.r-ymttw5.r-5njf8e.r-b8lwoo")
    private WebElement country;

    @FindBy(css = "div.css-76zvg2.r-qsz3a2.r-poiln3.r-n6v787.r-1e081e0.r-oyd9sg")
    private List<WebElement> countryList;

    @FindBy(css = "input[data-testid='city-inputbox-contact-details']")
    private WebElement cityInput;

    @FindBy(css = "div.css-1dbjc4n.r-18u37iz.r-y3xmzu")
    private WebElement checkbox;

    @FindBy(css = "input[data-testid='traveller-0-first-traveller-info-input-box']")
    private WebElement passengerNameInput;

    @FindBy(css = "input[data-testid='traveller-0-last-traveller-info-input-box']")
    private WebElement passengerLastnameInput;

    @FindBy(css = "div[data-testid='traveller-info-continue-cta']")
    private WebElement travellerInfoContinueButton;

    public PassengerDetailPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactDetails(String name, String lastname, String contactNumber, String email, String country, String city){
        titleDropdown.click();
        titleList.get(1).click();
        waitUntilClickable(titleDropdown).click();
        titleList.get(1).click();
        nameInput.sendKeys(name);
        lastnameInput.sendKeys(lastname);
        contactNumberInput.sendKeys(contactNumber);
        emailInput.sendKeys(email);
        textWithDropdownList.get(2).click();
        for (WebElement c:countryList){
            try {
                if (c.getText().equals(country)){
                    c.click();
                }
            }catch (Exception e){
                System.out.println(e);
            }

        }
        cityInput.sendKeys(city);

        checkbox.click();

    }

    public void fillPassengerForm(String name, String lastname){
        passengerNameInput.sendKeys(name);
        passengerLastnameInput.sendKeys(lastname);
    }

    public void clickOnTravellerInfoContinueButton(){
        travellerInfoContinueButton.click();
    }
}
