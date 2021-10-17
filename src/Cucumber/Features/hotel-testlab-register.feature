Feature: Hotel testlab registration

  Scenario Outline: user can register with proper data

    Given user is on the hotel-testlab website
    When user clicks Sign in button
    When user inputs "<email>" address in Create an Account section
    And user clicks Create an account button
    When user fills "<firstName>" as first Name, "<lastName>" as last Name and "<password>" as password
    And user clicks Register
    Then "Your account has been created." is displayed

    Examples:
    |firstName|lastName|password|email               |
    |John     |Kowalski|qwerty  |mail6745645@mail.com|
    |Piotr    |Nowak   |123456  |mail5245345@mail.com|