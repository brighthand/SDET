Feature: Validating Place API's

Scenario: Verify if place is being successfully added using AddPlaceAPI
Given Add Place Payload
When User calls "AddPlaceAPI" with post http request
Then The API got sccuess with status code 200
And "Status" code in response body is "OK"
And "scope" code in response body is "APP"
	
	