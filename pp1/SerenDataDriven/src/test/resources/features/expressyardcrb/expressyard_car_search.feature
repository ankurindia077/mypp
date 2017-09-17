@component:ExpressYard-UI
@version:Release-1
Feature: Expressyard car search
	As an User of Express Yard Application
	I want to login Express Yard Application with my valid username and password
	So that I can check details for all my Cars
	 
	  
Scenario Outline: Verify Car Search Details for Particular Car
		Given Application is launched in a InternetExplorer browser '<IterationNumber>'
		When User Enter Valid Company Name, User Name and Password
		When User Clicks Go Button
		When User Selects Search Option from My Yard Menu
		When User enters Car Initial and Car Number in Text Box
		When User Click Search Button
		Then User Successfully Find Details of Search Car
		Examples:
    |IterationNumber|
    |1|
    