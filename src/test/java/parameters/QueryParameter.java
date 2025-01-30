package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class QueryParameter {
     @Test
     public void searchAndFilterResource() {
    	 given()
    	   .contentType(ContentType.JSON)
    	   .queryParam("projectId", "NH_PROJ_9475")
    	   .log().all()
    .when()
  	   .get("http://49.249.28.218:8091/project")
  	.then()
  	    .log().all();
     }
}
