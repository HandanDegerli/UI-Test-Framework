package com.spicejet.pages;

import com.spicejet.core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentPage extends Base {

    @FindBy(css = "div.css-1dbjc4n.r-4qswn0.r-1phboty.r-13yce4e.r-rs99b7.r-1pcd2l5.r-13qz1uu")
    private List<WebElement> paymentMethodList;

    @FindBy(css = "iframe")
    private List<WebElement> iframeList;

    @FindBy(css = "input#card_number.card_number")
    private WebElement cardNumber;

    @FindBy(css = "input#name_on_card")
    private WebElement nameOnCard;

    @FindBy(css = "input#card_exp_month")
    private WebElement expMonth;

    @FindBy(css = "input#card_exp_year")
    private WebElement expYear;

    @FindBy(css = "input#security_code")
    private WebElement securityCode;

    @FindBy(css = "div.css-1dbjc4n.r-7o8qx1")
    private List<WebElement> checkBoxList;

    @FindBy(css = "div[data-testid='common-proceed-to-pay']")
    private WebElement proceedButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectPaymentMethod(){

        paymentMethodList.get(0).click();
    }

    public void fillPaymentDetail(String numberOnCard, String cardName, String expirationMonth, String expirationYear, String securityNumber) throws InterruptedException {
        Thread.sleep(3000);

        driver.switchTo().frame(iframeList.get(0));
        cardNumber.sendKeys(numberOnCard);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeList.get(1));
        nameOnCard.sendKeys(cardName);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeList.get(2));
        expMonth.sendKeys(expirationMonth);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeList.get(3));
        expYear.sendKeys(expirationYear);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeList.get(4));
        securityCode.sendKeys(securityNumber);
        driver.switchTo().defaultContent();
        checkBoxList.get(1).click();
    }

    public  void proceedPayment(){
        waitUntilClickable(proceedButton).click();
    }


}
