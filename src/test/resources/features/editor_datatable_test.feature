@smoke 
Feature: As a user, I want to be able to add new employee to Editor webtable 

Scenario: I can add a new employee 
	Given I am on the aditor example page 
	And Verify that headers siz and text. 
	And Find Bruno Nash in the table then verify that he is a Software Engineer and works in London 
	When Print all webtable content in a similar looking format 
	And Add new Employee information 
	Then Verify All data displayed in the webtable matched the data you entered in step 8. 
	
