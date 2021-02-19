package com.rmg.genericutility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;
public class BaseClass {
	public DataBaseUtilities dLib=new DataBaseUtilities();
	public FileUtils fLib=new FileUtils();
	public ExcelUtility eLib=new ExcelUtility();
	@BeforeSuite
	public void configBS() throws Throwable {
		dLib.connectToDB();
		baseURI=fLib.getPropertyValue("uri");
	}
	
	@AfterSuite
	public void configAS() throws SQLException {
	dLib.closeDb();
	}

	

}
