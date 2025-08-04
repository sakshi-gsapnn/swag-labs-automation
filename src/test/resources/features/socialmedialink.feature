Feature: All social link from inventory

Background: Setup inventory page
Given I am on the Login Page
When I insert "standard_user" and "secret_sauce"
And I click on the login button
Then I will go to the InventoryPage
Given I am on the INVENTORY page

Scenario: Facebook link
When I click on FACEBOOK icon
Then I will go to the FACEBOOK page

Scenario: LinkedIn link
  When I click on LINKEDIN icon
  Then I will go to the LINKEDIN page
  
Scenario: Twitter link
  When I click on TWITTER icon
  Then I will go to the TWITTER page
