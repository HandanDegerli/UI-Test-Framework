package com.spicejet.steps;

import com.spicejet.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FlightBookingSteps {
    private HomePage homePage;

    private final Logger logger;

    public FlightBookingSteps() {
        WebDriver driver = StepHooks.driver;
        this.homePage = new HomePage(driver);
        logger = Logger.getLogger("FlightBookingSteps");
    }

    @Given("User is getting Home Page")
    public void userIsGettingHomePage() throws IOException {
        logger.info("Navigating to homepage");
        homePage.navigateToHomePage();
    }

    @Then("User is clicking on the radio Button")
    public void userIsClickingOnTheRadioButton() {
        logger.info("Booking a flight and choosing round trip");
        homePage.clickOnRadioButton();
    }

    @Then("User is clicking on the From Box and select {string} as From City")
    public void userIsClickingOnTheFromBoxAndSelectAsFromCity(String city) {
        logger.info("Choosing From City as " + city + " for booking a flight");
        homePage.clickOnFromButton();
        homePage.selectCityFromList(city);
    }

    @Then("User selects {string} as Destination City")
    public void userSelectsAsDestinationCity(String city) {
        logger.info("Choosing Destination City as " + city + " for booking a flight");
        homePage.selectCityFromList(city);
    }

    @Then("User selects Date {string} as Departure Date and Date {string} as Return Date")
    public void userSelectsDateAsDepartureDateAndDateAsReturnDate(String departureDate, String returnDate) {

        logger.info("Choosing Departure date as " + departureDate + " and Return Date as " + returnDate + " for booking a flight");
        String[] departDateArr = departureDate.split(" ");
        String departMonth = departDateArr[1];
        String departDay = departDateArr[0];

        String[] returnDateArr = returnDate.split(" ");
        String returnMonth = returnDateArr[1];
        String returnDay = returnDateArr[0];
        homePage.setDepartureAndReturnDate(departDay, departMonth, returnDay, returnMonth);
    }

    @Then("User add {int} Adult Passengers and is clicking on Done Button")
    public void userAddAdultPassengersAndIsClickingOnDoneButton(int adultNumber) {
        logger.info("Adding Adult Passenger's number for booking a flight");
        homePage.addPassengers(adultNumber);
    }

    @Then("User selects currency as {string}")
    public void userSelectsCurrencyAs(String currency) {
        logger.info("Selecting currency as " + currency + " for booking a flight");
        homePage.selectCurrency(currency);
    }

    @Then("User is clicking on the Search Flight Button")
    public void userIsClickingOnTheSearchFlightButton() {
        logger.info("Making a flight search with some specific preferences");
        homePage.clickOSearchFlightButton();
    }

    @Then("User is navigated successfully and see {string}")
    public void userIsNavigatedSuccessfullyAndSee(String text) {
        logger.info("See the Flight List on the Navigated Page ");
        assertEquals(text, homePage.getNavigatedPageTitle());
    }
}
