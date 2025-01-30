package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParameter {
    @Test
    public void searchResources() {
    	given()
    	   .contentType(ContentType.JSON)
    	   .pathParam("projectId", "NH_PROJ_9475")
        .when()
  	       .get("http://49.249.28.218:8091/project/{projectId}")
  	    .then()
  	       .log().all();
    }
}
