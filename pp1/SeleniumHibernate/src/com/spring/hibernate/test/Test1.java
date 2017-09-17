package com.spring.hibernate.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.spring.hibernate.util.Utilities;
import com.spring.hibernate.webcontrols.UIWebBrowser;
import com.spring.hibernate.webinterface.IWebBrowser;


public class Test1 {

	private static Logger APP_LOGS = null;
	
	private static Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(Test1.class.getName());
		return APP_LOGS;	
	}
	
	
	public static void main(String[] args	) {
		Utilities.setLogFileName();
		setLogger().info("Reached 11111111111111");
		IWebBrowser browser = UIWebBrowser.OpenBrowser("chrome");
		browser.OpenApplication("https://www.google.co.in");
		browser.CloseAllBrowsers();
		setLogger().info("Reached Here");
		

	}

}
