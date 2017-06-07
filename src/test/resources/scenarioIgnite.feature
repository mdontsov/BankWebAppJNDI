Feature: Client performs various operations inside webapp

  Scenario: Client can login to system using username and password
    Given webpage is opened
    Then client inputs Maria username
    And client inputs Maria password
    When client presses Login button
    Then client is logged in

  Scenario: Client is forced to change the password at first login
    Given webpage is opened
    Then client inputs Tom username
    And client inputs Tom password
    When client presses Login button
    But system displays message about password change
    And client changes password

  Scenario: Client gains access to summary of account balances
    Given webpage is opened
    Then client inputs Jake username
    And client inputs Jake password
    When client is logged in
    Then summary of account balances is displayed