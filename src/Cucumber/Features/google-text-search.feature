Feature: Google search

  Scenario: user can search any keyword

    Given an open browser with google.com
    When a keyword "selenium" is entered in input field
    Then the first one should contain "selenium"
    And close browser