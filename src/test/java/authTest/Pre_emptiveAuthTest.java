package authTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Pre_emptiveAuthTest {
    @Test
    public void pre_emptiveAuth() {
    	given()
 	      .auth().preemptive().basic("rmgyantra", "rmgy@9999")
 	      .log().all()
 	    .when()
 	      .get("http://49.249.29.5:8091/login")
 	    .then()
 	      .log().all();
    }
}
