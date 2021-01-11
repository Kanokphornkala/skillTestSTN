Feature: test
@wip
  Scenario Outline: demo
    Given user is on homepage
    Then verify page is title is "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations"
    And verify top page banner has following links
  |Deals|Things to do|Packages & Flights|Groups & Meetings|Gift Cards|List your property|Hotels.com® Rewards|
    And user clicks on "Packages & Flights" on banner menu
    Then verify page is title is "Vacation Packages: Find Cheap Trips, Deals & Vacations | Hotels.com"
    When user clicks on "flightHotel" button
    And user enter "<origin>" origin city
    And user enter "<destination>" departing city
    And user enter "<departing>" date and "<returning>" date
    And user enter number of "<travelers>" and number of "<rooms>"
    And user select Airline "<class>"
    When user clicks on "Search" button
    And user clicks on "Distance from Downtown" button
    Then print list of hotels located withing 2 miles

  Examples:
  |origin|destination|departing|returning|travelers|rooms|class|
  |BWI   |MIA        |02/10/2021|02/15/2021|2       |1    |Economy|