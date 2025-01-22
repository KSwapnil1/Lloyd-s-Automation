Feature: ADP Case Creation and Resolution

Scenario: Verifying the successful resolution of ADP case
  Given User login into the application as CAF Manager
  And User creates the ADP case for carrier
  And User logs out from the application
  When User login into the application as Carrier Manager
  And User Successfully resolve the ADP case
  Then User sees the status as Resolved-Completed for ADP Case
  And User logs out from the application