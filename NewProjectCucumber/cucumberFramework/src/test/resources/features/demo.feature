# Author: shuvendupand22@gmail.com
Feature: Registrations in mercuryFlight site
Background:
Given I've a valid set of data and access
# dataTable for userDetails
@Registrations
Scenario: Single user Registrations process
When  Registration page display
Then  enter valid Data
Then  click on submit
Then  click signoff
And   close
            
              
