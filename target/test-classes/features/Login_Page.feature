@login-page @regression
Feature: Cura Healthcare - Login Page

  Background:
    Given I access the Cura Healthcare Login Page

  Scenario Outline: Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on the login button
    Then I should <outcome>

    Examples:
      | username | password           | outcome                               |
      | John Doe | ThisIsNotAPassword | be redirected to the appointment page |
      | John Doe | wrongPassword      | see an error message                  |