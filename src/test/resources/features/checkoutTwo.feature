Feature: Able to navigate to Checkout Two page

Background: Complete flow to reach Checkout Two page
  Given I am on the Login Page
  When I insert "standard_user" and "secret_sauce"
  And I click on the login button
  Then I will go to the InventoryPage
  When I click add to cart button 0
  And I click on the cart icon
  And I click Checkout button
  When I enter my first name "John"
  And I enter my last name "Doe"
  And I enter my postal code "12345"
  And I click Continue button
  Then I am on the Checkout Two page

Scenario: Getting to the Checkout Complete page from the Checkout Two page
  When I click Finish button
  Then I will go to the checkout complete page

Scenario: Getting to the Inventory page via cancel button from the Checkout Two page
  When I click Cancel button
  Then I will go to the Inventory Page

Scenario: Getting to the Your Cart page via cart icon from the Checkout Two page
  When I click cart icon
  Then I will go to the Your Cart page

  Scenario: Getting to the Inventory page  from the Checkout Two page
  When I click menu button
  And  I click Allpages
  Then I will go back to the Inventory page
  
  Scenario: Getting to the Main Website from the Checkout Two page
  When I click menu button
  And  I click About
  Then I will go to sauce main website
  
  Scenario: verify that it is getting to login page when we select logout button  
  When I click menu button
  And I click Logout
  Then I will go to login page
  
  Scenario: Verify cart is empty after i click on Reset App State
  When I click menu button  
  And  I click on Reset App State on CheckoutTwo Page
  When I click cart icon
  Then the cart will be empty
  
 
  
  
  