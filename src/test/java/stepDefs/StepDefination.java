package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateUserReq;
import pojo.CreateUserRes;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class StepDefination extends Utils{
	
	public RequestSpecification reqSpec;
	public Response res;
	public CreateUserRes createUserResObj;
	public JsonPath js;
	public TestDataBuild testDataBuildObj=new TestDataBuild();
	
	@Given("^createUser payload is there \"([^\"]*)\" \"([^\"]*)\"$")
	public void createuser_payload_is_there(String name, String job) throws Throwable {
	  /* reqSpec= given().spec(requestSpecification()).log().all()
			   .body(testDataBuildObj.createUserPayLoad()).expect().defaultParser(Parser.JSON).request();
	   */
	   reqSpec= given().spec(requestSpecification()).log().all()
			   .body(testDataBuildObj.createUserPayLoad(name,job));
	}

	@When("^user hits \"(.*?)\" API with post http method$")
	public void user_hits_API_with_post_http_method(String apiName) throws Throwable {
	   res=reqSpec.post("/api/users");
	  // createUserResObj=(CreateUserRes)res;
	}

	@Then("^response is success with response code \"(.*?)\"$")
	public void response_is_success_with_response_code(String responseCode) throws Throwable {
		int statusCode=res.getStatusCode();
	   if(String.valueOf(statusCode).equals(responseCode)) {
		   System.out.println("------------Response code is successfully validated as "+responseCode);
	   }
	}

	@Then("^validate that the \"(.*?)\" in response body is \"(.*?)\"$")
	public void validate_that_the_in_response_body_is(String keyInResBody, String valueInResBody) throws Throwable {
	   System.out.println("-----------Response body tobe validated");
	   String responseString = res.asString();
	   js=new JsonPath(responseString);
	   assertEquals(valueInResBody,js.get(keyInResBody));
	   
	   
	}


	
}