package com.RestAssured.Demo;

public interface IEndPoints {
	
	String USER_DIR = System.getProperty("user.dir");
    String GET_ALL_DETAILS="api/users?page=2";
    String GET_SINGLE_ID="api/users/{id}";
    String CREATE_RESOURCE="api/users";

	
	

}
