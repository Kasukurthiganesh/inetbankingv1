package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	WebDriver driver;
	
	 public  AddCustomer (WebDriver driver)//create one method for local driver
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	@FindBy(how=How.XPATH,using="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement linkAddCustomer;
	@FindBy(how=How.XPATH,using="//input[@onkeyup='validatecustomername();']")
	@CacheLookup
	WebElement CustomerName;
	@FindBy(how=How.XPATH,using="//tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement Gender;
	@FindBy(how =How .ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement DataofBirth;
	@FindBy(how =How.XPATH ,using="//tbody/tr[7]/td[2]/textarea[1]")
	@CacheLookup
	WebElement Address;
	@FindBy(how =How.NAME ,using="city")
	@CacheLookup
	WebElement City;
	@FindBy(how =How.NAME,using="state")
	@CacheLookup
	WebElement  State;
	@FindBy(how =How.NAME,using="pinno")
	@CacheLookup
	WebElement  Pincode;
	@FindBy(how =How.NAME,using="telephoneno")
	@CacheLookup
	WebElement  telephoneNo;
	@FindBy(how =How.NAME,using="emailid")
	@CacheLookup
	WebElement  Email;
	@FindBy(how =How.NAME,using="sub")
	@CacheLookup
	WebElement  Submit;
	
	public void clickAddcustomer()
	{
		linkAddCustomer.click();
	}
	public void NewCustName(String CustName)
	{
		CustomerName.sendKeys(CustName);
	}
	public void NewCustGender(String NcFemale)
	{
		Gender.sendKeys(NcFemale);
	}
	public void NewCustDOB(String mm,String dd,String yy)
	{
		DataofBirth.sendKeys(mm);
		DataofBirth.sendKeys(dd);
		DataofBirth.sendKeys(yy);
		
	}
	public void NewCustAddress(String Custaddress)
	{
		Address.sendKeys(Custaddress);
	}
	public void NewCustCity(String NcCity)
	{
		City.sendKeys(NcCity);
	}
	public void NewCustState(String NCstate)
	{
		State.sendKeys(NCstate);
	}
	public void NewCustPincode(String NcPincode)
	{
		Pincode.sendKeys(String.valueOf(NcPincode));
	}
	public void NewCustTelephn(String Nctelephone)
	{
		telephoneNo.sendKeys(String.valueOf(Nctelephone));
	}
	public void NewCustEmail(String NcEmail)
	{
		Email.sendKeys(NcEmail);
	}
	public void NewCustSubmit()
	{
		Submit.click();
	}
	

}
