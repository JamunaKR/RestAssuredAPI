package com.rmg.projecttest;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class BasicAuthUsingGitHub {
	
	@Test
	public void basicAuthUsingGithubTest() {
		given()
		.baseUri("https://api.github.com")
		.contentType(ContentType.JSON)
		.pathParam("owner", "NitheshHS")
		.pathParam("repo", "BDDCucumberSDET8")
		.auth().basic("NitheshHS", "nithesh@1998")
		.when()
		.get("/repos/{owner}/{repo}")
		.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().body("name", Matchers.equalToIgnoringCase("BDDCucumberSDET8"))
		.and()
		.assertThat().header("Content-Type", "application/json; charset=utf-8")
		.and()
		.assertThat().time(Matchers.lessThan(4l), TimeUnit.SECONDS)
		.and()
		.assertThat().statusLine("HTTP/1.1 200 OK")
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}

}
