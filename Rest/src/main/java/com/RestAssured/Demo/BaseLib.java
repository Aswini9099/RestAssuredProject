package com.RestAssured.Demo;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;


public class BaseLib {
	
	
/**
 * @author aswini
 */
	
	
	@BeforeSuite
	public void config()
	{
	 baseURI = "https://reqres.in/";
		
		
	}

}
