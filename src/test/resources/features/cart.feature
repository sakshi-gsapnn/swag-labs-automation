Feature: Able to verify cart functionality

Background: Setup the cart page with items
  Given I am on the Login Page
  When I insert "standard_user" and "secret_sauce"
  And I click on the login button
  Then I will go to the InventoryPage
  When I click add to cart button 0
  And I click on the cart icon
  Then I am on the cart page

Scenario: Navigate to inventory item via product title
  When I click on the title of the product at index 0
  Then I will go to the inventory item page of that product

Scenario: Continue shopping returns to inventory
  When I click Continue Shopping button
  Then I will go back to the Inventory page

Scenario: Checkout from cart
  When I click Checkout button
  Then I will go to the checkout step one page

Scenario: Remove item from cart
  Given there is at least one item in the cart
  When I click the remove button for item at index 0
  Then the item will be removed from the cart

Scenario: View item price in cart
  Given there is at least one item in the cart
  Then I can see the price of the product at index 0
