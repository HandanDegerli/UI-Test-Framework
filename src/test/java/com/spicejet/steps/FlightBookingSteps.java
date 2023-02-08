package com.spicejet.steps;

import com.spicejet.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FlightBookingSteps {
    private HomePage homePage;
    private FlightSearchPage flightSearchPage;
    private PassengerDetailPage passengerDetailPage;
    private FlightDetailPage flightDetailPage;
    private PaymentPage paymentPage;

    private final Logger logger;

    public FlightBookingSteps() {
        WebDriver driver = StepHooks.driver;
        this.homePage = new HomePage(driver);
        this.flightSearchPage = new FlightSearchPage(driver);
        this.passengerDetailPage = new PassengerDetailPage(driver);
        this.flightDetailPage = new FlightDetailPage(driver);
        this.paymentPage = new PaymentPage(driver);
        logger = Logger.getLogger("FlightBookingSteps");
    }

    @Given("User is getting Home Page")
    public void user_is_getting_Home_Page() throws IOException {
        logger.info("Navigating to homepage");
        homePage.navigateToHomePage();

    }

    @When("User is clicking on the Round Trip Button")
    public void userIsClickingOnTheRoundTripButton() {
        logger.info("Booking a flight and choosing round trip");
        homePage.clickOnRadioButton();
    }

    @And("User selects {string} as Departure City")
    public void userSelectsAsDepartureCity (String city) {
        logger.info("Choosing From City as " + city + " for booking a flight");
        homePage.clickOnFromButton();
        homePage.selectCityFromList(city);
    }

    @And("User selects {string} as Destination City")
    public void userSelectsAsDestinationCity(String city) {
        logger.info("Choosing Destination City as " + city + " for booking a flight");
        homePage.selectCityFromList(city);
    }

    @And("User selects Date {string} as Departure Date and Date {string} as Return Date")
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

    @And("User add {int} Adult Passengers and is clicking on Done Button")
    public void userAddAdultPassengersAndIsClickingOnDoneButton(int adultNumber) {
        logger.info("Adding Adult Passenger's number for booking a flight");
        homePage.addPassengers(adultNumber);
    }

    @And("User selects currency as {string}")
    public void userSelectsCurrencyAs(String currency) {
        logger.info("Selecting currency as " + currency + " for booking a flight");
        homePage.selectCurrency(currency);
    }

    @Then("User is clicking on the Search Flight Button")
    public void userIsClickingOnTheSearchFlightButton() {
        logger.info("Making a flight search with some specific preferences");
        homePage.clickOSearchFlightButton();
    }

    @Given("User is navigated successfully and see {string}")
    public void userIsNavigatedSuccessfullyAndSee(String text) {
        logger.info("See the Flight List on the Navigated Page ");
        assertEquals(text, homePage.getNavigatedPageTitle());
    }

    @When("User is selecting departure and return flights")
    public void userIsSelectingDepartureAndReturnFlights() throws InterruptedException {
        flightSearchPage.clickOnDepartureAndReturnFlights();
    }

    @Then("User is clicking on the Continue Button")
    public void userIsClickingOnTheContinueButton() throws InterruptedException {
        flightSearchPage.clickOnContinueButton();
    }

    @Given("User is navigated to Passenger Detail Page successfully and see {string} as title")
    public void userIsNavigatedToPassengerDetailPageSuccessfullyAndSeeAsTitle(String title) {
        assertEquals(title, flightSearchPage.getContactDetailTitle());
    }

    @When("^User enters the Contact Detail with: (.*) and (.*) and (.*) and (.*) and (.*) and (.*)$")
    public void userEntersTheContactDetailWithNameAndLastnameAndContactNumberAndEmailAndCountryAndCity(String name, String lastname, String contactNumber, String email, String country, String city) {
        passengerDetailPage.fillContactDetails(name, lastname, contactNumber, email, country, city);
    }
    
    @And("^User fills the Passenger Form as follow (.*) and (.*)$")
    public void userFillsThePassengerFormAsFollowNameLastname(String name, String lastname) {
        passengerDetailPage.fillPassengerForm(name, lastname);
    }
    @Then("User click on Traveller Info Continue Button")
    public void userClickOnTravellerInfoContinueButton() {
        passengerDetailPage.clickOnTravellerInfoContinueButton();
    }

    @Then("User click on Continue Adds On Button and Skip")
    public void userClickOnContinueAddsOnButtonAndSkip() throws InterruptedException {
        flightDetailPage.clickOnAddsOnContinueButton();
    }

    @When("User chooses to make purchase with pay on credit card")
    public void userChoosesToMakePurchaseWithPayOnCreditCard() {
        paymentPage.selectPaymentMethod();
    }

    @And("User enters payment detail with {string} and {string} and {string} and {string} and {string}")
    public void userEntersPaymentDetailWithAndAndAndAnd(String numberOnCard, String cardName, String expirationMonth, String expirationYear, String securityNumber) throws InterruptedException {
        paymentPage.fillPaymentDetail(numberOnCard, cardName, expirationMonth, expirationYear, securityNumber);
    }

    @Then("User proceeds the payment")
    public void userProceedsThePayment() {
        paymentPage.proceedPayment();
    }


}
