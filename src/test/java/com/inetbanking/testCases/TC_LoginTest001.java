package com.inetbanking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest001 extends BaseClass{
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		logger.info("entered username ");
		lp.setpassword(password);
		logger.info("entered password");
        lp.Loginbutton(null);
        logger.info("clicked submit button");
        
       System.out.println(driver.getTitle());
               
    if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
    {
    	Assert.assertTrue(true);
    	capturescreen(driver,"loginTest001");
    	logger.info("login test is passed");
    }
    else
    {
    	capturescreen(driver,"loginTest001");	
    	Assert.assertTrue(false);
    	logger.info("login test is failed");
    }
    lp.Logoutbutton(null);
    logger.info("logout is success");
    driver.switchTo().alert().accept();
    driver.switchTo().defaultContent();
    Thread.sleep(3000);
   
    
	}
	}
