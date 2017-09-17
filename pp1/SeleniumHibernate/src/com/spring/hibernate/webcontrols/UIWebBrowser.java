package com.spring.hibernate.webcontrols;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spring.hibernate.webinterface.IWebBrowser;
import com.spring.hibernate.webinterface.IWebButton;
import com.spring.hibernate.webinterface.IWebCheckBox;
import com.spring.hibernate.webinterface.IWebFrame;
import com.spring.hibernate.webinterface.IWebImage;
import com.spring.hibernate.webinterface.IWebLink;
import com.spring.hibernate.webinterface.IWebRadioButton;
import com.spring.hibernate.webinterface.IWebSelectList;
import com.spring.hibernate.webinterface.IWebTable;
import com.spring.hibernate.webinterface.IWebTextBox;

public class UIWebBrowser implements IWebBrowser
{

	private WebDriver _browser = null;
	private int seleniumTimeOutInterval = 30;
    private int maxTimeOut = 5000;
    private int waitTimeInterval = 500;
    
	public UIWebBrowser(WebDriver browser)
    {
         _browser = browser;
    }
	
	public static IWebBrowser OpenBrowser(String browserType)
    {
        try
        {
        	System.setProperty("webdriver.gecko.driver", "D:/Data/libs/geckodriver-v0.14.0-win64/geckodriver.exe");
        	
            WebDriver driver = null;

            if (browserType == "firefox") 
            	driver = new FirefoxDriver();
            else if (browserType == "chrome")
            {
            	ChromeOptions options = new ChromeOptions();
            	options.addArguments("chrome.switches","--disable-extensions");
            	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				driver = new ChromeDriver(options);
            }
            else if (browserType == "ie")
            {
            	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
    			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
    			caps.setCapability("ignoreZoomSetting", true);
    			driver = new InternetExplorerDriver(caps);
            	
            	
            }
            return new UIWebBrowser(driver);
        }
        catch(Exception e)
        {
       	 	 System.out.println("Warning: Exception thrown");
	       	 throw new ElementNotInteractableException("Element not found");
        }

    }

	@Override
	/// To launch the application 
	public void OpenApplication(String url) {
		try
		 {
			 _browser.navigate().to(url);
			 _browser.manage().window().maximize();
         }
		 catch(Exception e)
         {
        	 System.out.println("Warning: Exception thrown");
 	       	 throw new ElementNotInteractableException("Element not found");
         }
	}

	@Override
	/// To Wait for page to load
	public void Wait() {
		try{
		  WebDriverWait wait = new WebDriverWait(_browser, seleniumTimeOutInterval);
		  wait.until(new ExpectedCondition<Boolean>()
		  {
			  public Boolean apply(WebDriver d) {
			  JavascriptExecutor js = (JavascriptExecutor) d;
			  return (Boolean)js.executeScript("return document.readyState").equals("complete");
			  }});
		}
		catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// Click OK button in alert box
	public void AcceptAlert() {
            try
            {
            	Alert alert = _browser.switchTo().alert();
                alert.accept();
            }
            catch(Exception e)
            {
           	 	System.out.println("Warning: Exception thrown");
    	       	throw new ElementNotInteractableException("Element not found");
            }
       
	}

	@Override
	/// Click Cancel button in alert box
	public void DismissAlert() {
	        try
	        {
	            Alert alert = _browser.switchTo().alert();
	            alert.dismiss();
	        }
	        catch(Exception e)
	        {
	           	System.out.println("Warning: Exception thrown");
	    	    throw new ElementNotInteractableException("Element not found");
	        }	      	
	}

	@Override
	/// The CloseBrowser method to close the current browser
	public void CloseBrowser() {
		_browser.close();
	}

	@Override
	/// The CloseBrowser method to close all the open browsers
	public void CloseAllBrowsers() {
		_browser.quit();	
	}

	@Override
	/// The SetFocus method to set focus on the browser
	public void SetFocus() {
		_browser.manage().window().maximize();
	}

	@Override
	/// WaitForElement method to wait until element is visible
	public void WaitForElement(String xPath) {
		try{
		 WebDriverWait wait = new WebDriverWait(_browser, seleniumTimeOutInterval);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
		}
		catch(Exception e)
        {
           	System.out.println("Warning: Exception thrown");
    	    throw new ElementNotInteractableException("Element not found");
        }	 	
	}

	@Override
	/// WaitForElementToHaveValue method to wait until element is having value
	public void WaitForElementToHaveValue(String locatorPath) {
		try
        {
            WebElement webElement = null;
            for (int timeOut = 0; timeOut < 4*maxTimeOut; timeOut = timeOut + waitTimeInterval)
            {
                webElement = GetElement(locatorPath);
                if (webElement.getAttribute("value") == null)
                {                                              
                    return;
                }
                else
                {
                    Thread.sleep(waitTimeInterval);
                }
            }
        }
		catch(Exception e)
        {
           	System.out.println("Warning: Exception thrown");
    	    throw new ElementNotInteractableException("Element not found");
        }	 
		
	}

	@Override
	/// The RightClickOnElement method to right click on the element
	public void RightClickOnElement(String locatorPath) {
		try
		{
			WebElement webElement = null;
			webElement = GetElement(locatorPath);
			Actions actions = new Actions(_browser);
			actions.moveToElement(webElement);
			actions.contextClick(webElement).build().perform();
		}
		catch(Exception e)
        {
           	System.out.println("Warning: Exception thrown");
    	    throw new ElementNotInteractableException("Element not found");
        }	 
	}

	@Override
	/// This method is used to scroll and click a webelement
	public void ScrollAndClick(WebElement element) {
		try
        {
            //moving to Element location
            Actions actions = new Actions(_browser);
            actions.moveToElement(element).perform();
            Thread.sleep(waitTimeInterval);
            //Click at that location			  
            ((JavascriptExecutor)_browser).executeScript("arguments[0].click();", element);
        }
		catch(Exception e)
        {
           	System.out.println("Warning: Exception thrown");
    	    throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// To get the browser title
	public String Title() {
		return _browser.getTitle();
	}

	@Override
	/// The CurrentWindowHandle property to get current window handle to switch browser windows
	public String CurrentWindowHandle() {
		return _browser.getWindowHandle();
	}
    
	@Override
	// Use exact page name to attach browser
	public IWebBrowser AttachPage(String pageTitle, boolean useExactPageName, int numberOfWindows) {
		 try
         {
			 _browser.switchTo().defaultContent();
			 IWebBrowser iWebBrowser = null;
             WebDriverWait wait = new WebDriverWait(_browser, seleniumTimeOutInterval);
             wait.until(numberOfWindowsToBe(numberOfWindows));
          
             Set<String> availableWindows = _browser.getWindowHandles();
             
             for (int timeOutIndex = 0; timeOutIndex < maxTimeOut; timeOutIndex = timeOutIndex + waitTimeInterval)
             {
            	 for (String window : availableWindows)
                 {
                     if (useExactPageName)
                     {
                         if (_browser.switchTo().window(window).getTitle() == pageTitle)
                         {
                        	 iWebBrowser = new UIWebBrowser(_browser.switchTo().window(window));
                         }
                     }
                     else
                     {
                         if (_browser.switchTo().window(window).getTitle().contains(pageTitle))
                         {
                        	 iWebBrowser =  new UIWebBrowser(_browser.switchTo().window(window));
                         }
                     }
                 }
                 Thread.sleep(waitTimeInterval);
             }
             
             return iWebBrowser;
             
         }
		 catch(Exception e)
		 {
	        	System.out.println("Warning: Exception thrown");
	        	throw new ElementNotInteractableException("Element not found");
	        	
	        }
		
	}

	@Override
	/// The SwitchToBrowserWindow method to switch between windows
	public IWebBrowser SwitchToBrowserWindow(String windowHandle) {
		try
		{
			return new UIWebBrowser(_browser.switchTo().window(windowHandle));
		}
		catch(Exception e){
	       	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
	    }
	}

	@Override
	/// The GetTextBoxById method to get IWebTextBox using Automation Id
	public IWebTextBox GetTextBoxById(String locatorPath) {
		try
        {
            return (IWebTextBox) new UIWebTextBox(GetElement(locatorPath));
        }
		catch(Exception e)
        {
        	throw new ElementNotInteractableException("Element not found");
        }
		
	}

	@Override
	/// The GetTextBoxByName method to get IWebTextBox using name
	public IWebTextBox GetTextBoxByName(String locatorPath) {
		try
        {
            return (IWebTextBox) new UIWebTextBox(GetElement(locatorPath));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// The GetButtonByName method to get IWebButton using its name
	public IWebButton GetButtonByName(String locatorPath) {
		 try
         {
             return (IWebButton) new UIWebButton(GetElement(locatorPath));
         }
		 catch(Exception e)
         {
        	 throw new ElementNotInteractableException("Element not found");
         }
	}

	@Override
	/// The GetButtonById method to get IWebButton using its id
	public IWebButton GetButtonById(String locatorPath) {
		try
        {
            return (IWebButton) new UIWebButton(GetElement(locatorPath));
        }
		 catch(Exception e)
        {
       	 throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// The GetLinkByID method to get IWebLink using its id
	public IWebLink GetLinkByID(String locatorPath) {
		try
        {
            return (IWebLink) new UIWebLink(GetElement(locatorPath));
        }
		catch(Exception e)
		{ 
        	 throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// The GetLinkByName method to get IWebLinkn using its name
	public IWebLink GetLinkByName(String locatorPath) {
		try
        {
            return (IWebLink) new UIWebLink(GetElement(locatorPath));
        }
		catch(Exception e)
		{ 
        	 throw new ElementNotInteractableException("Element not found");
        }
	}
 
	@Override
	public IWebFrame GetFrameByName(String name) {
		try
        {
            return (IWebFrame) new UIWebFrame(GetFrameName(name));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
		
	}
 
	@Override
	/// The GetFrameByName method to get IWebFrame using its name
	public IWebFrame GetFrameByID(int id) {
		try
        {
            return (IWebFrame) new UIWebFrame(GetFrameID(id));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// The GetSelectListById method to get IWebSelectList using its id
	public IWebSelectList GetSelectListById(String locatorPath) {
		try
        {
            return (IWebSelectList) new UIWebSelectList(GetElement(locatorPath));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
		
	}

	@Override
	/// The GetSelectListByName method to get IWebSelectList using its id
	public IWebSelectList GetSelectListByName(String locatorPath) {
		try
        {
            return (IWebSelectList) new UIWebSelectList(GetElement(locatorPath));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// The GetImageByID method to get IWebImage using its id within Frame
	public IWebImage GetImageByID(String locatorPath) {
		try
        {
            return (IWebImage) new UIWebImage(GetElement(locatorPath));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// The GetImageByName method to get IWebImage using its name within Frame
	public IWebImage GetImageByName(String locatorPath) {
		try
        {
            return (IWebImage) new UIWebImage(GetElement(locatorPath));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	/// The GetRadioButtonByName method to get IWebRadioButton using its name
	public IWebRadioButton GetRadioButtonByName(String locatorPath) {
		 try
         {
             return (IWebRadioButton) new UIWebRadioButton(GetElement(locatorPath));
         }
		 catch(Exception e)
	     {
	        throw new ElementNotInteractableException("Element not found");
	     }
	}

	@Override
	/// The GetTableByID method to get IWebTable using its ID within Frame
	public IWebTable GetTableById(String locatorPath) {
		try
        {
            return (IWebTable) new UIWebTable(GetElement(locatorPath));
        }
		 catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	public IWebCheckBox GetCheckBoxById(String locatorPath) {
		try
        {
            return (IWebCheckBox) new UIWebCheckBox(GetElement(locatorPath));
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}
	
	private ExpectedCondition<Boolean> numberOfWindowsToBe(final int numberOfWindows) {
	    return new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	                driver.getWindowHandles();
	        return driver.getWindowHandles().size() == numberOfWindows;
	      }
	    };
	}
	
	private WebElement GetElement(String locatorPath) {
		try{
		if (locatorPath.startsWith("css_")) {
			String s = locatorPath.replace("css_", "");
			return _browser.findElement(By.cssSelector(s));
		} else if (locatorPath.startsWith("xpath_")) {
			return _browser.findElement(By.xpath(locatorPath.replace("xpath_", "")));
		} else if (locatorPath.startsWith("id_")) {
			return _browser.findElement(By.id(locatorPath.replace("id_", "")));
		} else if (locatorPath.startsWith("name_")) {
			return _browser.findElement(By.name(locatorPath.replace("name_", "")));
		} else if (locatorPath.startsWith("link_")) {
			return _browser.findElement(By.linkText(locatorPath.replace("link_", "")));
		} else if (locatorPath.startsWith("partiallink_")) {
			return _browser.findElement(By.partialLinkText(locatorPath.replace("partiallink_", "")));
		} else if (locatorPath.startsWith("class_")) {
			return _browser.findElement(By.xpath(locatorPath.replace("class_", "")));
		} else if (locatorPath.startsWith("tag_")) {
			return _browser.findElement(By.tagName(locatorPath.replace("tag_", "")));
		} else
			return null; }
		catch (Exception e) {
			return null;
		}
	}
	
	 private WebDriver GetFrameName(String name)
     {
		 _browser.switchTo().defaultContent();
		 _browser = null;
         for (int timeOut = 0; timeOut < maxTimeOut; timeOut = timeOut + waitTimeInterval)
         {
             try
             {
            	 _browser = _browser.switchTo().frame(name);
             }
             catch(Exception e)
             {
                 throw new ElementNotInteractableException("Element not found");
             }
         }
         
         return _browser;
        
     }
	 
	 private WebDriver GetFrameID(int id)
     {
		 _browser.switchTo().defaultContent();
		 _browser = null;
         for (int timeOut = 0; timeOut < maxTimeOut; timeOut = timeOut + waitTimeInterval)
         {
             try
             {
            	 _browser = _browser.switchTo().frame(id);
             }
             catch(Exception e)
             {
                 throw new ElementNotInteractableException("Element not found");
             }
         }
         
         return _browser;
     }
	 
}
