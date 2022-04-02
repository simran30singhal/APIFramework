package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException  {
		
	
		StepDefinition sp=new StepDefinition();
		
		if(sp.place_id==null) {
		
		sp.add_place_payload("Simran", "English", "Asia");
		sp.user_calls_with_http_request("AddPlaceAPI", "POST");
		sp.verify_place_id_created_maps_to_using("Simran", "GetPlaceAPI");
	}
		}
	
}
