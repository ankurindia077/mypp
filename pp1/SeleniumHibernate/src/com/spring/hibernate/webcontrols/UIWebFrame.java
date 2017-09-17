package com.spring.hibernate.webcontrols;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.spring.hibernate.webinterface.IWebButton;
import com.spring.hibernate.webinterface.IWebFrame;
import com.spring.hibernate.webinterface.IWebImage;
import com.spring.hibernate.webinterface.IWebLink;
import com.spring.hibernate.webinterface.IWebRadioButton;
import com.spring.hibernate.webinterface.IWebSelectList;
import com.spring.hibernate.webinterface.IWebTable;
import com.spring.hibernate.webinterface.IWebTextBox;

public class UIWebFrame implements IWebFrame{
	
	private WebDriver _frame;
	
	 public UIWebFrame(WebDriver frame)
     {
         _frame = frame;
     }

	@Override
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
	public IWebLink GetLinkByText(String locatorPath) {
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
	public IWebButton GetButtonByValue(String locatorPath) {
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
	public IWebRadioButton GetRadioButtonById(String locatorPath) {
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
	public IWebRadioButton GetRadioButtonByNameAndValue(String locatorPathName,String locatorPathValue) {
        try
        {                
        	List<WebElement> elements = getAllElementsByAnyLocator(locatorPathName);
        	IWebRadioButton iWebRadioButton = null;
            for(WebElement element:elements)
            {
                if (element.getAttribute("value") == locatorPathValue)
                {
                	iWebRadioButton =  (IWebRadioButton) new UIWebRadioButton(element);
                }                   
            }
            
            return iWebRadioButton;
        }
        catch(Exception e)
	     {
	        throw new ElementNotInteractableException("Element not found");
	     }
	}

	@Override
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
	public void RightClickOnElement(String locatorPath) {
		try
		{
			WebElement webElement = null;
			webElement = GetElement(locatorPath);
			Actions actions = new Actions(_frame);
			actions.moveToElement(webElement);
			actions.contextClick(webElement).build().perform();
		}
		catch(Exception e)
        {
           	System.out.println("Warning: Exception thrown");
    	    throw new ElementNotInteractableException("Element not found");
        }	 
		
	}

	private WebElement GetElement(String locatorPath) {
		try{
		if (locatorPath.startsWith("css_")) {
			String s = locatorPath.replace("css_", "");
			return _frame.findElement(By.cssSelector(s));
		} else if (locatorPath.startsWith("xpath_")) {
			return _frame.findElement(By.xpath(locatorPath.replace("xpath_", "")));
		} else if (locatorPath.startsWith("id_")) {
			return _frame.findElement(By.id(locatorPath.replace("id_", "")));
		} else if (locatorPath.startsWith("name_")) {
			return _frame.findElement(By.name(locatorPath.replace("name_", "")));
		} else if (locatorPath.startsWith("link_")) {
			return _frame.findElement(By.linkText(locatorPath.replace("link_", "")));
		} else if (locatorPath.startsWith("partiallink_")) {
			return _frame.findElement(By.partialLinkText(locatorPath.replace("partiallink_", "")));
		} else if (locatorPath.startsWith("class_")) {
			return _frame.findElement(By.xpath(locatorPath.replace("class_", "")));
		} else if (locatorPath.startsWith("tag_")) {
			return _frame.findElement(By.tagName(locatorPath.replace("tag_", "")));
		} else
			return null; }
		catch (Exception e) {
			return null;
		}
	}
	
	private List<WebElement> getAllElementsByAnyLocator(String locatorPath) {
		try{
		if (locatorPath.startsWith("css_")) {
			String s = locatorPath.replace("css_", "");
			return _frame.findElements(By.cssSelector(s));
		} else if (locatorPath.startsWith("xpath_")) {
			return _frame.findElements(By.xpath(locatorPath.replace("xpath_", "")));
		} else if (locatorPath.startsWith("id_")) {
			return _frame.findElements(By.id(locatorPath.replace("id_", "")));
		} else if (locatorPath.startsWith("name_")) {
			return _frame.findElements(By.name(locatorPath.replace("name_", "")));
		} else if (locatorPath.startsWith("link_")) {
			return _frame.findElements(By.linkText(locatorPath.replace("link_", "")));
		} else if (locatorPath.startsWith("partiallink_")) {
			return _frame.findElements(By.partialLinkText(locatorPath.replace("partiallink_", "")));
		} else if (locatorPath.startsWith("class_")) {
			return _frame.findElements(By.xpath(locatorPath.replace("class_", "")));
		} else if (locatorPath.startsWith("tag_")) {
			return _frame.findElements(By.tagName(locatorPath.replace("tag_", "")));
		} else
			return null;}
		catch (Exception e) {
			return null;
		}
	}
}
