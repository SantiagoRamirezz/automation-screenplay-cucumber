Feature: Login

  @LOG001 @web
  Scenario: Successful login
    Given the user logs in with valid credentials
    Then the dashboard should be visible