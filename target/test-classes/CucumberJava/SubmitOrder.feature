
@tag
Feature: Purchase the Order from the ECommerce Website
  I want to use this template for my feature file

 Background:
Given I Landed on ECommerce Website
  

  @Regression
  Scenario Outline: Positive test of Submitting the Order
    Given Logged in to the Ecommerce Website with <uname> and <password>
    When I added the <productname> to the cart 
    And  Checkout <productname> and submit the order 
    Then Verify "THANKYOU FOR THE ORDER." message on the Confirmation Page

    Examples: 
      | uname  								|			password		| productname  	|
      | Yuvaanyuvi@gmail.com 	|     Yuvaan2018 	| IPHONE 13 PRO |
      | Sai009@gmail.com 			|     Sai009014 	| ZARA COAT 3   |
