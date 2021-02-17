package com.rmg.projecttest;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreatePRoject {
	@Test
	public void cerateProjectTest() {
		
		HashMap map = new HashMap();
		map.put("createdBy", "deepak");
		map.put("projectName", "Sunil_BTM");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		
		 RequestSpecification respSpec = RestAssured.given();
		 
		 respSpec.contentType(ContentType.JSON);
		 respSpec.body(map);
		Response resp =  respSpec.post("http://localhost:8084/addProject");
		
		System.out.println(resp.getStatusCode());
		resp.prettyPrint();
		
	}
	
	
//	@Test
	public void cerateProjectVaiJSonobjectTest() {
		
		JSONObject map = new JSONObject();
		map.put("createdBy", "deepak");
		map.put("projectName", "Sunil_BTR_1");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		
		 RequestSpecification respSpec = RestAssured.given();
		 
		 respSpec.contentType(ContentType.JSON);
		 respSpec.body(map);
		Response resp =  respSpec.post("http://localhost:8084/addProject");
		
		System.out.println(resp.getStatusCode());
		resp.prettyPrint();
		
	}
	
	
	//@Test
	public void cerateProjectVaiFileTest() {
        File fileObj = new File(".//Data.json");
		
		 RequestSpecification respSpec = RestAssured.given();
		 
		 respSpec.contentType(ContentType.JSON);
		 respSpec.body(fileObj);
		Response resp =  respSpec.post("http://localhost:8084/addProject");
		
		System.out.println(resp.getStatusCode());
		resp.prettyPrint();
		
	}
}
