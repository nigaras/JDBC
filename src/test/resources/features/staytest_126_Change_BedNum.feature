@staytest_126
Feature: As a user I should be able to see the search results should 
update if the user changes the number of beds

Scenario: Verify the search results updates
Given I am on the fourstay homepage 
	And I enter school name "Georgetown university" 
	And I enter dates "03/01/2018" and "03/02/2018" 
	And I click the search button 
	And I update the bed number to "2"
	