Feature: Login feature

  Scenario: Login with valid credentials
    Given I am on the landing page
    When I click on sign-in button
    And I enter my username and password
    And I click the login button
    Then I should be redirected to the landing page







