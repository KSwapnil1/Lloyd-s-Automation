Feature: ARF Journey

Scenario: To verify the successful completion of ARF Journey
    Given User login into the application as CAF Manager
    And User creates the ARF Case ID
    And User logs out from the application
    When User login into the application as Auditor Manager
    And User opens ARF form
    And User fills and submit the ARF form for newly created ARF case ID
    And User sees the status as Pending-WithCAF
    And User logs out from the application
    Then User login into the application as CAF Manager
    And User opens ARF form
    And User accepts and submits the ARF case
    And User sees the status as Resolved-Completed




