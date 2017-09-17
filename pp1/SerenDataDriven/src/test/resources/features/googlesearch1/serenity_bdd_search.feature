@component:ExpressYard-UI
@version:Release-1
Feature: Serenity bdd search
  In order I can get answer to my question
  As a user
  I should be able to search in google
   
 # This is single line comment
 # Example Usage for using Background. 
 # Background Helps in executing some set of Given, When, Then 
 # statements before every scenario or scenario outline mentioned
 # in same feature file.
 
 #But: It signifies logical OR condition between any two statements, Can be use with Given, When, Then
 
 # And: It provides the logical AND condition between any two statements, Can be use with Given, When, Then
 

 Background:
     Given user is on home Google Search Page '3'
     When the user enters SearchText 
    
    @regression
    Scenario: @@@@@ Google should display appropriate search results page when I enter a Search Term @@@@
    Then the result should contains SearchResult 
    But Relogin option should be available
    
		@sanity
    Scenario: @@@@@ Second  Google should display appropriate search results page when I enter a Search Term @@@@
    When the user enters SearchText
    And Relogin option should be available
    Then the result should contains SearchResult    
  
  	@iterator
    Scenario Outline: @@@@@ Third Google should display appropriate search results page when I enter a Search Term 1
    Given user is on home Google Search Page '<IterationNumber>'
    When the user enters SearchText  
    Then the result should contains SearchResult 
  Examples:
    |IterationNumber|
    |1|
    |2|
    |3|