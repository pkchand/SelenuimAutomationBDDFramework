
Feature: Login Page Feature
  
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then Title should be "Login - Emw.Oem.IdentityServer"

  Scenario: Forgot  password link
    Given user is on login page
    Then Forgot password link should be displaying
    
  Scenario: Login with correct credential
    Given user is on login page
    When user enters username "rpuser1@yopmail.com"
    And user enters password "Password@1"
    And user clicks on login button
    Then user gets the title of the page
    And page title should be "Energy Service"
