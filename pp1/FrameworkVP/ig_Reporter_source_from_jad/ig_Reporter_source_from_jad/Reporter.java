// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Reporter.java

package com.igate.features.Reporter;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Referenced classes of package com.igate.features.Reporter:
//            I_Reporter

public class Reporter
    implements I_Reporter
{

    public Reporter()
    {
    }

    public void setAuthorInfo(String author)
    {
        ATUReports.setAuthorInfo(author, Utils.getCurrentTime(), "5.1.1");
    }

    public void setTestCaseReqCoverage(String coverage)
    {
        ATUReports.setTestCaseReqCoverage(coverage);
    }

    public void setCurrentRunDescription(String runDescription)
    {
        ATUReports.currentRunDescription = runDescription;
    }

    public void setWebDriver(WebDriver driver)
    {
        ATUReports.setWebDriver(driver);
    }

    public void setIndexPageDescription(String description)
    {
        ATUReports.indexPageDescription = description;
    }

    public void logMessage(String message, String logAs, String screenshot)
    {
        ATUReports.add(message, LogAs.valueOf(logAs), new CaptureScreen(atu.testng.selenium.reports.CaptureScreen.ScreenshotOf.valueOf(screenshot)));
    }

    public void logMessage(String message, String inputValue, String logAs, String screenshot)
    {
        ATUReports.add(message, inputValue, LogAs.valueOf(logAs), new CaptureScreen(atu.testng.selenium.reports.CaptureScreen.ScreenshotOf.valueOf(screenshot)));
    }

    public void logMessage(String message, String expected, String actual, String logAs, String screenshot)
    {
        ATUReports.add(message, expected, actual, LogAs.valueOf(logAs), new CaptureScreen(atu.testng.selenium.reports.CaptureScreen.ScreenshotOf.valueOf(screenshot)));
    }

    public void logMessage(String message, String inputValue, String expected, String actual, String logAs, String screenshot)
    {
        ATUReports.add(message, inputValue, expected, actual, LogAs.valueOf(logAs), new CaptureScreen(atu.testng.selenium.reports.CaptureScreen.ScreenshotOf.valueOf(screenshot)));
    }

    public void logMessage(String message, String logAs, WebElement screenshot)
    {
        ATUReports.add(message, LogAs.valueOf(logAs), new CaptureScreen(screenshot));
    }

    public void logMessage(String message, String inputValue, String logAs, WebElement screenshot)
    {
        ATUReports.add(message, inputValue, LogAs.valueOf(logAs), new CaptureScreen(screenshot));
    }

    public void logMessage(String message, String expected, String actual, String logAs, WebElement screenshot)
    {
        ATUReports.add(message, expected, actual, LogAs.valueOf(logAs), new CaptureScreen(screenshot));
    }

    public void logMessage(String message, String inputValue, String expected, String actual, String logAs, WebElement screenshot)
    {
        ATUReports.add(message, inputValue, expected, actual, LogAs.valueOf(logAs), new CaptureScreen(screenshot));
    }
}
