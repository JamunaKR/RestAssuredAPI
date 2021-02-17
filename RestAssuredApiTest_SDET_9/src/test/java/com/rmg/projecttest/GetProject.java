package com.rmg.projecttest;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {
	
	@Test
	public void getAllProject() {
		Response resp = RestAssured.get("http://localhost:8084/projects");

	       
		//Display the Response Body
		resp.prettyPrint();
		
		int actStatusCode = resp.getStatusCode();
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200);
		
		String actContType = resp.getContentType();
		System.out.println(actContType);
		
		String firstID = resp.jsonPath().get("[0].projectId");
		System.out.println(firstID);
		
		
		
		
	}
	
	

}
