Feature: Widget On DashBoard

  Scenario: TC39_Resize Widget on Dashboard
    Given I open Report Portal page
    When I log in with given credentials
    And I click on hyperlink first dashboard
    And I resize the first widget
    Then I verify the size is changed in first widget
    Then I verify the location is changed in second widget