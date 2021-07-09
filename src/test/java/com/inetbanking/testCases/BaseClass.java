package com.inetbanking.testCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;



public class BaseClass {
	public static WebDriver driver;//for awaking driver
	 Readconfig rc=new Readconfig();
	public String baseurl=rc.setupbaseurl();
	public String username=rc.SetupUsername();
	public String password=rc.SetupPassword();
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeTest
	public void Setup(String br)
	{
		 logger=Logger.getLogger("ebanking");
	     PropertyConfigurator.configure("Log4j.properties");
	     
	     if(br.equals("chrome"))
	     {
	      //System.getProperty("user.dir")+"Drivers//chromedriver.exe");
	     System.setProperty("webdriver.chrome.driver",rc.SetupChromepath());
	     driver=new ChromeDriver();
	     }
	     else if(br.equals("firefox"))
	     {
	    	 System.setProperty("webdriver.gecko.driver", rc.Setupfirefoxpath());
	    	 driver=new FirefoxDriver();
	     }
	     else if(br.equals("microsoft Edge"))
	     {
	    	 System.getProperty("webdriver.edge.driver",rc.SetupMicrosoftEdge());
	     }
	     driver.get(baseurl);
	     logger.info("entered url");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     logger.info("maxm the page");
	    
	     
	}
	@AfterTest
	public void Teardown() throws InterruptedException 
	{
		driver.quit();
		logger.info("Page is closed");
		Thread.sleep(3000);
		
	}
	public  void capturescreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshot/"+tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	
	}
	
}

