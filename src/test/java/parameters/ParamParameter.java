package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ParamParameter {
     @Test
     public void actLikeForm() {
    	given()
      	  .contentType(ContentType.JSON)
      	  .param("projectId", "NH_PROJ_9475")
      	  .log().all()
        .when()
    	   .post("http://49.249.28.218:8091/project")
    	   .then()
    	   .log().all();
     }
     
     @Test
     public void actLikeQuery() {
    	 given()
  	         .contentType(ContentType.JSON)
  	         .param("projectId", "NH_PROJ_9475")
  	         .log().all()
         .when()
	         .get("http://49.249.28.218:8091/project")
	         .then()
	         .log().all();
     }
     
}
