package com.cucumberFramework.configreader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileRead {
	
	public static String getpropertiesValue(String filepath,String key){
		String value="";
		Properties ppt=new Properties();
		try
		{
			ppt.load(new FileInputStream(filepath));
			value=ppt.getProperty(key);
		}
		catch(Exception e)
		{
			System.out.println("Hi");
            e.printStackTrace();
		}
		return value;
	}
}
