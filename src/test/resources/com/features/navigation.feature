Feature: Verify navigation menu

Background: 
Given user has already logged in to the application
|Username|Password|
|admin@emotorwerks.com|!eMW12345|

Scenario: Project page title
Given user is on project page
When user gets the title of the home page
Then the page title should be "Energy Services"

Scenario: Navigation menu count
Given user is on project page
Then user gets the navigation section
|Projects|
|Utility data reporting|
|Reports|
|Dictionaries|
|My Vehicles|
|Administration|
|Reward Programs|

And Navigation count should be 7

