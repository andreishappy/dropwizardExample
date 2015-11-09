Feature: Contacts

  Scenario: Create new contact
    When I try to create a new user with the name: "Andrei"
    Then The request succeeds
