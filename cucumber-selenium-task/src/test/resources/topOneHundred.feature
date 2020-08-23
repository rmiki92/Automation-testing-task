@testFE1
Feature: Test amount of cryptocurrencies

  Scenario: Verification of Top100 Cryptocurrencies
    Given open the Firefox and search "https://coinmarketcap.com/"
    When from Cryptocurrencies dropdown choose option "Top 100"
    Then verify that amount of results is 100
