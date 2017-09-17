@component:ExpressYard-UI
@version:Release-1
Feature: Serenity bdd search 1
  In order I can get answer to my question
  As a user
  I should be able to search in google
      
  Scenario: Google should display appropriate search results page when I enter a Search Term
  	Given user is on home Google Search Page '1'
    When the user enters SearchText  
    Then the result should contains SearchResult
    
  Scenario Outline: Google should display appropriate search results page when I enter a Search Term 1
    Given user is on home Google Search Page '<IterationNumber>'
    When the user enters SearchText  
    Then the result should contains SearchResult 
  Examples:
    |IterationNumber|
    |1|
    |2|
    |3|
    
  