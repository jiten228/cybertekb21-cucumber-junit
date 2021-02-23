Feature: Etsy search feature


  Scenario: Etsy default title verification
    Given user is on the etsy landing page
    Then user should see Etsy title as expected
    #expected : Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @etsy
  Scenario: Etsy search title verification
    Given user is on the etsy landing page
    When user searches for "wooden spoon"
    Then user should see "Wooden spoon" in the Etsy title