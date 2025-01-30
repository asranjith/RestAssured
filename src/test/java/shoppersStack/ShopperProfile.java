package shoppersStack;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import utility.JavaUtility;

public class ShopperProfile {
	JavaUtility javaUtility = new JavaUtility();
	String email;
	String role;
	static String token;
	String userid;
	@Test(priority = 1)
	public void registerAsShopper() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("city", "bangalore");
		jsonObj.put("country", "india");
		jsonObj.put("email", javaUtility.uniqueEmail("sekar@gmail.com"));
		jsonObj.put("firstName", "asr");
		jsonObj.put("gender", "MALE");
		jsonObj.put("lastName", "sekar");
		jsonObj.put("password", "sekar66#");
		jsonObj.put("phone", "9791633488");
		jsonObj.put("state", "karnataka");
		jsonObj.put("zoneId", "ALPHA");
		
		String response = given()
		   .contentType(ContentType.JSON)
		   .body(jsonObj)
		.when()
			.post("https://www.shoppersstack.com/shopping/shoppers")
		.then()
		    .assertThat().statusCode(201)
		    .time(Matchers.lessThan(900l),TimeUnit.SECONDS)
			.contentType(ContentType.JSON)
			.log().all().extract().response().asString();
		JsonPath jp = new JsonPath(response);
		email = jp.getString("data.email");
		System.out.println("Email :"+ email);
		role = jp.getString("data.role");
		System.out.println("Role :"+role);
		userid = jp.getString("data.userId");
		System.out.println("UserId:"+ userid);
	}
	    @Test(priority = 2)
	    public void shopperLogin() {
	    	JSONObject jsonObj = new JSONObject();
	    	jsonObj.put("email", email);
	    	jsonObj.put("password", "sekar66#");
	    	jsonObj.put("role", role);
	    	
	    	String response = given()
	    	   .contentType(ContentType.JSON)
	    	   .body(jsonObj)
	    	.when()
	    	   .post("https://www.shoppersstack.com/shopping/users/login")
	    	.then()
	    	    .assertThat().statusCode(200)
			    .time(Matchers.lessThan(900l),TimeUnit.SECONDS)
				.contentType(ContentType.JSON)
				.log().all().extract().response().asString();
	    	JsonPath jp = new JsonPath(response);
	    	token = jp.getString("data.jwtToken");
	    	System.out.println("Token :"+token);
	    	
	    }
	    
	    @Test(priority = 3)
	    public void findShopperByShopperId() {
	    	given()
	    		.pathParam("shopperId", userid)
	    		.auth().oauth2(token)
	    	.when()
	    	  .get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}")
	    	.then()
	    	   //.contentType(ContentType.JSON)
	    	   .time(Matchers.lessThan(900l),TimeUnit.SECONDS)
	    	   .statusCode(200)
	    	   .log().all().extract().response().asString();
	    }

}
