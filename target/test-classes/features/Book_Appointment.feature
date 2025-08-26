@book-appointment @regression
Feature: Cura Healthcare - Book Appointment

  Background:
    Given The user is logged in
    Then I access the Cura Healthcare Book Appointment Page

  Scenario Outline:
    And I choose the facility <facility>
    And I "<checkboxState>" the "applying for hospital admission" checkbox
    And I choose the Healthcare Program <healthcareProgram>
    And I choose the visit date
    And I leave a comment
    And I click on book appointment button
    Then I should be redirected to the Appointment Confirmation page

    Examples:
      | facility                        | healthcareProgram | checkboxState |
      | Tokyo CURA Healthcare Center    | Medicare          | check         |
      | Tokyo CURA Healthcare Center    | Medicare          | uncheck       |
      | Tokyo CURA Healthcare Center    | Medicaid          | check         |
      | Tokyo CURA Healthcare Center    | Medicaid          | uncheck       |
      | Tokyo CURA Healthcare Center    | None              | check         |
      | Tokyo CURA Healthcare Center    | None              | uncheck       |
      | Hongkong CURA Healthcare Center | Medicare          | check         |
      | Hongkong CURA Healthcare Center | Medicare          | uncheck       |
      | Hongkong CURA Healthcare Center | Medicaid          | check         |
      | Hongkong CURA Healthcare Center | Medicaid          | uncheck       |
      | Hongkong CURA Healthcare Center | None              | check         |
      | Hongkong CURA Healthcare Center | None              | uncheck       |
      | Seoul CURA Healthcare Center    | Medicare          | check         |
      | Seoul CURA Healthcare Center    | Medicare          | uncheck       |
      | Seoul CURA Healthcare Center    | Medicaid          | check         |
      | Seoul CURA Healthcare Center    | Medicaid          | uncheck       |
      | Seoul CURA Healthcare Center    | None              | check         |
      | Seoul CURA Healthcare Center    | None              | uncheck       |

