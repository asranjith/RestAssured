package postImage_APITesting;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PostImageTest {
    @Test
    public void uploadImageTest() {
    	File file = new File("C:\\Users\\Admin\\Pictures\\supply-chain-management.jpg");
    	given()
    	     //.body(file)
    	     .multiPart(file)
    	 .when()
    	   .post("https://postman-echo.com/post")
    	 .then()
    	    .statusCode(200)
    	    .time(Matchers.lessThan(900l),TimeUnit.SECONDS)
    	    .log().all();
    }
}
