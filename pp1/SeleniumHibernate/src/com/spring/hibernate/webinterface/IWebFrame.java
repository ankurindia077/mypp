package com.spring.hibernate.webinterface;

public interface IWebFrame {
	
    IWebImage GetImageByID(String locatorPath);
    
    IWebTextBox GetTextBoxByName(String locatorPath);
    
    IWebLink GetLinkByText(String locatorPath);
    IWebLink GetLinkByID(String locatorPath);
    
    IWebButton GetButtonByValue(String locatorPath);
    
    IWebRadioButton GetRadioButtonById(String locatorPath);
    IWebRadioButton GetRadioButtonByName(String locatorPath);
    IWebRadioButton GetRadioButtonByNameAndValue(String locatorPathName,String locatorPathValue);

    IWebSelectList GetSelectListById(String locatorPath);
    
    IWebTable GetTableById(String locatorPath);
    
    void RightClickOnElement(String locatorPath);
    
}
