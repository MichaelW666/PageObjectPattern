Feature: add new user Address

  Scenario: user adds new address for existing account

    Given user with hotel-testlab account with opened website
    When user logs in with "johndoe@mail.com" and "qwerty"
    And user goes to My addresses page
    And user clicks Add a new address button
    When user fills "Sezamkowa 12", "00-001", "Lublin", "123321", "321456" and "Moj adres"
    Then new address "Moj adres" appears on My Addresses page
