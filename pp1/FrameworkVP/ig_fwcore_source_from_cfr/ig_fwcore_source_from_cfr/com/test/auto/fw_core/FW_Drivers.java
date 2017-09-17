/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.cobra.ldtp.Ldtp
 *  com.experitest.selenium.MobileWebDriver
 *  io.appium.java_client.MobileDriver
 *  org.openqa.selenium.WebDriver
 */
package com.test.auto.fw_core;

import com.cobra.ldtp.Ldtp;
import com.experitest.selenium.MobileWebDriver;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

public class FW_Drivers {
    private static WebDriver driver;
    private static MobileDriver mDriver;
    private static MobileWebDriver cTestDriver;
    private static Ldtp ldtpDriver;

    public WebDriver getDriver() {
        return driver;
    }

    public MobileDriver getmDriver() {
        return mDriver;
    }

    public MobileWebDriver getcTestDriver() {
        return cTestDriver;
    }

    public Ldtp getLdtpDriver() {
        return ldtpDriver;
    }

    public void setDriver(WebDriver driver) {
        FW_Drivers.driver = driver;
    }

    public void setmDriver(MobileDriver mDriver) {
        FW_Drivers.mDriver = mDriver;
    }

    public void setcTestDriver(MobileWebDriver cTestDriver) {
        FW_Drivers.cTestDriver = cTestDriver;
    }

    public void setLdtpDriver(Ldtp ldtpDriver) {
        FW_Drivers.ldtpDriver = ldtpDriver;
    }
}

