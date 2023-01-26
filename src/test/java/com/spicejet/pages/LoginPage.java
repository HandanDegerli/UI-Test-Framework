package com.spicejet.pages;

import com.spicejet.core.PropertyReader;
import com.spicejet.core.Base;
import com.spicejet.core.PropKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends Base {

    @FindBy(css = "a[href='/login']")
    private WebElement loginPageButton;

    @FindBy(tagName = "h2")
    private WebElement loginPageTitle;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button.radius")
    private WebElement loginButton;

    @FindBy(tagName = "h4")
    private WebElement successLoginText;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(tagName = "h2")
    private WebElement accountPageText;

    @FindBy(id = "flash")
    private WebElement errorSign;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() throws IOException {
        driver.get(PropertyReader.getInstance().getProp(PropKey.URL.getPropVal()));
    }

    public void clickOnLoginPageButton(){
        loginPageButton.click();
    }

    public String getLoginPageTitle(){return loginPageTitle.getText();}
    public void enterName(String name) {
        userNameInput.sendKeys(name);
    }

    public void enterPassword(String name){
        passwordInput.sendKeys(name);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public String getSuccessText(){
        return successLoginText.getText();
    }

    public void clickOnLogoutButton(){
        logoutButton.click();
    }

    public String getAccountPageText(){
        return accountPageText.getText();
    }
    public boolean getErrorSign(){
        return errorSign.isDisplayed();
    }

}
