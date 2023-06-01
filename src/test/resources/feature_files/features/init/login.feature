Feature: Login feature


  Scenario: Admin Login with valid credentials
    Given User is on the landing page
    When User click on sign-in button
    And User enter admin username and password
    And User click the login button
    Then User should see the Admin label on top of the page
    And User should logout


  Scenario: Producer Login with valid credentials
    Given User is on the landing page
    When User click on sign-in button
    And User enter producer username and password
    And User click the login button
    Then User should not see the Admin label on top of the page
    And User should logout

  Scenario: Group-admin Login with valid credentials
    Given User is on the landing page
    When User click on sign-in button
    And User enter group-admin username and password
    And User click the login button
    Then User should not see the Admin label on top of the page
    And User should logout











