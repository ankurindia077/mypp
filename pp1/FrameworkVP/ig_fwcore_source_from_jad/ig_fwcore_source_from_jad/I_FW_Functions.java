// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   I_FW_Functions.java

package com.test.auto.fw_core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Referenced classes of package com.test.auto.fw_core:
//            FW_AnyType

public interface I_FW_Functions
{

    public abstract void launch(String s);

    public abstract void executeJS(String s);

    public abstract void overrideLink();

    public abstract boolean isAlertPresent();

    public abstract void waitForElement(By by, String s, Integer integer);

    public abstract void waitForElementToDisappear(By by, String s, Integer integer);

    public abstract void closeAllButMainWin();

    public abstract void captureWebElementImage(WebElement webelement, String s, String s1);

    public abstract void captureScreenshot(String s, String s1);

    public abstract void linkScreenShotsToHTMLReport(String s);

    public abstract boolean VerifySafely(String s, FW_AnyType fw_anytype, FW_AnyType fw_anytype1);

    public abstract boolean VerifyPartial(String s, FW_AnyType fw_anytype, FW_AnyType fw_anytype1);
}
