package graphql;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Project {
    @Test
    public void getAll() {
    	String query="{ getAllProjects{ projectId projectName status } }";
    	given()
    	  .contentType(ContentType.JSON)
    	  .body(query)  
    	.when()
    	  .post("http://49.249.28.218:8091/getAll")
    	.then()
    	  .log().all();
    }
    @Test
    public void getProjectByProjectId() {
    	String query = "{ findProject(projectId:\"NH_PROJ_9400\"){ projectId projectName status createdBy teamSize } }";
    	given()
   	     .body(query)
   	   .when()
	     .post("http://49.249.28.218:8091/getProjectByProjectId")
	  .then()
	     .log().all();
    }
    
    @Test
    public void updateProject_graphql(){
    	String query = "mutation { updateProject( projectId: \"NH_PROJ_9400\" projectName: \"Airtel3797\", teamSize: 1, createdBy: \"Deepak\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
    	given()
   	     .body(query)
   	   .when()
	     .post("http://49.249.28.218:8091/updateProject-graphql")
	  .then()
	     .log().all();
    }
    
     
}
