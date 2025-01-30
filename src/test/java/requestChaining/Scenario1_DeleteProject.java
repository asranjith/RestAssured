package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.Project;

public class Scenario1_DeleteProject  {
      @Test
      public void addProject_deleteProject() {
    	  //add project
    	  Random random = new Random();
    	  int ranNum = random.nextInt(5000);
    	  Project pobj = new Project("Test_"+ranNum,"ASR",10,"Created");
    	  Response resp= given()
    	       .contentType(ContentType.JSON)
    	       .body(pobj)
    	    .when()
    	       .post("http://49.249.28.218:8091/addProject");
    	  resp.then()
    	        .assertThat().statusCode(201)
    	        .log().all();
    	  //Capture project name from the response
    	  String projectID = resp.jsonPath().get("projectId");
    	  System.out.println(projectID);
    	   
    	  //delete Project
    	     given()
    	        .delete("http://49.249.28.218:8091/project/"+projectID)
    	     .then()
    	         .log().all();
      }
}
