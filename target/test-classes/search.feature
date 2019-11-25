Feature: Search Functionality
  As a customer
  I want to search a product
  so that i can see desire product

  Background:
    Given I am on homepage

  Scenario:
    When I search for "Laptops"
    Then I can see desire products
    Then I can filter priceRange
    And  select any product


    @search
    Scenario Outline:
      When I search for "<item>"
      Then I can see desire products

      Examples:
      | item   |



