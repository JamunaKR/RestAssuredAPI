package com.rmg.projecttest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Oauth2test {
	@Test
	public void authTest() {
		Response response=given()
			.formParam("client_id", "SDET9")
			.formParam("client_secret", "59ed85ea437bb939b9830b3d2d99d8e2")
			.formParam("grant_type", "client_credentials")
			.formParam("code", "authorization_code")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		response.then()
		.log().all();
		String token=response.jsonPath().get("access_token");
		
		given()
			.contentType(ContentType.JSON)
			.baseUri("http://coop.apps.symfonycasts.com")
			.pathParam("USER_ID", "1301")
			.auth().oauth2(token)
		.when()
			.post("/api/{USER_ID}/eggs-count")
		.then()
			.log().all();
		
	}

}
