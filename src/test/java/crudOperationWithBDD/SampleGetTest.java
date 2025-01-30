package crudOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleGetTest {
    @Test
    public void getTest() {
    	 when()
    	   .get("http://49.249.28.218:8091/projects")
    	.then()
    	    .log().all();
    }
}
