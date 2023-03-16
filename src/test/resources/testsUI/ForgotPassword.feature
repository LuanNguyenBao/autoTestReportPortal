Feature: Forgot Password on Report Portal

  Scenario Outline: TC09_Forgot Password with invalid email format as <email>
    Given I open Report Portal page
    When I click button forgot password
    And I forgot password with given email <email>
    Then The message <errorMessage> which incorrect email format displayed
    Examples:
      | email         | errorMessage                                    |
      | user01        | Email is incorrect. Please enter correct email. |
      | user01@       | Email is incorrect. Please enter correct email. |
      | user01@epam   | Email is incorrect. Please enter correct email. |
      | user01.com    | Email is incorrect. Please enter correct email. |
      | @epam.com     | Email is incorrect. Please enter correct email. |
      | @epam         | Email is incorrect. Please enter correct email. |
      | .com          | Email is incorrect. Please enter correct email. |