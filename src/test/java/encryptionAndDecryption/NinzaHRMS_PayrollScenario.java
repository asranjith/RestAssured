package encryptionAndDecryption;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class NinzaHRMS_PayrollScenario {
    @Test
    public void UpdatePayrollInfoViaAESEncryption() throws Exception {
    	EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
    String jBody="";
      String jReqBody = ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
      System.out.println(jReqBody);
    	Response resp = given()
    	  .body(jBody)
    	.when()
    	  .put("http://49.249.28.218:8091/payroll");
    	resp.then()
    	  .log().all(); 
    	String respBody = ed.decrypt(resp.getBody().asString(), "Ac03tEam@j!tu_#1");
    	System.out.println(respBody);
    }
}
