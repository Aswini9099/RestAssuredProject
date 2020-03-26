package com.RestAssured.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class DataBaseUtilities {
	
	public static Connection connectToDataBase() throws SQLException
	{
	
	
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hibernate","root","root");
	return con;
	
	
	}
			
	
	public static LinkedHashMap getDataFromDB(String query) throws SQLException
	
	{
		LinkedHashMap data=new LinkedHashMap();
		Connection con=connectToDataBase();
		       ResultSet result = con.createStatement().executeQuery(query);
		       ResultSetMetaData resMetaData = result.getMetaData();
		       for(int i=0;i<resMetaData.getColumnCount();i++)
		       {
		    	   data.put(resMetaData.getColumnName(i),result.getString(i));
		       }
		       con.close();
		       
		
		
		
		
		
		return data;
		
	}

}
