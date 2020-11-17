package stepDefinitions;

import org.junit.BeforeClass;

//import static org.junit.Assert.assertThat;

import org.testng.annotations.BeforeTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import resources.Payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class steps {
	//the base uri, spec builders and response objects are declared here for BDD
	
		@Given("Add Place Payload")
		public void add_place_payload() {
		    
			//ADD PLACE
		  System.out.println("To add place");
		  RestAssured.baseURI = "https://rahulshettyacademy.com";
		  
		  
		  String response = given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		  .body(Payload.AddPlace())  //string payload parsed from resource
		  .when().post("maps/api/place/add/json")
		  .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		  		 .header("server", "Apache/2.4.18 (Ubuntu)") //all methods, chained in then(), after assertThat, are validations
		  		 .extract().response().asString(); //extract everything into a string, for use with jsonPath objects.
		  
		  		 //TODO: after add place -> Update with new address -> get Place to validate if new address is present in response
		  
		  //parsing string response into jsonPath
		  JsonPath js = new JsonPath(response);
		  String placeId = js.getString("place_id"); //retrieves value at the path specified (no parents in this example)
		  												//this block can be offloaded to a seperate Class (lesson 23), and called as needed; left alone for clarity, here.
		  
		  System.out.println("place Id = " + placeId);
		  
		  //UPDATE PLACE
		  String newAddress = "Summer walk, Africa";
		  
		  given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json") //note: placeId from above inserted into json below
		  .body("{\r\n" + 
				  "\"place_id\":\""+ placeId +"\",\r\n" +  
				  "\"address\":\""+ newAddress +"\",\r\n" +
				  "\"key\":\"qaclick123\"\r\n" +
				  "}")
		  .when().put("maps/api/place/update/json")
		  .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));  //alternative to direct reading is through response + jsonPath (seen above)
		  
		  
		  //GET PLACE
		  String response2 = given().log().all()  //no .header() or .body() when using GET request
		  		 .queryParam("place_id", placeId)  //queryParam is used differently this time: for finding a result, rather than providing login credentials
  		  .when().get("maps/api/place/update/json")
  		  .then().assertThat().log().all().statusCode(200).extract().response().asString(); //we've elected to use indirect method of reading the response this time
		  
		  JsonPath js2 = new JsonPath(response2);
		  String actualAddress = js2.getString("address"); //no parents in the path provided here either
		  
		  //Since we are out of RestAssured's given()when()then() chain, we rely on either Junit or Testng for the assertions
		  
		  Assert.assertEquals(newAddress, actualAddress);
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
