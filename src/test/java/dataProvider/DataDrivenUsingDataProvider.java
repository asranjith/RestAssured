package dataProvider;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.IOException;
public class DataDrivenUsingDataProvider {
   @Test(dataProvider = "getData")
   public void dataDrivenTest(String Pname, String status) {
	   String data="{\r\n"
	   		+ "  \"createdBy\": \"ASR\",\r\n"
	   		+ "  \"projectName\": \""+Pname+"\",\r\n"
	   		+ "  \"status\": \""+status+"\",\r\n"
	   		+ "  \"teamSize\": 0\r\n"
	   		+ "}";
	   given()
	      .contentType(ContentType.JSON)
	      .body(data)
	   .when()
	      .post("http://49.249.28.218:8091/addProject")
	   .then()
	      .log().all(); 
   }
     @DataProvider
     public Object[][] getData() throws EncryptedDocumentException, IOException {
    	 ExcelUtility elib = new ExcelUtility();
    	 int rowCount = elib.getRowCount("Sheet1");
    	 Object[][] obj = new Object[rowCount][2];
    	 for(int i=0;i<rowCount;i++) {
    		 obj[i][0]= elib.getDataFromExcel("Sheet1", i+1, 0);
    		 obj[i][1]= elib.getDataFromExcel("Sheet1", i+1, 1);
    	 }
    	 return obj;
     }
}
