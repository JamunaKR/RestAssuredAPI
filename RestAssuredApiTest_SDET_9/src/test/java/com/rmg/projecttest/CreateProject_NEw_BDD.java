package com.rmg.projecttest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject_NEw_BDD {
	
	@Test
	public void cerateProjectVaiFileTest() {
        File fileObj = new File(".//Data.json");
		 
	     given()
	       .contentType(ContentType.JSON)
	       .body(fileObj)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	       .assertThat().statusCode(201)
	       .and()
	       .assertThat().contentType(ContentType.JSON);
		
	}

}
