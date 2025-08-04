Feature: Able to verify personal details and navigate to different pages on the website

Background: Complete full checkout flow to reach Checkout Complete page
  Given I am on the Login Page
  When I insert "standard_user" and "secret_sauce"
  And I click on the login button
  Then I will go to the InventoryPage
  When I click add to cart button 0
  And I click on the cart icon
  And I click Checkout button
  When I enter my first name "Test"
  And I enter my last name "User"
  And I enter my postal code "12345"
  And I click Continue button
  When I click Finish button
  Then I am on the Checkout Complete page

Scenario: Back home button returns to inventory
  When I click back home button
  Then I will go to the Inventory Page

Scenario: Cart icon returns to Your Cart page
  When I click cart icon
  Then I will go to the Your Cart page

Scenario: Verify cart is empty after successful checkout
  When I click cart icon
  Then the cart will be empty
