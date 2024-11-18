@coreProduct
Feature: Core Product automation as part of assignment

  @CPtest1 @ALL
  Scenario: Test case 1 for core product - Jacket details from all pages
    Given I navigate to the core product homepage
    When I navigate to Shop menu and click Men option and switch to new window
    And Select Jackets radio button from All departments option
    Then Calculate the number of pages for jackets
    And Get the details of every single jacket from all the pages and store to text file
    Then Create a text file with all the jacket details and attach to report
    
  @CPtest2 @ALL
  Scenario: Test case 2 for core product - Number of video feeds posted minimum three days ago
    Given I navigate to the core product homepage
    When I navigate to NEWS AND FEATURE under menu bar
    And I scroll down to the Videos feed pane
    Then Get the count of videos posted more than three days ago