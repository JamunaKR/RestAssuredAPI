package com.rmg.projecttest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining_BDD {
	
	
	@Test
	public void getAndDeleteFirstPRoject() {
		
		 Response resp = when()
		                   .get("http://localhost:8084/projects");
		  String projectID = resp.jsonPath().get("[0].projectId");
		  
		      when()
		        .delete("http://localhost:8084/projects/"+projectID)
		      .then()
		       .log().all();
	}

}
