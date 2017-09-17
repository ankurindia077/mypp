package com.spring.hibernate.webinterface;

import org.openqa.selenium.WebElement;

public interface IWebBrowser {
	
    void OpenApplication(String url);
    void Wait();
    void AcceptAlert();
    void DismissAlert();
    void CloseBrowser();
    void CloseAllBrowsers();
    void SetFocus();
    void WaitForElement(String xPath);
    void WaitForElementToHaveValue(String locatorPath);
    void RightClickOnElement(String locatorPath);
    void ScrollAndClick(WebElement element);
    
    String Title();
    String CurrentWindowHandle();
    
    IWebBrowser AttachPage(String pageName,boolean useExactPageName, int numberOfWindows);
    IWebBrowser SwitchToBrowserWindow(String windowHandle);
    
    IWebTextBox GetTextBoxById(String locatorPath);
    IWebTextBox GetTextBoxByName(String locatorPath);

    IWebButton GetButtonByName(String locatorPath);
    IWebButton GetButtonById(String locatorPath);

    IWebLink GetLinkByID(String id);
    IWebLink GetLinkByName(String name);

    IWebFrame GetFrameByName(String name);
    IWebFrame GetFrameByID(int id);

    IWebSelectList GetSelectListById(String locatorPath);
    IWebSelectList GetSelectListByName(String locatorPath);

    IWebImage GetImageByID(String locatorPath);
    IWebImage GetImageByName(String locatorPath);

    IWebRadioButton GetRadioButtonByName(String locatorPath);

    IWebTable GetTableById(String locatorPath);
    
    IWebCheckBox GetCheckBoxById(String locatorPath);

}
