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

    @When("User is clicking on the Holiday Button on the Top Bar")
    public void user_is_clicking_on_the_Holiday_Button_on_the_Top_Bar() {
        homePage.clickOnHolidayButton();
    }

    @And("User is clicking on Holiday Button on the Holiday Page")
    public void user_is_clicking_on_Holiday_Button_on_the_Holiday_Page() {
        holidayPage.clickOnHolidayButton();
    }

    @And("User see {string} as Welcome Text")
    public void user_see_as_Welcome_Text(String text) {
        Assert.assertEquals(text, holidayPage.getWelcomeText());
    }

    @And("User enters {string} as Destination City")
    public void user_enters_as_Destination_City(String city) {
        holidayPage.enterDestinationCity(city);
    }

    @And("User filter Trip Results as {string} And View First Option")
    public void user_filter_Trip_Results_as_And_View_First_Option(String packageType) {
        holidayPage.filterTripResultsAndViewFirstOption(packageType);
    }

    @Then("User see the {string}")
    public void user_see_the(String hotelDetailText) {
        Assert.assertEquals(hotelDetailText, holidayPage.getHotelDetailText());
    }
}
