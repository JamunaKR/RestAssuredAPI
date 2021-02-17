package com.rmg.projecttest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifySpecifiProject {
	
	
	@Test
	public void getAllProject() {
		String expectedProject = "Sunil_BTM_Banglore_1";
		
		Response resp = RestAssured.get("http://localhost:8084/projects");
        
		//resp.prettyPrint();
		
		List<String> lst = resp.jsonPath().get("projectName");
        boolean flag = false;
		for(String str : lst) {
			if(expectedProject.equals(str)) {
				System.out.println(expectedProject + " project is available");
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println(expectedProject + " project is not  available");

		}
		
		
	}

}
