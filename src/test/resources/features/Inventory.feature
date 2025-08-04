Feature: InventoryPage
  All features in inventory page

  Background: Setup inventory page with login
    Given I am on the Login Page
    When I insert "standard_user" and "secret_sauce"
    And I click on the login button
    Then I will go to the InventoryPage
    Given I am on the INVENTORY page

  @Inventory @InventorySorting
  Scenario: Sorting name A to Z by dropdown list
    When I select sort name A to Z from the dropdown list
    Then All item sort in ascending order with its name

  @Inventory @InventorySorting
  Scenario: Sorting name Z to A by dropdown list
    When I select sort name Z to A from the dropdown list
    Then All item sort in descending order with its name

  @Inventory @InventorySorting
  Scenario: Sorting price low to high by dropdown list
    When I select sort price low to high from the dropdown list
    Then All item sort in ascending order with its price

  @Inventory @InventorySorting
  Scenario: Sorting price high to low by dropdown list
    When I select sort price high to low from the dropdown list
    Then All item sort in descending order with its price

  @Inventory @InventoryAddToCart
  Scenario: Add all products to the cart and the top right corner shows product amount
    When I click all products add to cart button
    Then The cart icon shows all product amount
    
    
    
    
