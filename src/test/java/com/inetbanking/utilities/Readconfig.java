package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;//properties object
	
public Readconfig()
{
	File Src=new File("./Configuartion/config.properties");   //file location find place
	try
	{
		FileInputStream frs=new FileInputStream(Src);//file is input into stream read the data
		pro=new Properties();
		pro.load(frs);//load is load the complete the file
	}
	catch(Exception e) {
		System.out.println("Excepationis"+e.getMessage());
	}
}
public String setupbaseurl()
{
	String URl=pro.getProperty("baseurl");
	return URl;
	
}
public String SetupUsername()
{
	String Username=pro.getProperty("username");
	return Username;
}
public String SetupPassword()
{
	String Password=pro.getProperty("password");
	return Password;
}
public String SetupChromepath()
{
	String Chromepath=pro.getProperty("chromepath");
	return Chromepath;
}
public String Setupfirefoxpath()
{
	String Firefox=pro.getProperty("firefox");
	return Firefox;
}
public String SetupMicrosoftEdge()
{
	String MicrosoftEdge=pro.getProperty("microsoftEdge");
	return MicrosoftEdge;
}
}
