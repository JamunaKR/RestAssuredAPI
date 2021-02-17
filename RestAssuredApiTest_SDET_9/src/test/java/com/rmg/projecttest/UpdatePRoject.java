package com.rmg.projecttest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdatePRoject {

	//@Test
	public void updatePRoject() {
		
		
		
		
		HashMap map = new HashMap();
		map.put("createdBy", "deepak");
		map.put("projectName", "Sunil_BTM_Mysore");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		
		 RequestSpecification respSpec = RestAssured.given();
		 
		 respSpec.contentType(ContentType.JSON);
		 respSpec.body(map);
		Response resp =  respSpec.put("http://localhost:8084/projects/TY_PROJ_2409");
		
		System.out.println(resp.getStatusCode());
		resp.prettyPrint();
		
	}
	
	@Test
	public void update_PRoject() {
		
		HashMap map = new HashMap();
		map.put("createdBy", "deepak");
		map.put("projectName", "Sunil_BTM_Mangalore_1");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		
		 RequestSpecification respSpec = RestAssured.given();
		 
		 respSpec.contentType(ContentType.JSON);
		 respSpec.body(map);
		Response resp =  respSpec.post("http://localhost:8084/addProject");
		resp.then().log().all();
	   
		String projectID = resp.jsonPath().get("projectId");
		
		HashMap map1 = new HashMap();
		map1.put("createdBy", "deepak");
		map1.put("projectName", "Sunil_BTM_Banglore_1");
		map1.put("status", "Created");
		map1.put("teamSize", 10);
		
		respSpec.contentType(ContentType.JSON);
		respSpec.body(map1);
		Response resp1 =  respSpec.put("http://localhost:8084/projects/"+projectID);
		resp1.then().log().all();
		
		
	}
}
