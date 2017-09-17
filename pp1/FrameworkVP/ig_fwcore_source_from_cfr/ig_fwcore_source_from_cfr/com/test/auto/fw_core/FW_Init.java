/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_Enums;
import com.test.auto.fw_core.FW_PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FW_Init {
    private String workingDir;
    private String mainWindow;
    private String wizardParentWindow;
    private String wizardChildWindow;
    private FW_Enums.mobiletool mobiletool;
    private FW_Enums.platform platform;
    private FW_Enums.apptype apptype;
    private FW_Enums.browser browser;
    FW_PropertyReader fw_PropertyReader = new FW_PropertyReader();
    private static Logger logger = LogManager.getLogger((String)FW_Init.class.getName());

    public FW_Init() {
        logger.debug((Object)("[FW_Init()] Working directory: " + System.getProperty("user.dir")));
        this.setWorkingDir(System.getProperty("user.dir"));
        this.setMobiletool(FW_Enums.mobiletool.valueOf(this.fw_PropertyReader.getFWXProperty("MOBILE_TOOL")));
        this.setPlatform(FW_Enums.platform.valueOf(this.fw_PropertyReader.getFWXProperty("PLATFORM")));
        this.setBrowser(FW_Enums.browser.valueOf(this.fw_PropertyReader.getFWXProperty("BROWSER")));
        this.setApptype(FW_Enums.apptype.valueOf(this.fw_PropertyReader.getFWXProperty("APP_TYPE")));
        this.setMainWindow("");
        this.setWizardParentWindow("");
        this.setWizardChildWindow("");
    }

    public String getMainWindow() {
        return this.mainWindow;
    }

    public String getWizardParentWindow() {
        return this.wizardParentWindow;
    }

    public String getWizardChildWindow() {
        return this.wizardChildWindow;
    }

    public FW_Enums.mobiletool getMobiletool() {
        return this.mobiletool;
    }

    public FW_Enums.platform getPlatform() {
        return this.platform;
    }

    public FW_Enums.apptype getApptype() {
        return this.apptype;
    }

    public FW_Enums.browser getBrowser() {
        return this.browser;
    }

    public String getWorkingDir() {
        return this.workingDir;
    }

    public void setMainWindow(String mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void setWizardParentWindow(String wizardParentWindow) {
        this.wizardParentWindow = wizardParentWindow;
    }

    public void setWizardChildWindow(String wizardChildWindow) {
        this.wizardChildWindow = wizardChildWindow;
    }

    public void setMobiletool(FW_Enums.mobiletool mobiletool2) {
        this.mobiletool = mobiletool2;
    }

    public void setPlatform(FW_Enums.platform platform2) {
        this.platform = platform2;
    }

    public void setApptype(FW_Enums.apptype apptype2) {
        this.apptype = apptype2;
    }

    public void setBrowser(FW_Enums.browser browser2) {
        this.browser = browser2;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }
}

