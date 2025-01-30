package cookie;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BlacklistHeader2ndWay {
	@Test
	public void blackListHeaderWay2() {
		 JSONObject jsonObj = new JSONObject();
    	 jsonObj.put("createdBy", "ASR");
    	 jsonObj.put("projectName", "Microsoft11");
    	 jsonObj.put("status", "Ongoing");
    	 jsonObj.put("teamSize", 0);
    	 Response res=given()
    	   // .config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type"))).log().all()	 
    	    .contentType(ContentType.JSON)
    	    .body(jsonObj.toString())
    	    .cookie("userName","abcd")
    	    .log().all()
    	 .when()
    	    .config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("createdBy")))
    	    .post("http://49.249.28.218:8091/addProject");   
    	 res.then()
    	    .assertThat().statusCode(201)
    	    .log().all();
	}

}
