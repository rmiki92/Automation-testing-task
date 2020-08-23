@testFE2
Feature: Test filter and watchlist

  Scenario: Set filters and add to watchlist scenario
    Given open "https://coinmarketcap.com/"
    When click on button filters and select for price range from "2000" to 99999
    Then select 5 cryptocurrencies by clicking on the ellipsis and select "Add to Watchlist" option
    Then click on the Watchlist tab
