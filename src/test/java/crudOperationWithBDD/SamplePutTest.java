package crudOperationWithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class SamplePutTest {
    @Test
    public void putDataInSerever() {
    	JSONObject jsonObj = new JSONObject();
    	 jsonObj.put("createdBy", "ASR");
    	 jsonObj.put("projectName", "Microsoft1");
    	 jsonObj.put("status", "OnGoing");
    	 jsonObj.put("teamSize", 0);
    	 given()
    	    .contentType(ContentType.JSON)
    	    .body(jsonObj)
    	 .when()
    	    .put("http://49.249.28.218:8091/project/NH_PROJ_9850")
    	 .then()
    	    .assertThat().statusCode(200)
    	    .time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
    	    .contentType(ContentType.JSON)
    	    .log().all();
    	 System.out.println(jsonObj);
    	 System.out.println(jsonObj.toJSONString());
    }
}
