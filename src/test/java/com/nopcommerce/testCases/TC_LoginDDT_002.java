package com.nopcommerce.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass//contain common resources for every test cases
{
@Test(dataProvider ="LoginData")//pass parameter-data provider-Providing data-loging test method
public void loginTest(String user, String pwd) throws InterruptedException, IOException
//need 2 parameter - user & password
{
// Copy from login page 
driver.get(baseURL);
driver.manage().window().maximize();
logger.info("URL is opened....");
		
LoginPage lp = new LoginPage(driver);//login page -object
lp.setUserName(user);
logger.info("User provided");//logger msg
		
lp.setPassword(pwd);
logger.info("Password provided");//logger msg
		
lp.clickLogin();
logger.info("Login in clicked");//logger msg
		
Thread.sleep(5000);
		
if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
{
Assert.assertTrue(true);
lp.clickLogout();	
logger.info("Login Passed");//logger msg
}	
else
{
//captureScreen(driver,"logintest");// no need here-data driven test
Assert.assertTrue(false);
logger.info("Login Failed");//logger msg
}	
}
@DataProvider(name ="LoginData")//Specify in data provider annotation, provide name to identify uniquely
//create data provide method -getdata(),return type is 2 dim array,String type
public String [][]getData() throws IOException//take data from excel and pass into login page
{
//String path ="C:\\Users\\Mohammed Hossain\\Desktop\\Selenium\\Workspace\\nopCommerceV2\\src\\test\\java\\com\\nopcommerce\\testData\\LoginData11.xlsx";
String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData11.xlsx";
//path of xl file (Test data pkg- in same project)
		
int rownum=XLUtils.getRowCount(path, "Sheet1"); //call the row count from xl utils class-# row
int colcount=XLUtils.getCellCount(path, "Sheet1", 1);//1-row #
		
String logindata[][]= new String[rownum][colcount];
		
for(int i=1;i<=rownum;i++)//repeated row in xl
{
for(int j=0;j<colcount;j++)//repeated cloumn in xl
{
logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0 -read data from xl(i-row/j-col)
}
}
return logindata;
}	
}
