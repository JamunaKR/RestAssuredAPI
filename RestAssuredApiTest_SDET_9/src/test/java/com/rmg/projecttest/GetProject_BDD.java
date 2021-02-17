package com.rmg.projecttest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProject_BDD {
	
	@Test
	public void getAllProject() {
		when()
		  .get("http://localhost:8084/projects")
	  .then()
	     .log().all()
	     .assertThat().statusCode(200);
	}

}
