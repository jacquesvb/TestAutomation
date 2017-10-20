Feature: Checkbox

  Scenario: Manipulate checkbox in App
    As a user I should be able to check and uncheck a checkbox

    When I launch the ApiDemos app
    And I select Preference
    And I select 4. Default values
    Then the checkbox is validated