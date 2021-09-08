Feature: Get employee list

  Background:
    * url baseUrl

  Scenario: Fetch list of employees

    Given path 'employees/1'
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And match $ == read('employees.json')