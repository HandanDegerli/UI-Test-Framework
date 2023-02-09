package com.spicejet.steps;

import com.spicejet.pages.HolidayPage;
import com.spicejet.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class HolidayOptionsSteps {

    private HomePage homePage;
    private HolidayPage holidayPage;
    private final Logger logger;

    public HolidayOptionsSteps (){
        WebDriver driver = StepHooks.driver;
        this.homePage = new HomePage(driver);
        this.holidayPage = new HolidayPage(driver);
        this.logger = Logger.getLogger("HolidayOptionsSteps");
    }

    @When("User is clicking on the Spice Holidays Button on the Home Page")
    public void user_is_clicking_on_the_Spice_Holiday_Button_on_the_Home_Page() {
        logger.info("Clicking on Spice Holiday Button on the Home Page");
        homePage.clickOnHolidayButton();
    }
    @And("User is clicking on Holiday Button on the Holiday Page")
    public void user_is_clicking_on_Holiday_Button_on_the_Holiday_Page() {
        logger.info("Clicking on Holiday Button on the Holiday Page");
        holidayPage.clickOnHolidayButton();
    }

    @And("User see {string} as Welcome Text")
    public void user_see_as_Welcome_Text(String text) {
        logger.info("Assertion to understand that is navigated to Holiday Page successfully");
        Assert.assertEquals(text, holidayPage.getWelcomeText());
    }

    @And("User enters {string} as Destination City")
    public void user_enters_as_Destination_City(String city) {
        logger.info("Enter Destination City and select the city from dropdown on the Holiday Page");
        holidayPage.enterDestinationCity(city);
    }

    @And("User filter Trip Results as {string}")
    public void user_filter_Trip_Results_as(String packageType) {
        logger.info("Filtering Trip Results according to Package Type on the Holiday Page");
        holidayPage.filterTripResults(packageType);
    }

    @And("User view First Trip Option")
    public void user_view_First_Trip_Option() {
        logger.info("View first option of Trip Results");
        holidayPage.ViewFirstOption();
    }

    @Then("User see the {string} text")
    public void user_see_the_text(String hotelDetailText) {
        logger.info("Assertion to understand that page is navigated to Package Detail Page successfully");
        Assert.assertEquals(hotelDetailText, holidayPage.getHotelDetailText());
    }

}
