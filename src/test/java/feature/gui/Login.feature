Feature: login feature

  @GUI
  Scenario Outline: Login with Valid Credentials
    Given User Enters "<Email>" and "<Password>"
    When Clicks on LogIn button
    Then User Sees logout button on details page

    Examples:
      | Email                | Password |
      | john.smith@gmail.com | john     |

  @GUI
  Scenario Outline: Login with Invalid Credentials
    Given User Enters "<Email>" and "<Password>"
    When Clicks on LogIn button
    Then User Sees Error Message

    Examples:
      | Email                | Password |
      | john.smith@gmail.com | johnny   |