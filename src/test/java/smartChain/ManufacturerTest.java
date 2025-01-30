package smartChain;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ManufacturerTest {
	@Test
	public void addProductByManufacture() {
		JSONObject jsonObj= new JSONObject();
  	  jsonObj.put("productName", "orange");
  	  jsonObj.put("price", 150);
  	  jsonObj.put("unitType", "KG");
  	  jsonObj.put("category", "fruit");
  	  jsonObj.put("stockManagement", true);
  	  Response res = given()
  		.auth().oauth2("")	  
  	    .contentType(ContentType.JSON)
  	    .body(jsonObj)
  	  .when()
  	    .post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/manufacturer/add_product");
  	  res.then()
  	     .contentType(ContentType.JSON)
  	     .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
  	     .log().all();
  	     String productId = res.jsonPath().get("product_ID");
  	     System.out.println(productId);
	}
	@Test
	public void addUnit() {
		  JSONObject jsonObj= new JSONObject();
    	  jsonObj.put("unitName", "plate");
    	  Response res = given()
    			 .auth().oauth2("") 
        	     .contentType(ContentType.JSON)
        	     .body(jsonObj)
        	 .when()
        	    .post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/manufacturer/add_unit");
        	res.then()
        	    .contentType(ContentType.JSON)
     	        .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
     	         .log().all();
	}

}
