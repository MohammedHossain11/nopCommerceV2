package com.nopcommerce.testCases;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {//Common thing for every test cases
	
ReadConfig readconfig = new ReadConfig();//create object 
public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUseremail();
public String password=readconfig.getPassword();
public static  WebDriver driver;
public static Logger logger;// class
	
@BeforeClass
@Parameters("browser")
public void setup(String br)// br-come from xml file
{
logger=Logger.getLogger("nopEcommerce");//inititate logger class - project name
PropertyConfigurator.configure("Log4j.properties");//set up method - For every class generate logs
		
if(br.equals("chrome"))
{
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohammed Hossain\\Desktop\\Selenium\\chromedriver_win32//chromedriver.exe");
System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());//chromedriver.exe");
driver = new ChromeDriver();
}
else if(br.equals("firefox"))
{
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohammed Hossain\\Desktop\\Selenium\\chromedriver_win32//chromedriver.exe");
System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());//chromedriver.exe");
driver = new FirefoxDriver();
}
else if(br.equals("ie"))
{
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohammed Hossain\\Desktop\\Selenium\\chromedriver_win32//chromedriver.exe");
System.setProperty("webdriver.ie.driver",readconfig.getIEPath());//chromedriver.exe");
driver = new InternetExplorerDriver();
}		
}
@AfterClass
public void tearDown()
{
driver.quit();
}
// Extend reports- take screen shots - for failure test cases - user defined methods
public void captureScreen(WebDriver driver, String tname) throws IOException {//tname- testcase name
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");//t-tc name
FileUtils.copyFile(source, target);
System.out.println("Screenshot taken");
}

// For adding Add customer page/add customer
public static String randomestring() {
String generatedString1 = RandomStringUtils.randomAlphabetic(5);
return (generatedString1);
}

public static String randomeNum() {
String generatedString2 = RandomStringUtils.randomAlphanumeric(4);
return (generatedString2);
}
}
