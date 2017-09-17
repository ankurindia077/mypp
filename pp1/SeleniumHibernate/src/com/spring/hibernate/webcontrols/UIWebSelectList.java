package com.spring.hibernate.webcontrols;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.spring.hibernate.webinterface.IWebSelectList;

public class UIWebSelectList implements IWebSelectList{

	private WebElement _selectlist;
	Select _selectElements;
	
	public UIWebSelectList(WebElement selectlist)
    {
        _selectlist = selectlist;
        _selectElements = new Select(selectlist);
    }

	@Override
	public void SelectByValue(String value) {
		try
        {
            if (_selectlist.isDisplayed())
                _selectElements.selectByValue(value);
            else
            	throw new ElementNotInteractableException("Element not found");
        }
		catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	public void SelectByIndex(int id) {
		try
        {
            if (_selectlist.isDisplayed()) 
            	_selectElements.selectByIndex(id);
            else 
            	throw new ElementNotInteractableException("Element not found");
        }
		catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }	
	}

	@Override
	public void SelectByText(String value) {
		try
        {
           if (_selectlist.isDisplayed()) 
           	  _selectElements.selectByVisibleText(value);
           else 
          	  throw new ElementNotInteractableException("Element not found");
        }
		catch(Exception e)
	    {
	    	System.out.println("Warning: Exception thrown");
		   	throw new ElementNotInteractableException("Element not found");
	    }
	}

	@Override
	public String Style() {
        try
        {
           if (_selectlist.isDisplayed()) 
              return _selectlist.getAttribute("Style").toString();
           else 
              throw new ElementNotInteractableException("Element not found");
        }
        catch(Exception e)
   	    {
        	System.out.println("Warning: Exception thrown");
   		    throw new ElementNotInteractableException("Element not found");
   	    }
	}

	@Override
	public String SelectedItem() {
        try
        {
           if (_selectlist.isDisplayed()) 
               return _selectElements.getFirstSelectedOption().getText();
           else 
               throw new ElementNotInteractableException("Element not found");
        }
        catch(Exception e)
      	{
      	    System.out.println("Warning: Exception thrown");
      		throw new ElementNotInteractableException("Element not found");
      	 }
	}

	@Override
	public boolean HasSelectedItems() {
        try
        {
            return _selectElements.getFirstSelectedOption().isSelected();
        }
        catch(Exception e)
	    {
	       	System.out.println("Warning: Exception thrown");
		    throw new ElementNotInteractableException("Element not found");
	    }
	}

	@Override
	public boolean Enabled() {
		return _selectlist.isEnabled();
	}

	@Override
	public boolean IsVisible() {
		return _selectlist.isDisplayed();
	}
	
}
