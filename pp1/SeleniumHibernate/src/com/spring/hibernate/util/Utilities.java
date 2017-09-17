package com.spring.hibernate.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class Utilities {
	
	private static Logger APP_LOGS = null;
	private static Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(Utilities.class.getName());
		return APP_LOGS;	
	}
	
	
	/**
	 *******************************************************************************************
	 * Converts StackTrace generated at time of Exception thrown into Message String format.
	 * @param throwable This is Exception thrown.
	 * @return String This is Exception message in String format.
	 *******************************************************************************************
	 */
	public static String getStackTrace(final Throwable throwable) {
	  try{
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	  }
	  catch (Exception e){
			setLogger().error(" Exception thrown -- " + getStackTrace(e));
			Assert.assertTrue(false, e.getMessage());
			return null;
	  }
	}
	
	
	public static void setLogFileName() {
		System.out.println("Inside before");
		String path1=System.getProperty("user.dir")+"\\target\\logs\\";
		System.out.println(path1);
		String path2 = new PropertyReader().readProperty("logfile1"); 
		System.out.println(path2);
		System.setProperty("logfile.name",path1+path2+".html"); 
	}
	

}
