package com.cucumberFramework.helper;

import org.apache.log4j.PropertyConfigurator;

import com.cucumberFramework.utlity.ResourceHelper;

import org.apache.log4j.Logger;
public class LoggerHelper {
	private static boolean root = false;

	public static Logger getLogger(Class clas){
		if (root) {
			return Logger.getLogger(clas);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
	
	public static void main(String[] args) {
		Logger log = Logger.getLogger(LoggerHelper.class);
	    log.info("I am Logger Boy");
	    log.info("I am Logger Boy");
	    log.info("I am Logger Boy");
	}
}
