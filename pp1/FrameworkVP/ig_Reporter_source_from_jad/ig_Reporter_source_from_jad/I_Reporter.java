// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   I_Reporter.java

package com.igate.features.Reporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface I_Reporter
{

    public abstract void setAuthorInfo(String s);

    public abstract void setTestCaseReqCoverage(String s);

    public abstract void setCurrentRunDescription(String s);

    public abstract void setWebDriver(WebDriver webdriver);

    public abstract void setIndexPageDescription(String s);

    public abstract void logMessage(String s, String s1, String s2);

    public abstract void logMessage(String s, String s1, String s2, String s3);

    public abstract void logMessage(String s, String s1, String s2, String s3, String s4);

    public abstract void logMessage(String s, String s1, String s2, String s3, String s4, String s5);

    public abstract void logMessage(String s, String s1, WebElement webelement);

    public abstract void logMessage(String s, String s1, String s2, WebElement webelement);

    public abstract void logMessage(String s, String s1, String s2, String s3, WebElement webelement);

    public abstract void logMessage(String s, String s1, String s2, String s3, String s4, WebElement webelement);
}
