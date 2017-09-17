/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  atu.testng.reports.ATUReports
 *  atu.testng.reports.logging.LogAs
 *  atu.testng.reports.utils.Utils
 *  atu.testng.selenium.reports.CaptureScreen
 *  atu.testng.selenium.reports.CaptureScreen$ScreenshotOf
 *  org.openqa.selenium.WebDriver
 *  org.openqa.selenium.WebElement
 */
package com.igate.features.Reporter;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import com.igate.features.Reporter.I_Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reporter
implements I_Reporter {
    @Override
    public void setAuthorInfo(String author) {
        ATUReports.setAuthorInfo((String)author, (String)Utils.getCurrentTime(), (String)"5.1.1");
    }

    @Override
    public void setTestCaseReqCoverage(String coverage) {
        ATUReports.setTestCaseReqCoverage((String)coverage);
    }

    @Override
    public void setCurrentRunDescription(String runDescription) {
        ATUReports.currentRunDescription = runDescription;
    }

    @Override
    public void setWebDriver(WebDriver driver) {
        ATUReports.setWebDriver((WebDriver)driver);
    }

    @Override
    public void setIndexPageDescription(String description) {
        ATUReports.indexPageDescription = description;
    }

    @Override
    public void logMessage(String message, String logAs, String screenshot) {
        ATUReports.add((String)message, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(CaptureScreen.ScreenshotOf.valueOf((String)screenshot)));
    }

    @Override
    public void logMessage(String message, String inputValue, String logAs, String screenshot) {
        ATUReports.add((String)message, (String)inputValue, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(CaptureScreen.ScreenshotOf.valueOf((String)screenshot)));
    }

    @Override
    public void logMessage(String message, String expected, String actual, String logAs, String screenshot) {
        ATUReports.add((String)message, (String)expected, (String)actual, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(CaptureScreen.ScreenshotOf.valueOf((String)screenshot)));
    }

    @Override
    public void logMessage(String message, String inputValue, String expected, String actual, String logAs, String screenshot) {
        ATUReports.add((String)message, (String)inputValue, (String)expected, (String)actual, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(CaptureScreen.ScreenshotOf.valueOf((String)screenshot)));
    }

    @Override
    public void logMessage(String message, String logAs, WebElement screenshot) {
        ATUReports.add((String)message, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(screenshot));
    }

    @Override
    public void logMessage(String message, String inputValue, String logAs, WebElement screenshot) {
        ATUReports.add((String)message, (String)inputValue, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(screenshot));
    }

    @Override
    public void logMessage(String message, String expected, String actual, String logAs, WebElement screenshot) {
        ATUReports.add((String)message, (String)expected, (String)actual, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(screenshot));
    }

    @Override
    public void logMessage(String message, String inputValue, String expected, String actual, String logAs, WebElement screenshot) {
        ATUReports.add((String)message, (String)inputValue, (String)expected, (String)actual, (LogAs)LogAs.valueOf((String)logAs), (CaptureScreen)new CaptureScreen(screenshot));
    }
}

