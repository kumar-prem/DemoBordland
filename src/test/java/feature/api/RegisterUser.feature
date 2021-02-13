Feature: Register User

  @API
  Scenario: Register user successful
    Given Prepare register user request
      | email    | eve.holt@reqres.in |
      | password | pistol             |
    When Send http post request
    Then Check status code "200"

  @API
  Scenario: Register user unsuccessful
    Given Prepare register user request
      | email | eve.holt@reqres |
    When Send http post request
    Then Check status code "400"

