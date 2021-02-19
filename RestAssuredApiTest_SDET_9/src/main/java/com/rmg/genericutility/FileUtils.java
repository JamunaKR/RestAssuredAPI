package com.rmg.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Nitheesha
 *
 */
public class FileUtils {
	/**
	 * Property file to read common data from properties file
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getPropertyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	
}
