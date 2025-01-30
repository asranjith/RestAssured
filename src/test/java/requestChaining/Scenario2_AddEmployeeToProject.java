package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.Employee;
import pojoClassUtility.Project;

public class Scenario2_AddEmployeeToProject {
     @Test
     public void addEmployee() {
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
   	     String projectName = resp.jsonPath().get("projectName");
	    System.out.println(projectName);
	    
   	    //add Employee
   	    Employee employee = new Employee("TestEngineer", "27/08/1998", "ranjith27@gmail.com", "user"+ranNum, 4, "9791622487", projectName, "ROLE_EMPLOYEE", "user"+ranNum);
   	 Response resp2= given()
     	       .contentType(ContentType.JSON)
     	       .body(employee)
     	    .when()
     	       .post("http://49.249.28.218:8091/employees");
     	  resp2.then()
     	        .assertThat().statusCode(201)
     	        .log().all();
     }
}
