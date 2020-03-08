Feature: LoginFeature
  This feature deals with the login functionality of the applications
  Scenario: Login with correct username and password
    Given I navigate to the ExecuteAutomation Website
    And I enter the valid username as "admin" and password as "adminpass"
    And I click on login button
    Then I should see the userDetails page
