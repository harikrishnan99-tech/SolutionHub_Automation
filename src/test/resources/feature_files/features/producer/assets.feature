Feature: Producer Assets Page

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

  Scenario: Verify "Products" category filter
    When producer selects primary category filter "Infrastructure Software"
    And producer selects secondary category filter "Network"
    Then producer should see all assets contained in category "Network"
    When producer selects primary category filter "DevOps"
    And producer selects secondary category filter "CICD Pipelines"
    Then producer should see all assets contained in category "CICD Pipelines"
    And producer should clear the filter

  Scenario: Verify "Solutions" category filter
    When producer selects primary category solution "Industry Solution"
    And producer selects secondary category solution "IT Software"
    Then producer should see all assets contained in given solution category "IT Software"
    When producer selects primary category solution "Industries"
    And producer selects secondary category solution "Healthcare"
    Then producer should see all assets contained in given solution category "Healthcare"
    And producer should clear the filter

  Scenario: Verify filters in assets page
    When producer selects filter "Delivery method"
    And producer selects delivery method "Solution"
    Then producer should see all assets based on given "Solution" filter
    When producer selects filter "Tooling"
    And producer selects delivery method "Cloudformation"
    Then producer should see all assets based on given "Cloud formation" filter
    When producer selects filter "Cloud"
    And producer selects delivery method "AWS"
    Then producer should see all assets based on given "AWS" filter
    When producer selects filter "Industry"
    And producer selects delivery method "Health"
    Then producer should see all assets based on given "Health" filter
    When producer selects filter "Regulation"
    And producer selects delivery method "SOC1"
    Then producer should see all assets based on given "SOC1" filter
    When producer selects filter "License"
    And producer selects delivery method "UST License"
    Then producer should see all assets based on given "UST License" filter
    When producer selects filter "Publisher"
    And producer selects delivery method "Test-Group"
    Then producer should see all assets based on given "Test-Group" filter













