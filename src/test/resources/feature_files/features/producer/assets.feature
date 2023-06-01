Feature: Producer Assets Page

#  Background:
#    Given Producer is on SolutionHub landing page
#    When Producer signs-in to SolutionHub
#    And Producer click on assets tab

  Background:
    Given User is on the landing page
    When User click on sign-in button
    And User enter producer username and password
    Then User click the login button
    And User click on assets tab


  Scenario Outline: Search for assets by name
    When Producer enter "<asset_name>" in the search bar
    Then the search result should contain the asset name "<asset_result>"
    And User should logout

    Examples:
      | asset_name   | asset_result       |
      | private_test | Private_Test_20/03 |

  Scenario: Producer is able to sort assets by name and rating
    When producer sort assets by name in descending order
    Then assets should be displayed in alphabetical order by descending
    When producer sort assets by name in ascending order
    Then assets should be displayed in alphabetical order by ascending
    And User should logout
#    When producer sort assets by rating in ascending order
#    Then assets should be displayed in ascending order of rating
#    When producer sort assets by rating in descending order
#    Then assets should be displayed in descending order of rating

  Scenario: Assets view grid and list
    When producer click on List view button
    Then the assets should be displayed in a list format
    When producer click on Grid view button
    Then the assets should be displayed in a grid format
    And User should logout

  Scenario: Verify the number of assets displayed per page
    When producer select the option to display "25" assets per page
    Then producer should see "25" assets displayed on the page
    And User should logout











