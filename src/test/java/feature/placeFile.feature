Feature: Validating Place API's

@version1
Scenario: Verify if place is being successfully added using AddPlaceAPI
Given Add Place Payload
When User calls "AddPlaceAPI" with post http request
Then The API got sccuess with status code 200
And "Status" code in response body is "OK"
And "scope" code in response body is "APP"

@version2	
Scenario: Add Place using more developed framework
Given Add Place
When Request is sent
Then The response is verified

@3rd
Scenario: Retreive employee data
Given Retrieve Employee
When User calls employee api with get request
Then the information is verified