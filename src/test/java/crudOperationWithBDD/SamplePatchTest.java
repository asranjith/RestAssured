package crudOperationWithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class SamplePatchTest {
       @Test
       public void patchDataToServer() {
    	   JSONObject jsonObj = new JSONObject();
      	 jsonObj.put("projectName", "Microsoft123");
      	 given()
      	    .contentType(ContentType.JSON)
      	    .body(jsonObj)
      	  .when()
      	     .patch("http://49.249.28.218:8091/project/NH_PROJ_9850")
      	   .then()
      	      .assertThat().statusCode(200)
      	      .time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
      	      .contentType(ContentType.JSON)
      	      .log().all();
      	    
      	    
      	 
       }
}
