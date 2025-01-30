package smartChain;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class AdminTest {
      @Test
      public void addProductByAdmin() {
    	  JSONObject jsonObj= new JSONObject();
    	  jsonObj.put("productName", "apple");
    	  jsonObj.put("price", 150);
    	  jsonObj.put("unitType", "KG");
    	  jsonObj.put("category", "fruit");
    	  jsonObj.put("stockManagement", true);
    	  Response res = given()
    		.auth().oauth2("")	  
    	    .contentType(ContentType.JSON)
    	    .body(jsonObj)
    	  .when()
    	    .post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/admin/add_product");
    	  res.then()
    	     .contentType(ContentType.JSON)
    	     .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
    	     .log().all();
    	     String productId = res.jsonPath().get("product_ID");
    	     System.out.println(productId);  
      }
      @Test
      public void addRetailers() {
    	  JSONObject jsonObj= new JSONObject();
    	  jsonObj.put("username", "TamilSelvi");
    	  jsonObj.put("password", "tamilselvi123");
    	  jsonObj.put("areaCode", "560029");
    	  jsonObj.put("phone", "9655994355");
    	  jsonObj.put("email", "tamilselvi@gmail.com");
    	  Response res = given()
    			.auth().oauth2("")  
    	    	.contentType(ContentType.JSON)
    	    	.body(jsonObj)
    	   .when()
    	    	.post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/admin/add_retailer");
    	  res.then()
    	        .contentType(ContentType.JSON)
 	            .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
 	            .log().all();
    	  String retailerId = res.jsonPath().get("retailer_ID");
 	      System.out.println(retailerId);
      }
      @Test
      public void addManufacturer() {
    	  JSONObject jsonObj= new JSONObject();
    	  jsonObj.put("name", "sekar");
    	  jsonObj.put("email", "sekar66@gmail.com");
    	  jsonObj.put("phone", "9486968388");
    	  jsonObj.put("username", "sekar");
    	  jsonObj.put("password", "sekar123");
    	  Response res = given()
    			.auth().oauth2("")  
      	    	.contentType(ContentType.JSON)
      	    	.body(jsonObj)
      	   .when()
      	    	.post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/admin/add_manufacturer");
      	  res.then()
      	        .contentType(ContentType.JSON)
   	            .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
   	            .log().all();
      	  String manufacturerId = res.jsonPath().get("manufaturer_ID");
   	      System.out.println(manufacturerId);
      }
      @Test
      public void addDistributor() {
    	  JSONObject jsonObj= new JSONObject();
    	  jsonObj.put("name", "zomato");
    	  jsonObj.put("email", "zomato123@gmail.com");
    	  jsonObj.put("phone", "9480098782");
    	  Response res = given()
    			.auth().oauth2("")
      	    	.contentType(ContentType.JSON)
      	    	.body(jsonObj)
      	   .when()
      	    	.post("http:///admin/add_distributor");
      	  res.then()
      	        .contentType(ContentType.JSON)
   	            .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
   	            .log().all();
      	  String distributerId = res.jsonPath().get("distributer_ID");
   	      System.out.println(distributerId);  
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
        	    .post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/admin/add_unit");
        	res.then()
        	    .contentType(ContentType.JSON)
     	        .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
     	         .log().all();  
      }
      @Test
      public void addCategory() {
    	  JSONObject jsonObj= new JSONObject();
    	  jsonObj.put("categoryName", "utensils");
    	  Response res = given()
    			 .auth().oauth2("") 
        	     .contentType(ContentType.JSON)
        	     .body(jsonObj)
        	 .when()
        	    .post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/admin/add_category");
        	res.then()
        	    .contentType(ContentType.JSON)
     	        .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
     	        .log().all(); 
      }
      @Test
      public void addArea() {
    	  JSONObject jsonObj= new JSONObject();
    	  jsonObj.put("areaName", "BTM");
    	  jsonObj.put("areaCode", "560029");
    	  Response res = given()
    			 .auth().oauth2("") 
        	     .contentType(ContentType.JSON)
        	     .body(jsonObj)
        	 .when()
        	    .post("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/admin/add_area");
        	res.then()
        	    .contentType(ContentType.JSON)
     	        .time(Matchers.lessThan(3000l),TimeUnit.SECONDS)
     	        .log().all();
    	  
      }
}
