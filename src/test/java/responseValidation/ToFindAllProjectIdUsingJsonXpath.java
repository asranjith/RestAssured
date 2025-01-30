package responseValidation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class ToFindAllProjectIdUsingJsonXpath {
     @Test
     public void json_Xpath() {
    	 Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
     	resp.then().log().all();
     	resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_9972"));
     	
     	//it will give all project id in an array and this jsonPath method is present in Response Interface
     	ArrayList<String> list = resp.jsonPath().get("content.projectId");
     	System.out.println(list);
     	
     	//we can not use regex * in json path it will throw IllegalArgumentException
     	//if we want to use regex or condition in jsonpath add json-path dependency
     	
     	ArrayList<String> list1 = resp.jsonPath().get("content[*].projectId");
     	System.out.println(list1);
     }
}
