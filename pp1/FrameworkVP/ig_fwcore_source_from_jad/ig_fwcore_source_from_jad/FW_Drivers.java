// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_Drivers.java

package com.test.auto.fw_core;

import com.cobra.ldtp.Ldtp;
import com.experitest.selenium.MobileWebDriver;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

public class FW_Drivers
{

    public FW_Drivers()
    {
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public MobileDriver getmDriver()
    {
        return mDriver;
    }

    public MobileWebDriver getcTestDriver()
    {
        return cTestDriver;
    }

    public Ldtp getLdtpDriver()
    {
        return ldtpDriver;
    }

    public void setDriver(WebDriver driver)
    {
        driver = driver;
    }

    public void setmDriver(MobileDriver mDriver)
    {
        mDriver = mDriver;
    }

    public void setcTestDriver(MobileWebDriver cTestDriver)
    {
        cTestDriver = cTestDriver;
    }

    public void setLdtpDriver(Ldtp ldtpDriver)
    {
        ldtpDriver = ldtpDriver;
    }

    private static WebDriver driver;
    private static MobileDriver mDriver;
    private static MobileWebDriver cTestDriver;
    private static Ldtp ldtpDriver;
}
