package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
	
		@Given("Add Place Payload")
		public void add_place_payload() {
		    
		  System.out.println("say something");
		  //throw new io.cucumber.java.PendingException();
		}

		@When("User calls {string} with post http request")
		public void user_calls_with_post_http_request(String string) {
		    
			System.out.println("try something");
			//throw new io.cucumber.java.PendingException();
		}
		@Then("The API got sccuess with status code {int}")
		public void the_api_got_sccuess_with_status_code(Integer int1) {
		    
			System.out.println("do something");
			//throw new io.cucumber.java.PendingException();
		}
		@Then("{string} code in response body is {string}")
		public void code_in_response_body_is(String string, String string2) {
		    
			System.out.println("be something");
			//throw new io.cucumber.java.PendingException();
		}




}
