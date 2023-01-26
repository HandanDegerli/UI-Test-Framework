Feature: heroku Login And Logout Test

  Scenario: User Login Happy Path
    Given  User is getting Heroku Page
    Then User is clicking on the Login Page
    When User login with "tomsmith" username and "SuperSecretPassword!" password
    Then User should see the success message as "Welcome to the Secure Area. When you are done click logout below." on Login Page

    And User is clicking on the Logout Button
    Then User see that account text as "Login Page" is displayed

  Scenario: User Login Negative Path
    Given  User is getting Heroku Page
    Then User is clicking on the Login Page
    When User login with "oxox" incorrect username and "oxox" incorrect password
    Then User see that the error sign is displayed
