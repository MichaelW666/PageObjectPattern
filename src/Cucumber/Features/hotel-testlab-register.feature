Feature: Hotel testlab registration

  Scenario: user can register with proper data

    Given user is on the hotel-testlab website
    When user clicks Sign in button
    When user inputs email address in Create an Account section
    And user clicks Create an account button
    When user fills "John" as first Name, "Kowalski" as last Name and "password" as password
    And user clicks Register
    Then "Your account has been created." is displayed

  Scenario: user cannot register with improper data

    Given user is on the hotel-testlab website
    When user clicks Sign in button
    When user inputs email address in Create an Account section
    And user clicks Create an account button
    When user fills "John" as first Name, "Kowalski" as last Name and "password" as password
    And user clicks Register
    Then "Your account has been created." is displayed