Feature: Get User List

  @API
  Scenario: Get User List
    Given Prepare fetch user list
      | page | 2 |
    When Send http get request
    Then Check status code "200"