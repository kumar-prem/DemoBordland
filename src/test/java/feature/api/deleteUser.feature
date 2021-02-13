Feature: delete user

  @API
  Scenario: Register user successful
    Given Prepare register user request
      | email    | eve.holt@reqres.in |
      | password | pistol             |
    When Send http post request
    Then Check status code "200"
    Given Prepare delete user request
    When Send http delete request
    Then Check status code "204"