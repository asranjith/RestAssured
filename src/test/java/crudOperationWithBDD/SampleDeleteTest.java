package crudOperationWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class SampleDeleteTest {
     @Test
     public void deleteDataFromServer() {
    	 when()
    	   .delete("http://49.249.28.218:8091/project/NH_PROJ_9850")
    	 .then()
    	   .assertThat().statusCode(204)
    	   .time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
    	   .contentType(ContentType.JSON)
    	   .log().all();
     }
}
