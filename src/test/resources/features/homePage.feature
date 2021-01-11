Feature: test
@wip
  Scenario: demo
    Given user is on homepage
    Then verify page is title is "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations"
    And verify top page banner has following links
  |Deals|Things to do|Packages & Flights|Groups & Meetings|Gift Cards|List your property|Hotels.com® Rewards|
    And user clicks on "Packages & Flights" on banner menu
    Then verify page is title is "Vacation Packages: Find Cheap Trips, Deals & Vacations | Hotels.com"
