
  Feature: Test the various functionalities of Volkswagen Finanacial Services

    @Sanity @TestCase1
    Scenario Outline: Find the vehicle information using valid registration number
      Given I launch the VolksWagen Financial Services home page
      And I enter "<Registration Number>" into the search box
      And I click on the Find Vehicle button
      Then I can verify the corresponding search vehicle details for "<Registration Number>"

    Examples:
      | Registration Number |
      | OV12UYY             |


    @Sanity @TestCase2
    Scenario Outline: Find the vehicle information using invalid registration number
      Given I launch the VolksWagen Financial Services home page
      And I enter "<Registration Number>" into the search box
      And I click on the Find Vehicle button
      Then I can see a valid "<Error Message>"

      Examples:
        | Registration Number | Error Message           |
        | InvalidRegNumber    | Sorry record not found  |


    @Sanity @TestCase3
    Scenario Outline: Do not enter any registration number and check the error message
      Given I launch the VolksWagen Financial Services home page
      And I do not enter anything into the search box
      And I click on the Find Vehicle button
      Then I can see a valid message "<Error Message>"

      Examples:
        | Error Message                           |
        | Please enter a valid car registration   |