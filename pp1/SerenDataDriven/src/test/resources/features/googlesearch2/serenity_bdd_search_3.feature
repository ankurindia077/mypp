@component:ExpressYard-UI
@version:Release-1
Feature: Serenity bdd search 3
  In order I can get answer to my question
  As a user
  I should be able to search in google
      
    Scenario: Google should display appropriate search results page when I enter a Search Term 
    Given user is on home Google Search Page '1'
    When the user enters SearchText 
    Then the result should contains SearchResult 