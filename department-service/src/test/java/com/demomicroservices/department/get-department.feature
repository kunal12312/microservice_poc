Feature: Get department list

  Background:
    * url baseUrl

  Scenario: Fetch list of department
    Given path 'authenticate'
    And request { userName: 'Subhadip', password: 'Ayush12' }
    When method POST
    Then status 200
    * print response
 

    Given path 'departments/department/1'
    And header Authorization = 'Bearer ' + response.jwtToken
    When method GET
    Then status 200
    And match $ == read('department.json')