package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Practice {
	@Test
	public void postMethod() {
		JSONObject obj = new JSONObject();
		obj.put("Name", "ASR");
		obj.put("age", "10");
		
	
		
	}

}
