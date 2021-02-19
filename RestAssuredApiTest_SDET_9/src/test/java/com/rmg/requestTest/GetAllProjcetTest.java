package com.rmg.requestTest;

import com.rmg.genericutility.BaseClass;
import com.rmg.genericutility.IEndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * 
 * @author Nitheesha
 *
 */
public class GetAllProjcetTest extends BaseClass {
	/**
	 * @throws Throwable 
	 * 
	 */
	@Test
	public void getAllprojectTest() throws Throwable {
		Response response = given()
			.contentType(ContentType.JSON)
		.when()
			.get(IEndPoints.getAllProject);
		response.then()
			.assertThat().statusCode(200)
		.and()
		.log().all();
		
		ArrayList<String> projectNames=response.jsonPath().get("projectName");
		for(int i=0;i<projectNames.size();i++) {
			String projectDB=dLib.executeQueryAndGetData("select * from project", 4, projectNames.get(i));
			Assert.assertEquals(projectNames.get(i), projectDB);
		}
			
	}

}
