package restAsuured;

import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.RestAssured.Demo.BaseLib;
import com.RestAssured.Demo.IEndPoints;
import com.RestAssured.Demo.JsonParserClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import  static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RestAssuredMethodsTest extends BaseLib implements IEndPoints{
	
	//To get all Resources
	@Test(priority=0)
   public  void getAllDetails()
	{
	when().get(GET_ALL_DETAILS).
  then()
	.log().ifStatusCodeIsEqualTo(200);
}
	
	
	//To get particular resource by email id 
  @Test(priority=1)
  public  void getOneDetail()
	{
	given().pathParam("id",8)
	.when().get(GET_SINGLE_ID).
	then().
	log().ifStatusCodeIsEqualTo(200);

	
	}

	//To post the resource in database 
	
	
	
@Test (priority=2)
public void postResources () throws FileNotFoundException, IOException, ParseException
{
		
	JSONObject jo = JsonParserClass.convertToJsonObject("data");
	given().
		contentType(ContentType.JSON).
	    body(jo.toJSONString()).
	when(). post(CREATE_RESOURCE).
	then().statusCode(201).
	and().contentType(ContentType.JSON);
	
}
	 
	
	
//To Perform patch operation

	@SuppressWarnings("unchecked")
	@Test (priority=3)
	public void patchResources () throws FileNotFoundException, IOException, ParseException
	{
	
	
  JSONObject jObj = new JSONObject();
  
   jObj.put("email", "Ashwini123@gmail.com");

  given()
  	.contentType(ContentType.JSON)
  	.body(jObj.toJSONString()).
  when()
  .pathParam("id", "2").patch(IEndPoints.GET_SINGLE_ID).
	  then()
 	.log().ifStatusCodeIsEqualTo(200)
 	.and()
  	.assertThat().contentType(ContentType.JSON);
  
}


//To Perform Put Operation 

@Test(priority=4)
public void putResources () throws FileNotFoundException, IOException, ParseException
{
		
	
	  JSONObject jObj = new JSONObject();
      
    jObj.put("email", "Asw@yahoo.com");

  given()
  	.contentType(ContentType.JSON)
  	.pathParam("id", "7")
  	.body(jObj.toJSONString()).
  when()
  	.put(IEndPoints.GET_SINGLE_ID).
  then()
 	.log().ifStatusCodeIsEqualTo(200)
 	.and()
 	.assertThat().contentType(ContentType.JSON);
}

	
	
	//To delete the particular resource from API

@Test(priority=5)
public void deleteResourceTest()
	{
	given()
		.pathParam("id",7).
	when()
		.delete(IEndPoints.GET_SINGLE_ID).
	then()
			.log().ifStatusCodeIsEqualTo(204);
	
		
		
	}


//Try to delete the resource which is not available 
@Test(priority=6)
public void deleteResource1Test()
	{
	given()
		.pathParam("id",7).
	when()
		.delete(IEndPoints.GET_SINGLE_ID).
	then()
			.log().ifStatusCodeIsEqualTo(404);
	
		
		
	}
//Try to post duplicate resources 
@Test(priority=7)
public void postDuplicateResources () throws FileNotFoundException, IOException, ParseException
{
		
	JSONObject jo = JsonParserClass.convertToJsonObject("data");
	given().
		contentType(ContentType.JSON).
	    body(jo.toJSONString()).
	when(). post(CREATE_RESOURCE).
	then().statusCode(201).
	and().contentType(ContentType.JSON);
	
}

//Get resource which is not available 


@Test(priority=8)
public  void getUnavailableResourceDetail()
	{
	given().pathParam("id",201)
	.when().get(GET_SINGLE_ID).
	then().
	log().ifStatusCodeIsEqualTo(404);

	
	}


}
	
