Feature: Auto Quote

  @GUI
  Scenario Outline: Apply for Auto Quote Service
    Given User Selects Auto Quote Service from Service List
    When Enters "<ZipCode>" and "<AutoQuoteEmail>"
    And Selects "<AutomobileType>"
    And Clicks on Next button
    Then Instant Auto Quote Form is Open
    And User Enters "<Age>" "<Gender>" and "<DrivingRecord>"
    Then Clicks on Next button
    And User Enters "<Year>" "<Make>" "<Model>" and "<FinancialInfo>"
    Then Clicks on Next button
    Then Gets Automobile Instant Quote

    Examples:
      | ZipCode | AutoQuoteEmail       | AutomobileType | Age | Gender | DrivingRecord | Year | Make   | Model  | FinancialInfo |
      | 1234AB  | john.smith@gmail.com | Car            |  25 | Male   | Excellent     | 2021 | Toyota | Celica | Own           |
