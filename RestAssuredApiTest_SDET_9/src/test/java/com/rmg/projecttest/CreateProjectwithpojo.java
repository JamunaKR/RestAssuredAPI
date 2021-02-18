package com.rmg.projecttest;

import org.testng.annotations.Test;

import com.rmg.genericutility.ProjectPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class CreateProjectwithpojo {
	
	@Test
	public void createProjectPojoTest() {
		//JSONObject
		//HashMAp
		//File
		ProjectPojo porj = new ProjectPojo("NitheshHS", "18/02/2021", "TY_01", "TMRO APP", "completed", 5);
		given()
			.baseUri("http://localhost:8084")
			.contentType(ContentType.JSON)
			.body(porj)
		.when()
			.post("/addProject")
		.then()
			.log().all();
	}

}
