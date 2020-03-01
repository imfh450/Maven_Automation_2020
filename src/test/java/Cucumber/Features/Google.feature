  Feature:  Google Test Scenarios
  Scenario Outline: TC1 get google search result  number
    Given I navigated to Google home page
    When I verify the expected title as Google
    When I type cars <Cars> in google search field
    And I submit or click on google search
    Then I capture and extract the search numbers
    Examples:
      |Cars  |
      |BMW   |
      |Mercades|
      |Lexus   |


    Scenario:TC2 Login with invalid credentials

