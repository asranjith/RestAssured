package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
       @Test
       public void deleteDataFromServer() {
    	   Response res = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_7191");
    	   res.then().statusCode(204);
    	   res.then().log().all();
       }
}
