package com.rmg.projecttest;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmg.genericutility.DataBaseUtilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifySpecifiProjectAPI_DB_GUI {
	
	
	@Test
	public void createProject() throws Throwable {
		DataBaseUtilities db = new DataBaseUtilities();
		db.connectToDB();

		HashMap map = new HashMap();
		map.put("createdBy", "deepak");
		map.put("projectName", "Nithesh_Gowda_1");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		
		 RequestSpecification respSpec = RestAssured.given();
		 
		 respSpec.contentType(ContentType.JSON);
		 respSpec.body(map);
		Response resp =  respSpec.post("http://localhost:8084/addProject");
		
		String projectID = resp.jsonPath().get("projectId");
		System.out.println(projectID);
		
		//verify data in DB
		db.executeQueryAndGetData("select * from project", 1, projectID);
		
		//Verify data in GUI
		
	}

}
