@derivedProduct2
Feature: User View product, Purchase Product

  @DPtest2 @ALL
  Scenario: Verify the duplicate hyperlinks in footers of derived product two
    Given I navigate to the homepage of derived product two
    When I scroll down to the footer
    And Verify all the expected categories are available in the footer section
    And I get all the hyperlinks of the all the categories in the footer and add to CSV file
    Then I validate if duplicates are present in the hyperlinks