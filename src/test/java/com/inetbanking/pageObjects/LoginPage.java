package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	 public LoginPage(WebDriver rdriver)//create one method for local driver
	 {
		driver=rdriver;
		 PageFactory.initElements(rdriver,this);
	 }
	 //write a login locators with help FindFactory
	 @FindBy(name="uid")
	 WebElement Username;
	 @FindBy(name="password")
	 WebElement Password;
	 @FindBy(xpath="//input[@value='LOGIN']")
	 WebElement LoginIn;
	 @FindBy(xpath="//a[contains(text(),'Log out')]")
	 WebElement linklogout;
	
	 public void setusername(String usname)
	 {
		 //driver.find.Element(By.xpath()).sendKeys();
		    Username.sendKeys(usname);
		    
	 }
	 public void  setpassword(String Passwrd)
	 {
		 Password.sendKeys(Passwrd);
	 }
	 public void Loginbutton(String loginstr)
	 {
		 LoginIn.click();
	 }
	 public void Logoutbutton(String logoutstr)
	 {
		 linklogout.click();
	 }
	 
	 
	 
	 
	

}
