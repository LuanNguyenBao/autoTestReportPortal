Feature: Login on Report Portal

  Scenario: TC01_Login successfully
    Given I open Report Portal page
    When I log in with given credentials
    Then I am able to log successfully