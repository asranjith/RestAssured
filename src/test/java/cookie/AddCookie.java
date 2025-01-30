package cookie;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class AddCookie {
	@Test
	public void exampleForCookie() {
		 JSONObject jsonObj = new JSONObject();
    	 jsonObj.put("createdBy", "ASR");
    	 jsonObj.put("projectName", "Microsoft8");
    	 jsonObj.put("status", "Ongoing");
    	 jsonObj.put("teamSize", 0);
    	 Response res=given()
    		.config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Content-Type"))).log().all()	 
    	    .contentType(ContentType.JSON)
    	    .body(jsonObj.toString())
    	    .cookie("userName","abcd")
    	    .log().all()
    	 .when()
    	    .post("http://49.249.28.218:8091/addProject");
    	 res.then()
    	    .assertThat().statusCode(409)
    	    .log().ifError().statusCode(409).extract().response();
    	   // .log().all();
    	    
		  
	}
    
}
