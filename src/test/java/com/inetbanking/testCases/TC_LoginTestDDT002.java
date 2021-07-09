package com.inetbanking.testCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginTestDDT002 extends BaseClass {

	@Test(dataProvider ="Login")
	public void loginDDT(String xlsxUserdata,String xlsxPasswrd) throws InterruptedException {
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setusername(xlsxUserdata);
		logger.info("entered username ");
		lp.setpassword(xlsxPasswrd);
		logger.info("entered password");
		lp.Loginbutton(null);
		logger.info("Login");	
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.Logoutbutton(null);
			Thread.sleep(3000);
			logger.info("logout is succesfully");
			driver.switchTo().alert().accept();//close the logout alert
		}
	}
	public boolean isAlertPresent()//user defined method created to check alert button
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}	
	}

	@DataProvider(name="Login")
	 String[][] getData() throws IOException {
		String Path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(Path, "Sheet1");
		int Colmcount = XLUtils.getCellCount(Path, "Sheet1", 1);

		String LoginData[][] = new String[rownum][Colmcount];
		for (int i = 1; i<= rownum; i++) 
		{
			for (int j=0; j<Colmcount; j++) {
				LoginData[i-1][j]=XLUtils.getCellData(Path, "Sheet1", i, j);// 1 0
			}
		}
		return LoginData;
	}

}
