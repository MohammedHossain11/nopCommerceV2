package com.nopcommerce.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {// For read the config.properties file.
	
Properties pro;// create object for properties class

public ReadConfig ()//create constractor
	
{
File src = new File("./Configuration/config.properties");// location of the file
//(Current project directory - folder      - file name)

try {//block use if file are not available
//Read the data from configuration file
FileInputStream fis = new FileInputStream(src);//src- represent the location of the file.
pro = new Properties();
pro.load(fis);// load the file during run time
} catch (Exception e) {
System.out.println("Exception is " + e.getMessage());
}
}

//below all the method for all value from property file
public String getApplicationURL()
{
String url=pro.getProperty("baseURL");//key value
return url;
}
	
public String getUseremail()
{
String username=pro.getProperty("useremail");
return username;
}
	
public String getPassword()
{
String password=pro.getProperty("password");
return password;
}
	
public String getChromePath()
{
String chromepath=pro.getProperty("chromepath");
return chromepath;
}
	
public String getIEPath()
{
String iepath=pro.getProperty("iepath");
return iepath;
}
	
public String getFirefoxPath()
{
String firefoxpath=pro.getProperty("firefoxpath");
return firefoxpath;
}
}
