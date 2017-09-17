/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.openqa.selenium.WebDriver
 *  org.openqa.selenium.WebElement
 */
package com.igate.features.Reporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface I_Reporter {
    public void setAuthorInfo(String var1);

    public void setTestCaseReqCoverage(String var1);

    public void setCurrentRunDescription(String var1);

    public void setWebDriver(WebDriver var1);

    public void setIndexPageDescription(String var1);

    public void logMessage(String var1, String var2, String var3);

    public void logMessage(String var1, String var2, String var3, String var4);

    public void logMessage(String var1, String var2, String var3, String var4, String var5);

    public void logMessage(String var1, String var2, String var3, String var4, String var5, String var6);

    public void logMessage(String var1, String var2, WebElement var3);

    public void logMessage(String var1, String var2, String var3, WebElement var4);

    public void logMessage(String var1, String var2, String var3, String var4, WebElement var5);

    public void logMessage(String var1, String var2, String var3, String var4, String var5, WebElement var6);
}

