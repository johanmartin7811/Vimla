#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Register user at vimla
 
  

  @tag1
  Scenario Outline: Try to register user 
    Given I open register page vimla
    And  I have clicked the cookie button 
    And  I have entered a mail <mail> into the register
    And I enter a username <userName> into the register
    And I enter a password <passWord> into the register
    And I enter the same password again <passWordAgain> into to register
    When I click register
    Then I test if user can register on vimla <vimla> 

    Examples: 
      | mail | userName | passWord | passWordAgain | vimla |
      | "Johanmartin" | "Johan M" | "Torska" | "Torska" | "first" |
      | "Johanmartin" | "Nisse Holgerssonsens" | "Torska" | "Torska" | "secound" |
      | "Johanmartin" | "Johan M" | "Torska" | "Torskas" | "Third" |
      | "johanmartin519803@mailinator.com" | "Johan M" | "Torska" | "Torska" | "fourth" |
     	
  
    
   
     	
     	
