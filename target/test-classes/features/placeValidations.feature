Feature: Validate Place API's

@AddPlace
Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call get success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"	
And verify place_id created maps to "<name>" using "GetPlaceAPI"

Examples:
|name   |language |address           |
|AaHouse|English  |World Center three|
#|BBHouse|Spanish  |Sea Cross Center  |

@DeletePlace
Scenario: Verify if Delete Pleace functionality is working
Given DeletePlace Payload
When user calls "DeletePlaceAPI" with "POST" http request
Then the API call get success with status code 200
And "status" in response body is "OK"