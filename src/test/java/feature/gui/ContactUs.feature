Feature: Contact Us

  @GUI
  Scenario Outline: Fill Contact Us Form
    Given User Clicks on Contact Us Link
    And User is on Contact Us Page
    When Enters Personal Details like "<Title>" "<FirstName>" and "<LastName>"
    And Enters Contact Details like "<Address>" "<City>" "<State>" "<ZipCode>" "<Telephone>" and "<Email>"
    And When Enters "<Comment>"
    And Clicks on Submit button
    Then User Navigates back to HomePage

    Examples:
      | Title | FirstName | LastName | Address   | City      | State         | ZipCode | Telephone    | Email                | Comment         |
      | Mr.   | John      | Smith    | Hoofddorp | Hoofddorp | North Holland | 1234    | 061234567890 | john.smith@gmail.com | Test Automation |
