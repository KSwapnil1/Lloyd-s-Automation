Feature: Maintain Entities

Scenario: To verify successfully update an Auditor through the Maintain Entities Menu Option
    Given User login into the application as CAF Manager
    And User clicks on Maintain Entities Menu Option
    When User clicks on Update Auditor option
    And User select the Auditor Name from the list
    And User updates the Auditor's information
    And User clicks on Update Auditor button
    Then User sees the Update Successful message
    And User logs out from the application

Scenario: To verify successfully update a Carrier through the Maintain Entities Menu Option
    Given User login into the application as CAF Manager
    And User clicks on Maintain Entities Menu Option
    When User clicks on Update Carrier option
    And User select the Carrier Name from the list
    And User updates the Carrier's information
    And User clicks on Update Carrier button
    Then User sees the Update Successful message
    And User logs out from the application

Scenario: To verify successfully update a Broker through the Maintain Entities Menu Option
    Given User login into the application as CAF Manager
    And User clicks on Maintain Entities Menu Option
    When User clicks on Update Broker option
    And User select the Broker Name from the list
    And User updates the Broker's information
    And User clicks on Update Broker button
    Then User sees the Update Successful message
    And User logs out from the application
