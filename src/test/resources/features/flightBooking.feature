@Booking
Feature: Booking Flight Case

  Background:
    Given  User is getting Home Page

  Scenario Outline: User should be able to book a flight
    When User is clicking on the Round Trip Button
    And User selects "Delhi" as Departure City
    And User selects "Goa (Dabolim)" as Destination City
    And User selects Date "18 February 2023" as Departure Date and Date "18 March 2023" as Return Date
    And User add 1 Adult Passengers and is clicking on Done Button
    And User selects currency as "GBP"
    Then User is clicking on the Search Flight Button

    Given User is navigated successfully and see "Select your Departure to "
    When User is selecting departure and return flights
    Then User is clicking on the Continue Button

    Given User is navigated to Passenger Detail Page successfully and see "Contact Details" as title
    When User enters the Contact Detail with: <name> and <lastname> and <contactNumber> and <email> and <country> and <city>
    And User fills the Passenger Form as follow <name> and <lastname>

    Then User click on Traveller Info Continue Button
    Then User click on Continue Adds On Button and Skip

    When User chooses to make purchase with pay on credit card
    And User enters payment detail with "6657 8900 4466 97" and "Odie" and "07" and "24" and "123"
    Then User proceeds the payment

    Examples:
      | name | lastname | contactNumber | email                       | country       | city |
      | odie | odie     | 6464747747    | romanpasierb@kitchen-tvs.ru | United States | LA   |





