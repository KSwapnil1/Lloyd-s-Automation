Feature: Test Operator Creation

  Background:
    Given User login into the dev portal

  Scenario: Successful test operator creation
    Given user opens the SetBusinessIdentifier Utility
    And user click on the Action button
    And user clicks on the Run button
    And user fill details in the UserId and Business Identifier fields
    When user clicks on the Run button
    Then user sees the "Success" message in new window