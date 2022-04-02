package stepDefinitions;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.SerializePojoClass;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class StepDefinition extends Utils{
	
	TestDataBuild testdata=new TestDataBuild();
	
	static String place_id;
	 RequestSpecification res;
	 Response response;
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
			  
				  
				  res=given().spec(requestSpecification())
				 .body(testdata.AddPlacePayload(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("Post"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("Get"))
			response =res.when().get(resourceAPI.getResource());		
	}

	@Then("the API call get success with status code {int}")
	public void the_api_call_get_success_with_status_code(Integer int1) {
		
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
			
		assertEquals(getJsonPath(response,keyValue),expectedValue);
	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 place_id=getJsonPath(response,"place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");
		String actualname=getJsonPath(response,"name");
		assertEquals(actualname,expectedname);
	    
	}
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		
		res=given().spec(requestSpecification())
		.body(testdata.deletePayload(place_id));
	}


}
