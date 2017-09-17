/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.openqa.selenium.By
 *  org.openqa.selenium.WebElement
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_AnyType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface I_FW_Functions {
    public void launch(String var1);

    public void executeJS(String var1);

    public void overrideLink();

    public boolean isAlertPresent();

    public void waitForElement(By var1, String var2, Integer var3);

    public void waitForElementToDisappear(By var1, String var2, Integer var3);

    public void closeAllButMainWin();

    public void captureWebElementImage(WebElement var1, String var2, String var3);

    public void captureScreenshot(String var1, String var2);

    public void linkScreenShotsToHTMLReport(String var1);

    public boolean VerifySafely(String var1, FW_AnyType<?> var2, FW_AnyType<?> var3);

    public boolean VerifyPartial(String var1, FW_AnyType<?> var2, FW_AnyType<?> var3);
}

