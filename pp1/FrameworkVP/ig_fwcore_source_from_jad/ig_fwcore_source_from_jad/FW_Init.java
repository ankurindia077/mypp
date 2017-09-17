// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_Init.java

package com.test.auto.fw_core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

// Referenced classes of package com.test.auto.fw_core:
//            FW_PropertyReader, FW_Enums

public class FW_Init
{

    public FW_Init()
    {
        fw_PropertyReader = new FW_PropertyReader();
        logger.debug((new StringBuilder("[FW_Init()] Working directory: ")).append(System.getProperty("user.dir")).toString());
        setWorkingDir(System.getProperty("user.dir"));
        setMobiletool(FW_Enums.mobiletool.valueOf(fw_PropertyReader.getFWXProperty("MOBILE_TOOL")));
        setPlatform(FW_Enums.platform.valueOf(fw_PropertyReader.getFWXProperty("PLATFORM")));
        setBrowser(FW_Enums.browser.valueOf(fw_PropertyReader.getFWXProperty("BROWSER")));
        setApptype(FW_Enums.apptype.valueOf(fw_PropertyReader.getFWXProperty("APP_TYPE")));
        setMainWindow("");
        setWizardParentWindow("");
        setWizardChildWindow("");
    }

    public String getMainWindow()
    {
        return mainWindow;
    }

    public String getWizardParentWindow()
    {
        return wizardParentWindow;
    }

    public String getWizardChildWindow()
    {
        return wizardChildWindow;
    }

    public FW_Enums.mobiletool getMobiletool()
    {
        return mobiletool;
    }

    public FW_Enums.platform getPlatform()
    {
        return platform;
    }

    public FW_Enums.apptype getApptype()
    {
        return apptype;
    }

    public FW_Enums.browser getBrowser()
    {
        return browser;
    }

    public String getWorkingDir()
    {
        return workingDir;
    }

    public void setMainWindow(String mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    public void setWizardParentWindow(String wizardParentWindow)
    {
        this.wizardParentWindow = wizardParentWindow;
    }

    public void setWizardChildWindow(String wizardChildWindow)
    {
        this.wizardChildWindow = wizardChildWindow;
    }

    public void setMobiletool(FW_Enums.mobiletool mobiletool)
    {
        this.mobiletool = mobiletool;
    }

    public void setPlatform(FW_Enums.platform platform)
    {
        this.platform = platform;
    }

    public void setApptype(FW_Enums.apptype apptype)
    {
        this.apptype = apptype;
    }

    public void setBrowser(FW_Enums.browser browser)
    {
        this.browser = browser;
    }

    public void setWorkingDir(String workingDir)
    {
        this.workingDir = workingDir;
    }

    private String workingDir;
    private String mainWindow;
    private String wizardParentWindow;
    private String wizardChildWindow;
    private FW_Enums.mobiletool mobiletool;
    private FW_Enums.platform platform;
    private FW_Enums.apptype apptype;
    private FW_Enums.browser browser;
    FW_PropertyReader fw_PropertyReader;
    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_Init.getName());

}
