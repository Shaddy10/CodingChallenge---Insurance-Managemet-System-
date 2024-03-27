package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	
	  public static String getPropertyString(String fileName) throws IOException {
	  Properties prop = new Properties(); InputStream input = null;
	  
	  try { 
		  input =
	  PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
	  
	  if (input == null) { 
		  throw new IOException("Unable to find " + fileName); 
	}
	  
	  prop.load(input);
	  
	  String hostName = prop.getProperty("hostname"); 
	  String portNumber =prop.getProperty("portnumber"); 
	  String dbName = prop.getProperty("dbname");
	  String userName = prop.getProperty("username"); 
	  String password =prop.getProperty("password");
	  
	  return "jdbc:mysql://" + hostName + ":" + portNumber + "/" + dbName +"?user=" + userName + "&password=" + password; 
	  } finally { if (input != null){ 
		  input.close(); 
		  } 
	  } 
	}
	 
}
