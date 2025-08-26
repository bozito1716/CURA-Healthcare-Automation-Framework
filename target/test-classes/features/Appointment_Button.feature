@appointment-button @regression
Feature: Cura Healthcare - Make an Appointment Button

  Background:
    Given I access the Cura Healthcare Home Page

  Scenario: Redirect to login page when clicking Make Appointment button
    When I click on make appointment button
    Then I should be redirected to the login page

  Scenario: Redirect to login page when using the toggle menu button
    When I click on toggle menu
    And I click on login
    Then I should be redirected to the login page