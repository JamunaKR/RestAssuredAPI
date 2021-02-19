package com.rmg.genericutility;

import io.restassured.response.Response;
/**
 * 
 * @author Nitheesha
 *
 */
public class RequestUitity {
	/**
	 * 
	 * @param response
	 * @param jsonPath
	 * @return json value 
	 */
	public Object getJsonValueFromResponse(Response response,String jsonPath) {
		return response.jsonPath().get(jsonPath);
	}
	/**
	 * 
	 * @param response
	 * @param xmlPath
	 * @return xml value
	 */
	public Object getXMLValueFromResponse(Response response,String xmlPath) {
		return response.xmlPath().get(xmlPath);
	}
	
	/**
	 * 
	 * @param respose
	 * @param xpath
	 * @return html value
	 */
	public Object getHTMLValueFromResponse(Response respose,String xpath) {
		return respose.htmlPath().get(xpath);
	}
}
