package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SamplePostTest {
     @Test
     public void postDataToServer() {
    	 JSONObject jsonObj = new JSONObject();
    	 jsonObj.put("createdBy", "ASR");
    	 jsonObj.put("projectName", "Microsoft");
    	 jsonObj.put("status", "Ongoing");
    	 jsonObj.put("teamSize", 0);
    	 given()
    	    .contentType(ContentType.JSON)
    	    .body(jsonObj.toString())
    	 .when()
    	    .post("http://49.249.28.218:8091/addProject")
    	 .then()
    	    .assertThat().statusCode(201)
    	    .log().all();
    	    
    	 
     }
}
