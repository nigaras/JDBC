@staytest_124 
Feature: Displaying user information 

# Background will apply to every scenarios in this feature file
Background:
	Given I am on the fourstay login dialog

Scenario: Verify host user information 
	And I enter email "testscooper@test.mail.com" 
	And I enter password "password" 
	When I click on the login button 
	Then the user name should be "Sheldon Cooper" 
	
Scenario: Verify host user information 
	And I enter email "testafowler@test.mail.com" 
	And I enter password "password" 
	When I click on the login button 
	Then the user name should be "Amy Fowler" 
	
	
	
Scenario Outline: Verify host user information 
	And I enter email "<email>" 
	And I enter password "<password>" 
	When I click on the login button 
	Then the user name should be "<name>" 
Examples:
|		name		|		email			 	|	password		|	
|Sheldon Cooper | testscooper@test.mail.com	| 	password    |   
|Amy Fowler		| testafowler@test.mail.com	|   password		| 
|Orlando	 Wolf	| OrlandoWolf@test.mail.com	|  Orlandob74cf |
|Lenora Ferry	| LenoraFerry@test.mail.com	|  Lenoradb1d1  |