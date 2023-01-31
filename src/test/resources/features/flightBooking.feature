Feature: Booking Flight Case

  Scenario: User should be able to book a flight
    Given  User is getting Home Page
    Then User is clicking on the radio Button
    Then User is clicking on the From Box and select "Delhi" as From City
    Then User selects "Goa (Dabolim)" as Destination City
    Then User selects Date "18 February 2023" as Departure Date and Date "18 March 2023" as Return Date
    Then User add 3 Adult Passengers and is clicking on Done Button
    Then User selects currency as "GBP"
    Then User is clicking on the Search Flight Button
    Then User is navigated successfully and see "Select your Departure to "

