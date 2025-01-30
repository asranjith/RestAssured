package shoppersStack;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
public class ProductViewAction {
	@Test
	public void getAllProducts() {
		given()
			.auth().oauth2(ShopperProfile.token)	
		.when()
		  .get("https://www.shoppersstack.com/shopping/products")
		.then()
		  .log().all();
	}

}
