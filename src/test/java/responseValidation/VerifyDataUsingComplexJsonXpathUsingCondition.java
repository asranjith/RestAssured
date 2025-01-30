package responseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
public class VerifyDataUsingComplexJsonXpathUsingCondition {
    @Test
    public void verifyData() {
    	Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
    	resp.then().log().all();
    	//this JsonPath class is present in com.jayway.jsonpath package
    	List<String> list = JsonPath.read(resp.asString(),".content.[*].[?(@.projectName=='webt')].projectId");
    	String actProjectID = list.get(0);
    	Assert.assertEquals(actProjectID, "NH_PROJ_9845");
    }
}
