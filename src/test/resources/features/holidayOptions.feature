@Holiday
Feature: Find Holiday And View Detail Case

  Background:
    Given  User is getting Home Page

  Scenario: User should be able to find a holiday package
    When User is clicking on the Spice Holidays Button on the Home Page
    And User is clicking on Holiday Button on the Holiday Page
    And User see "Get best deals on Domestic & International Holiday packages!" as Welcome Text
    And User enters "Goa" as Destination City
    And User filter Trip Results as "Beach Trip"
    And User view First Trip Option
    Then User see the "HOTEL DETAILS" text




