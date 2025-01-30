package shoppersStack;

import org.testng.annotations.Test;

import utility.JavaUtility;

public class Testing {
   @Test
   public void test1() {
	   JavaUtility javaUtility = new JavaUtility();
       System.out.println(javaUtility.randomNumber());
       System.out.println(javaUtility.uniqueEmail("abc@gmail.com"));
   }
}
