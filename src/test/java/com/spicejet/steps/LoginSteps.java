package com.spicejet.steps;

import com.spicejet.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps{
    private LoginPage loginPage;

    public LoginSteps() {
        WebDriver driver = StepHooks.driver;
        this.loginPage = new LoginPage(driver);
    }

    @Given("User is getting Heroku Page")
    public void userIsGettingHerokuPage() throws IOException {
        loginPage.navigateToHomePage();
    }
    @Then("User is clicking on the Login Page")
    public void userIsClickingOnTheLoginPage() {
        loginPage.clickOnLoginPageButton();
        assertEquals(loginPage.getLoginPageTitle(), "Login Page");
    }

    @When("User login with {string} username and {string} password")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        loginPage.enterName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }

    @Then("User should see the success message as {string} on Login Page")
    public void userShouldSeeTheSuccessMessageAsOnLoginPage(String text) {
        assertEquals(loginPage.getSuccessText(), text);
    }

    @And("User is clicking on the Logout Button")
    public void userIsClickingOnTheLogoutButton() {
        loginPage.clickOnLogoutButton();
    }

    @Then("User see that account text as {string} is displayed")
    public void userSeeThatAccountTextAsIsDisplayed(String text) {
        assertEquals(loginPage.getAccountPageText(), text);
    }

    @When("User login with {string} incorrect username and {string} incorrect password")
    public void userLoginWithIncorrectUsernameAndIncorrectPassword(String username, String password) {
        loginPage.enterName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }
    @Then("User see that the error sign is displayed")
    public void userSeeThatTheErrorSignIsDisplayed() {
        assertTrue(loginPage.getErrorSign());
    }
}
