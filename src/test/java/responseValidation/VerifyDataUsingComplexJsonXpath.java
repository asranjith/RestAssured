package responseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
public class VerifyDataUsingComplexJsonXpath {
    @Test
    public void verifyData() {
    	Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
    	
    	List<String> list = JsonPath.read(resp.asString(),".content[*].projectName");
    	for (String data : list) {
			System.out.println(data);
		}
    }
}
