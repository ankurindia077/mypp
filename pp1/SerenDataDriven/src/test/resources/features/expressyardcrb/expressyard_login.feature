@component:ExpressYard-UI
@version:Release-1
Feature: Expressyard login
	As an User of Express Yard Application
	I want to login Express Yard Application with my valid username and password
	So that I can check details for all my Cars
	  
@expressyardlogin	  
Scenario Outline: Verify Successful ExpressYard Application Login with valid user
		Given Application is launched in a InternetExplorer browser '<IterationNumber>'
		When User Enter Valid Company Name, User Name and Password
		Then User Login Successfully
		Examples:
    |IterationNumber|
    |1|
