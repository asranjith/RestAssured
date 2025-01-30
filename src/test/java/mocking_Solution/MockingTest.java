package mocking_Solution;

import org.mockito.Mockito;
import org.testng.Assert;

class PANcard {
	   public String isValid(String panCard) {
		   if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]") == true) {
			   return "is valid pan";
		   }else {
			   return "is invalid pan";
		   }
	   }
	   public static PANcard getMockObject() {
		   PANcard mockObj = Mockito.mock(PANcard.class);
		   Mockito.when(mockObj.isValid("ABCDE1234A")).thenReturn("valid PAN card");
		   Mockito.when(mockObj.isValid("ABCDE1234B")).thenReturn("valid PAN card");
		   Mockito.when(mockObj.isValid("ABCDE1234C")).thenReturn("valid PAN card");
		   Mockito.when(mockObj.isValid("ABCDE1234D")).thenReturn("valid PAN card");
		   return mockObj;
	   }
}   
public class MockingTest {
  public static void main(String[] args) {
	  PANcard obj=PANcard.getMockObject();
	  System.out.println(obj.isValid("ABCDE1234A"));
	  // it will give null value
	  Assert.assertEquals(obj.isValid("ABCDE1234a"), "in valid PAN card");
    }
  }
