package com.rmg.requestTest;
/**
 * 
 * @author Nitheesha
 *
 */

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmg.genericutility.BaseClass;
import com.rmg.genericutility.IEndPoints;
import com.rmg.genericutility.ProjectPojo;

import io.restassured.http.ContentType;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.Random;
public class AddSingleProjectWithCreated extends BaseClass{

	@Test(dataProvider = "getData")
	public void addSingleProjectWithCreated(String createdby,String createdon,String projectname,String projectid,String status,String size) throws Throwable {
		Random ran=new Random();
		int random=ran.nextInt(1000);
		String createdBy=createdby+random;
		String createdOn=createdon+random;
		String projectName=projectname+random;
		//Integer teamSize=Integer.parseInt(size);
		
		ProjectPojo project = new ProjectPojo(createdBy, createdOn, projectid, projectName, status, 10);
		given()
			.contentType(ContentType.JSON)
			.body(project)
		.when()
			.post(IEndPoints.addProject)
		.then()
			.assertThat().body("projectName", Matchers.equalTo(projectName))
		.and()
			.assertThat().body("msg", Matchers.equalTo("Successfully Added"))
		.and()
			.statusCode(201)
		.and().log().all();
		
		String actualstatus = dLib.executeQueryAndGetData("select * from project where project_name='"+projectName+"'", 5, "created");
		Assert.assertEquals("created", actualstatus);
		
	}
	@DataProvider
	public Object[][] getData() throws Throwable{
		return eLib.getAlldataFromExcelSheet("Sheet1");
	}
}
