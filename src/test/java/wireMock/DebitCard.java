package wireMock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DebitCard {
	@Test
	public void debitCard() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("debitCardNum", "1234567887654321");
		jsonObj.put("cvv", "543");
		jsonObj.put("expDate", "28/300");
		given()
		   .contentType(ContentType.JSON)
		   .body(jsonObj)
		.when()
		   .post("http://localhost:9999/debitCard")
		.then()
		   .log().all();
		
	}
    
}
