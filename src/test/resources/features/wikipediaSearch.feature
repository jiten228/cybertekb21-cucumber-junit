Feature: Wikipedia search feature
  As a user, I should be able to search terms and see related results

  @wiki
  Scenario: Wikipedia search title verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then User sees "Steve Jobs" in the wiki title

  Scenario: Wikipedia search header verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then User sees "Steve Jobs" in the main header

   Scenario Outline: Wikipedia search header verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And user clicks wiki search button
    Then User sees "<expectedMainHeader>" in the main header
    Then User sees "<expectedTitle>" in the wiki title

    Examples: search terms we are going to search in wikipedia
      | searchValue | expectedMainHeader | expectedTitle |
      | Steve Jobs  | Steve Jobs         | Steve Jobs    |
      | Marie Curie | Marie Curie        | Marie Curie   |
      | Kobe Bryant | Kobe Bryant        | Kobe Bryant   |
      | Bill Gates  | Bill Gates         | Bill Gates    |