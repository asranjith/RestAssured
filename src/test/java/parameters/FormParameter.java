package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class FormParameter {
    @Test
    public void filterResource() {
    	given()
    	  .contentType(ContentType.JSON)
    	  .formParam("projectId", "NH_PROJ_9475")
    	  .log().all()
       .when()
  	      .post("http://49.249.28.218:8091/project")
  	   .then()
  	    .log().all();
    }
}
