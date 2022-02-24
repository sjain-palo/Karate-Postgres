Feature: Fetch data from postgres DB and assert the values
  Background:
    Scenario:
      * call read('../query.feature')
      * def rowDetails = query1(id)
      Then print rowDetails
      * def userName = rowDetails[0]["NAME"]
      * match userName contains 'Shubha'