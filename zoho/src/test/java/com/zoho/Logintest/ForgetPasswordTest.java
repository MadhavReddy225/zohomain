package com.zoho.Logintest;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoho.base.ExcelRead;
import com.zoho.base.KeywordsImpl;



public class ForgetPasswordTest {
   @Test
public void forgetPasswordtest() {
	    
	   ArrayList testData = ExcelRead.getTestData("D:\\Create_Facebook_Account.xlsx");
	   KeywordsImpl key = new KeywordsImpl();
	   for (int i = 0; i < testData.size(); i++) {
		   if (testData.get(i).equals("open")){
			   key.open();
			   
		   }
		   
		if (testData.get(i).equals("url")) {
			String urlLink= (String) testData.get(i+1);
				key.url(urlLink);
		}			
		if (testData.get(i).equals("input")) {
			String data = (String ) testData.get(i+1);
			String keyName = (String) testData.get(i+2);
			key.input(data,keyName);
			
		
	   }
	   if(testData.get(i).equals("click")) {
	 	  String keyName = (String) testData.get(i+2);
	 	  key.click(keyName);
	 	  
	 	}
	   if(testData.get(i).equals("verifyTitle")) {
	 	  String expectedValue = (String) testData.get(i+1);
	 	  String actualValue = key.verifyTitle();
	 	  Assert.assertEquals(expectedValue, actualValue);
	 	  
	   }
	   if(testData.get(i).equals("verifyPageText")) {
	 	  String expectedValue = (String) testData.get(i+1);
	 	  String ObjectName = (String) testData.get(i+2);
	 	  String actualValue = key.verifyPageText(ObjectName);
	 	  Assert.assertEquals(expectedValue, actualValue);
	   }
	   if (testData.get(i).equals("close")) {
	 	  key.close();

		}
	   }
   }  
}		
	
	   
	

 

  


