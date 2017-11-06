@staytest_37 
Feature: As a user I should be able to search stay for the a specified date range 
	So that the result lists only stays that are available of those days

Scenario: search stay for the a specified date range 
	Given I am on the fourstay homepage 
	And I enter school name "Georgetown university" 
	And I enter dates "03/01/2018" and "03/02/2018" 
	And I click the search button 
	Then the results should contain expected date "03/01/2018" 
	
	#User specifies location, day in, day out and number of beds while searching for the stay. 
	#The result page gives a list of stays based on search criteria. 
	#Only those stays that meet all searching criteria should be listed on result page
