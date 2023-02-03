@tag
Feature: Purchase the order from Ecommerce Website

 
 Background:
 Given I landed on Ecommerce Page
   
 @Regression
 Scenario Outline: Positive test of submitting the order
 Given user login to URL with username <name> and password <password>
 When user adds to the cart one item <productName> from the product page
 And checkout <productName> and submit the order
 Then "THANKYOU FOR THE ORDER." message is displayed in the confirmation page

    Examples: 
      | name  											| password 			| productName    |
      | andresautomation@gmail.com  | Bucaramanga_1	| ZARA COAT 3    |
