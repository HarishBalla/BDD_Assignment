@derivedProduct1
Feature: Derived product one tests

  @DPtest1 @ALL
  Scenario: Verify the titles and duration of slides below tickets
    Given I navigate to the derived product one homepage
    When I get the total number of slides under Tickets
    And I verify the titles of the slides
    Then I verify the duration of each slide