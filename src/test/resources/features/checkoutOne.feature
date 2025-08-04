Feature: Able to navigate to Checkout One

Background: Complete flow to reach Checkout One page
  Given I am on the Login Page
  When I insert "standard_user" and "secret_sauce"
  And I click on the login button
  Then I will go to the InventoryPage
  When I click add to cart button 0
  And I click on the cart icon
  And I click Checkout button
  Then I am on the Checkout One page
  
  Scenario:Verify error message when All Fields are blank 
  When I leaves First Name blank
  And I leaves Last Name blank
  And leaves Zip Code blank
  And I click Continue button
  Then the error message "Error: First Name is required" should be displayed

Scenario:  Verify error message when First Name is blank
  When I leaves First Name blank
  And I enter my last name "Doe"
  And I enter my postal code "12345"
  And I click Continue button
  Then the error message "Error: First Name is required" should be displayed
  
  Scenario: Verify error message when Last Name is blank 
  When I enter my first name "John"
  And I leaves Last Name blank 
  And I enter my postal code "12345"
  And I click Continue button
  Then the error message "Error: Last Name is required" should be displayed
  
  Scenario: Verify error message when Zip Code is blank  
  When I enter my first name "John"
  And I enter my last name "Doe"
  And leaves Zip Code blank
  And I click Continue button
  Then the error message "Error: Postal Code is required" should be displayed

  
  Scenario: Verify user can successfully Fill in details and checkout
  When I enter my first name "John"
  And I enter my last name "Doe"
  And I enter my postal code "12345"
  And I click Continue button
  Then I will go to the Checkout Two page
  
Scenario: Cancel returns to cart
  When I click Cancel button
  Then I will go to the Your Cart page

Scenario: Cart icon returns to cart page
  When I click cart icon
  Then I will go to the Your Cart page
