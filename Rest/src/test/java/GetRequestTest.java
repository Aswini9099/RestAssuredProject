

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetRequestTest  {
	
	@Test
	public void getResourceTest()
	{
		Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.then().log().all());
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		String ctype = resp.getContentType();
		
	Assert.assertEquals(ctype, "application/json; charset=utf-8");
	}

}
