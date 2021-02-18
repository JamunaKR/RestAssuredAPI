package com.rmg.genericutility;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Sample {
	
	public static void main(String[] args) throws Throwable, JsonMappingException, IOException {
		
//		ProjectPojo proj = new ProjectPojo("Nithesh", "18/02/2021", "TY_03", "AWS", "ongoing", 2);
		ObjectMapper obj=new ObjectMapper();
//		obj.writeValue(new File("./project.json"), proj);
//		System.out.println("success");
		
		ProjectPojo proj = obj.readValue(new File("./project.json"), ProjectPojo.class);
		System.out.println(proj.createdOn);
	}

}
