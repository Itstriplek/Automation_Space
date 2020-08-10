#Author: profile.kumarkrish@gmail.com
@tag
Feature: Car booking
  I want to use this template for my feature file

  @tag1
  Scenario: Selecting my car
    Given I am in budget.com home page
    And I enter the pick up location, select the pickup and drop date
    When I click on select my car button
    Then I get a dialouge box to confirm the location
    And selecting SUV cars sorting the prices from low to high
    And I click on view vehicle information and paynow
    Then Summary is displayed for the selected car and amount to be paid is verified
