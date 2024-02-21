
@tag
Feature: Error Validation
  I want to use this template for my feature file

  

  @Error
  Scenario Outline: Error Validation Negative Test
    Given I Landed on ECommerce Website
    And  Logged in to the Ecommerce Website with <uname> and <password>
    Then "Incorrect email or password." message is displayed.
   
    

Examples: 
      | uname  								|			password		| 
      | Yuvaanyuvi@gmail.com 	|     Yuvaan201 	|
     

