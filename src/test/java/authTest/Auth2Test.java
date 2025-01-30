package authTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Auth2Test {
    @Test
    public void auth2() {
    	Response resp = given()
    	   .formParam("client_id", "ninza-client")
    	   .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
    	   .formParam("grant_type", "client_credentials")
    	.when()
    	   .post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
    	resp.then()
    	   .log().all(); 
    	String token = resp.jsonPath().get("access_token");
    	
    	   given()
    	      .auth().oauth2(token)
    	      .log().all()
    	   .when()
    	      .get("http://49.249.28.218:8091/projects")
    	   .then()
    	      .log().all(); 
    	     
    }
}
