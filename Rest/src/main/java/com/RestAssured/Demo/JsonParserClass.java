package com.RestAssured.Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;





public class JsonParserClass implements IEndPoints {

	public  static  JSONObject convertToJsonObject(String filename) throws FileNotFoundException, IOException, ParseException
	{
		Object obj=new JSONParser()
				.parse(new FileReader(USER_DIR + "/data/" + filename +".json"));
		
		JSONObject jobj= (JSONObject) obj;
		return jobj;
				
	}
	
	
public static  Response performPost() throws IOException
{
		
FileInputStream fis= new FileInputStream (new File("./data/data.json"));
	
	RequestSpecification reqsp=RestAssured.given();
	reqsp.contentType(ContentType.JSON);
	reqsp.body(IOUtils.toString(fis));
	Response resp=reqsp.post("https://reqres.in/api/users");
	return resp;
}





}