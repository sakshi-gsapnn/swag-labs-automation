Feature: SauceDemo Login Functionality
 
Background:
  Given I am on the Login Page

Scenario Outline: Successful login with valid credentials
  When I insert "<username>" and "secret_sauce"
  And I click on the login button
  Then I will go to the InventoryPage
 
  Examples:
    | username                |
    | standard_user           |
    | problem_user            |
    | performance_glitch_user |
    | error_user              |
    | visual_user             |
 

Scenario: Login fails with invalid username
  When I insert "wrong_user" and "secret_sauce"
  And I click on the login button
  Then I will stay in the Login Page
 

Scenario: Login fails with invalid password
  When I insert "standard_user" and "wrong_password"
  And I click on the login button
  Then I will stay in the Login Page
 

Scenario: Login fails with locked out user
  When I insert "locked_out_user" and "secret_sauce"
  And I click on the login button
  Then I will stay in the Login Page
 
 