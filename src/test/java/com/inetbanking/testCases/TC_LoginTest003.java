package com.inetbanking.testCases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest003 extends BaseClass
{
	@Test
	public void addcustomer() throws InterruptedException, IOException 
	{
		logger.info("URL is opened");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp=new LoginPage(driver);//create a LoginPage Object
		lp.setusername(username);        logger.info("username entered");
		lp.setpassword(password);        logger.info("password is entered");
		lp.Loginbutton(null);            logger.info("login button clicked");
		
		AddCustomer ac=new AddCustomer(driver);     //create a AddCustomer object
		ac.clickAddcustomer();           logger.info("addcustomer link clicked");
		Thread.sleep(3000);
		ac.NewCustName("Rajesh");        logger.info("added a customername");
		ac.NewCustGender("female");      logger.info("clicked a female");
		Thread.sleep(5000);
		ac.NewCustDOB("22","09","1993"); logger.info("added a DOB");
		ac.NewCustAddress("Srt 1138,Sanath nagar,Erragada");logger.info("Added a address");
		ac.NewCustCity("Hyderbad");      logger.info("Added a city");
		ac.NewCustState("Telagana");     logger.info("Added a state");
		ac.NewCustPincode("530001");     logger.info("Added a pincode");
		
	    String Telephone=randomAplnumerical();
		ac.NewCustTelephn(Telephone);    logger.info("added a phone no");
		String Email=randomString()+"@gmail.com";
		ac.NewCustEmail(Email);          logger.info("added a email");
		ac.NewCustSubmit();              logger.info("Clicked a submit");	
		Thread.sleep(3000);
		String PS= driver.getPageSource();
		if(driver.getPageSource().equals(PS))
		{
			capturescreen(driver,"loginTest003ADDCustomer");
			logger.info("screenshot Capture");
			Assert.assertTrue(true);
			logger.info("New Customer  is Addeded");
		}
        	else
			{
        		capturescreen(driver,"loginTest003ADDCustomer");
				Assert.assertTrue(false);
				logger.info("New Customer  is failed");
			}
	}
		
		
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	public String randomAplnumerical()
	{
		String generatedstring=RandomStringUtils.randomNumeric(10);
		return generatedstring;
	}
		
		
		
		
		
		
		
}
