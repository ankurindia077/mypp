// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_TestPlan.java

package com.test.auto.fw_core;

import com.cobra.ldtp.Ldtp;
import com.cobra.ldtp.LdtpExecutionError;
import com.experitest.client.Client;
import com.experitest.selenium.MobileWebDriver;
import com.igate.features.Reporter.I_Reporter;
import com.igate.features.Reporter.Reporter;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.safari.SafariDriver;

// Referenced classes of package com.test.auto.fw_core:
//            FW_PropertyReader, FW_Init, FW_Drivers, FW_Const, 
//            FW_Functions, I_FW_Functions, FW_Enums

public class FW_TestPlan
{

    public FW_TestPlan()
    {
        fw_PropertyReader = new FW_PropertyReader();
        fw_Init = new FW_Init();
        fw_Drivers = new FW_Drivers();
        fw_Reporter = new Reporter();
        winTitle = fw_PropertyReader.getAppProperty("GUI_APP_PAGE_TITLE");
        seeTestHost = fw_PropertyReader.getFWXProperty("SEETEST_DEFAULT_URL");
        seeTestPort = Integer.parseInt(fw_PropertyReader.getFWXProperty("SEETEST_DEFAULT_PORT"));
        chromeDriverService = (ChromeDriverService)((org.openqa.selenium.chrome.ChromeDriverService.Builder)((org.openqa.selenium.chrome.ChromeDriverService.Builder)(new org.openqa.selenium.chrome.ChromeDriverService.Builder()).usingDriverExecutable(new File(fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PATH")))).usingPort(Integer.parseInt(fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PORT")))).build();
    }

    private long getStartTime()
    {
        return startTime;
    }

    private long getEndTime()
    {
        return endTime;
    }

    private long getTotalExecutionTime()
    {
        return totalExecutionTime;
    }

    public int getExecuted()
    {
        return executed;
    }

    public int getPassed()
    {
        return passed;
    }

    public int getFailed()
    {
        return failed;
    }

    private void setStartTime(long startTime)
    {
        this.startTime = startTime;
    }

    private void setEndTime(long endTime)
    {
        this.endTime = endTime;
    }

    private void setTotalExecutionTime()
    {
        totalExecutionTime = (getEndTime() - getStartTime()) / (long)FW_Const.THOUSAND.intValue();
    }

    public void setExecuted(int executed)
    {
        this.executed = executed;
    }

    public void setPassed(int passed)
    {
        this.passed = passed;
    }

    public void setFailed(int failed)
    {
        this.failed = failed;
    }

    public void testplanEnter()
    {
        setStartTime(System.currentTimeMillis());
        if(Boolean.valueOf(fw_PropertyReader.getFWXProperty("DEFAULT_REPORTER_ENABLED")).booleanValue())
            fw_Reporter.setIndexPageDescription("Hybrid Test Automation Framework<br/>");
        else
            logger.debug("[testplanEnter] Default Reporter DISABLED");
        logger.info("[testplanEnter] Testplan execution started...");
    }

    public void testplanExit()
    {
        setEndTime(System.currentTimeMillis());
        setTotalExecutionTime();
        logger.info("[testplanExit] EXECUTION SUMMARY");
        logger.info((new StringBuilder("[testplanExit] Testcases executed: ")).append(getExecuted()).toString());
        if(getExecuted() > 0)
        {
            logger.info((new StringBuilder("[testplanExit] Testcases Passed: ")).append(getPassed()).append(" (").append((getPassed() * FW_Const.HUNDRED.intValue()) / getExecuted()).append("%)").toString());
            logger.info((new StringBuilder("[testplanExit] Testcases Failed: ")).append(getFailed()).append(" (").append((getFailed() * FW_Const.HUNDRED.intValue()) / getExecuted()).append("%)").toString());
        }
        if(getTotalExecutionTime() >= (long)FW_Const.SIXTY.intValue())
            logger.info((new StringBuilder("[testplanExit] Executed in: ")).append(getTotalExecutionTime() / (long)FW_Const.SIXTY.intValue()).append(" minutes.").toString());
        else
            logger.info((new StringBuilder("[testplanExit] Executed in: ")).append(getTotalExecutionTime()).append(" seconds.").toString());
    }

    public void testcaseEnter(String platform, String browser, String appType, String browserVersion)
    {
        if(!platform.isEmpty() || platform != null)
            fw_Init.setPlatform(FW_Enums.platform.valueOf(platform));
        if(!browser.isEmpty() || browser != null)
            fw_Init.setBrowser(FW_Enums.browser.valueOf(browser));
        if(!appType.isEmpty() || appType != null)
            fw_Init.setApptype(FW_Enums.apptype.valueOf(appType));
        logger.info((new StringBuilder("[testcaseEnter] Testcase execution started with: ")).append(fw_Init.getPlatform()).append(" ").append(fw_Init.getApptype()).append(" ").append(fw_Init.getBrowser()).toString());
        boolean parallelExecution = !fw_PropertyReader.getFWXProperty("SUITE_PARALLEL").equalsIgnoreCase("none");
        DesiredCapabilities mobileCap = new DesiredCapabilities();
        mobileCap.setCapability("newCommandTimeout", fw_PropertyReader.getFWXProperty("APP_COMMAND_TIMEOUT"));
        mobileCap.setCapability("platformName", fw_PropertyReader.getFWXProperty("PLATFORM"));
        mobileCap.setCapability("deviceName", fw_PropertyReader.getFWXProperty("DEVICE"));
        mobileCap.setCapability("platformVersion", fw_PropertyReader.getFWXProperty("PLATFORM_VERSION"));
        DesiredCapabilities androidCap = DesiredCapabilities.android();
        DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
        DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
        DesiredCapabilities safariCap = DesiredCapabilities.safari();
        DesiredCapabilities ffCap = DesiredCapabilities.firefox();
        switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform()[fw_Init.getPlatform().ordinal()])
        {
        case 3: // '\003'
            switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[fw_Init.getApptype().ordinal()])
            {
            case 2: // '\002'
                androidCap.merge(mobileCap);
                androidCap.setCapability("appPackage", fw_PropertyReader.getFWXProperty("APP_PACKAGE"));
                androidCap.setCapability("appActivity", fw_PropertyReader.getFWXProperty("APP_ACTIVITY"));
                switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool()[fw_Init.getMobiletool().ordinal()])
                {
                case 2: // '\002'
                    Client cTestClient = new Client(seeTestHost, seeTestPort, true);
                    cTestClient.setDevice(fw_PropertyReader.getFWXProperty("DEVICE"));
                    fw_Drivers.setcTestDriver(new MobileWebDriver(cTestClient));
                    break;

                case 1: // '\001'
                default:
                    try
                    {
                        fw_Drivers.setmDriver(new AndroidDriver(new URL(fw_PropertyReader.getFWXProperty("DEFAULT_URL")), androidCap));
                    }
                    catch(MalformedURLException e)
                    {
                        logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                    }
                    break;
                }
                break;

            case 1: // '\001'
            default:
                androidCap.merge(mobileCap);
                androidCap.setCapability("browserName", fw_PropertyReader.getFWXProperty("BROWSER"));
                switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool()[fw_Init.getMobiletool().ordinal()])
                {
                case 2: // '\002'
                    Client cTestClient = new Client(seeTestHost, seeTestPort, true);
                    cTestClient.setDevice(fw_PropertyReader.getFWXProperty("DEVICE"));
                    fw_Drivers.setcTestDriver(new MobileWebDriver(cTestClient));
                    break;

                case 1: // '\001'
                default:
                    try
                    {
                        fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("DEFAULT_URL")), androidCap));
                    }
                    catch(MalformedURLException e)
                    {
                        logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                    }
                    break;
                }
                break;
            }
            break;

        case 4: // '\004'
            switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[fw_Init.getApptype().ordinal()])
            {
            case 1: // '\001'
            default:
                safariCap.merge(mobileCap);
                break;
            }
            safariCap.setCapability("browserName", fw_PropertyReader.getFWXProperty("BROWSER"));
            safariCap.setCapability("udid", fw_PropertyReader.getFWXProperty("UDID"));
            safariCap.setCapability("bundleID", fw_PropertyReader.getFWXProperty("BUNDLE_ID"));
            switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool()[fw_Init.getMobiletool().ordinal()])
            {
            case 2: // '\002'
                Client cTestClient = new Client(seeTestHost, seeTestPort, true);
                cTestClient.setDevice(fw_PropertyReader.getFWXProperty("DEVICE"));
                fw_Drivers.setcTestDriver(new MobileWebDriver(cTestClient));
                break;

            case 1: // '\001'
            default:
                try
                {
                    fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("DEFAULT_URL")), safariCap));
                }
                catch(MalformedURLException e)
                {
                    logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                }
                break;
            }
            break;

        case 2: // '\002'
            switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[fw_Init.getApptype().ordinal()])
            {
            case 1: // '\001'
            default:
                switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser()[fw_Init.getBrowser().ordinal()])
                {
                case 3: // '\003'
                {
                    File file = new File(fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PATH"));
                    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(new String[] {
                        "test-type"
                    });
                    options.addArguments(new String[] {
                        "disable-extensions"
                    });
                    chromeCap.setCapability("chromeOptions", options);
                    chromeCap.setCapability("nativeEvents", Boolean.valueOf(fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                    if(parallelExecution)
                        try
                        {
                            fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("GRID_URL")), chromeCap));
                        }
                        catch(MalformedURLException e)
                        {
                            logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                        }
                    else
                        fw_Drivers.setDriver(new ChromeDriver(chromeCap));
                    break;
                }

                case 2: // '\002'
                {
                    FirefoxProfile profile;
                    if(Boolean.parseBoolean(fw_PropertyReader.getFWXProperty("USE_FIREFOX_AUTOAUTH")))
                    {
                        profile = new FirefoxProfile(new File(fw_PropertyReader.getFWXProperty("BROWSER_PROFILE_PATH")));
                        try
                        {
                            profile.addExtension(new File(fw_PropertyReader.getFWXProperty("FIREFOX_AUTOAUTH_EXTENSION")));
                        }
                        catch(IOException e)
                        {
                            logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                        }
                    } else
                    {
                        profile = new FirefoxProfile();
                    }
                    profile.setEnableNativeEvents(Boolean.valueOf(fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")).booleanValue());
                    ffCap.setCapability("firefox_profile", profile);
                    if(parallelExecution)
                        try
                        {
                            fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("GRID_URL")), ffCap));
                        }
                        catch(MalformedURLException e)
                        {
                            logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                        }
                    else
                        fw_Drivers.setDriver(new FirefoxDriver(ffCap));
                    break;
                }

                case 4: // '\004'
                case 5: // '\005'
                default:
                {
                    File file = new File(fw_PropertyReader.getFWXProperty("SAFARI_EXTENSION"));
                    System.setProperty("webdriver.safari.driver", file.getAbsolutePath());
                    safariCap.setJavascriptEnabled(Boolean.valueOf(fw_PropertyReader.getFWXProperty("JS_ENABLED")).booleanValue());
                    if(parallelExecution)
                        try
                        {
                            fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("GRID_URL")), safariCap));
                        }
                        catch(MalformedURLException e)
                        {
                            logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                        }
                    else
                        fw_Drivers.setDriver(new SafariDriver(safariCap));
                    break;
                }
                }
                break;
            }
            // fall through

        case 1: // '\001'
        default:
label0:
            switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[fw_Init.getApptype().ordinal()])
            {
            case 4: // '\004'
                File file = new File(fw_PropertyReader.getFWXProperty("IE_WEBDRIVER_PATH"));
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                ieCap.setCapability("nativeEvents", Boolean.valueOf(fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                fw_Drivers.setDriver(new HtmlUnitDriver());
                fw_Drivers.setLdtpDriver(new Ldtp(winTitle));
                fw_Drivers.getLdtpDriver().launchApp(fw_PropertyReader.getAppProperty("GUI_APP_EXE"));
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            default:
                switch($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser()[fw_Init.getBrowser().ordinal()])
                {
                case 1: // '\001'
                {
                    File file = new File(fw_PropertyReader.getFWXProperty("IE_WEBDRIVER_PATH"));
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    ieCap.setCapability("nativeEvents", Boolean.valueOf(fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                    if(parallelExecution)
                        try
                        {
                            fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("GRID_URL")), ieCap));
                        }
                        catch(MalformedURLException e)
                        {
                            logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                        }
                    else
                        fw_Drivers.setDriver(new InternetExplorerDriver(ieCap));
                    break label0;
                }

                case 3: // '\003'
                {
                    File file = new File(fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PATH"));
                    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(new String[] {
                        "test-type"
                    });
                    options.addArguments(new String[] {
                        "disable-extensions"
                    });
                    chromeCap.setCapability("chromeOptions", options);
                    chromeCap.setCapability("nativeEvents", Boolean.valueOf(fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                    if(parallelExecution)
                        try
                        {
                            fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("GRID_URL")), chromeCap));
                        }
                        catch(MalformedURLException e)
                        {
                            logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                        }
                    else
                        fw_Drivers.setDriver(new ChromeDriver(chromeCap));
                    break label0;
                }

                case 5: // '\005'
                {
                    File file = new File(fw_PropertyReader.getFWXProperty("SAFARI_EXTENSION"));
                    System.setProperty("webdriver.safari.driver", file.getAbsolutePath());
                    safariCap.setJavascriptEnabled(Boolean.valueOf(fw_PropertyReader.getFWXProperty("JS_ENABLED")).booleanValue());
                    if(parallelExecution)
                        try
                        {
                            fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("GRID_URL")), safariCap));
                        }
                        catch(MalformedURLException e)
                        {
                            logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                        }
                    else
                        fw_Drivers.setDriver(new SafariDriver(safariCap));
                    break label0;
                }

                case 4: // '\004'
                {
                    try
                    {
                        chromeDriverService.start();
                    }
                    catch(IOException e)
                    {
                        logger.error((new StringBuilder("[testcaseEnter] IOException:")).append(e.getMessage()).toString());
                    }
                    ChromeOptions electron = new ChromeOptions();
                    electron.setBinary(fw_PropertyReader.getAppProperty("ELECTRON_BINARY"));
                    chromeCap.setCapability("chromeOptions", electron);
                    chromeCap.setBrowserName("electron");
                    try
                    {
                        fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("ELECTRON_URL")), chromeCap));
                    }
                    catch(MalformedURLException e)
                    {
                        logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                    }
                    break label0;
                }
                }
                FirefoxProfile profile;
                if(Boolean.parseBoolean(fw_PropertyReader.getFWXProperty("USE_FIREFOX_AUTOAUTH")))
                {
                    profile = new FirefoxProfile(new File(fw_PropertyReader.getFWXProperty("BROWSER_PROFILE_PATH")));
                    try
                    {
                        profile.addExtension(new File(fw_PropertyReader.getFWXProperty("FIREFOX_AUTOAUTH_EXTENSION")));
                    }
                    catch(IOException e)
                    {
                        logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                    }
                } else
                {
                    profile = new FirefoxProfile();
                }
                profile.setEnableNativeEvents(Boolean.valueOf(fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")).booleanValue());
                ffCap.setCapability("firefox_profile", profile);
                if(parallelExecution)
                    try
                    {
                        fw_Drivers.setDriver(new RemoteWebDriver(new URL(fw_PropertyReader.getFWXProperty("GRID_URL")), ffCap));
                    }
                    catch(MalformedURLException e)
                    {
                        logger.error((new StringBuilder("[testcaseEnter] MalformedURLException:")).append(e.getMessage()).toString());
                    }
                else
                    fw_Drivers.setDriver(new FirefoxDriver(ffCap));
                break;
            }
            break;
        }
        if(fw_Init.getApptype().equals(FW_Enums.apptype.WEB) && Boolean.valueOf(fw_PropertyReader.getFWXProperty("DEFAULT_REPORTER_ENABLED")).booleanValue())
            fw_Reporter.setWebDriver(fw_Drivers.getDriver());
        if(fw_Init.getPlatform().equals(FW_Enums.platform.WINDOWS) && fw_Init.getApptype().equals(FW_Enums.apptype.WEB))
            fw_Init.setMainWindow(fw_Drivers.getDriver().getWindowHandle());
    }

    public void testcaseExit()
    {
        I_FW_Functions fw_Functions = new FW_Functions();
        chromeDriverService.stop();
        if(fw_Init.getApptype().equals(FW_Enums.apptype.WEB) && (fw_Init.getPlatform().equals(FW_Enums.platform.ANDROID) || fw_Init.getPlatform().equals(FW_Enums.platform.IOS)))
            if(fw_Init.getMobiletool().equals(FW_Enums.mobiletool.SEETEST))
            {
                fw_Drivers.getcTestDriver().quit();
                fw_Drivers.getcTestDriver().releaseClient();
            } else
            {
                WebDriver d = fw_Drivers.getDriver();
                try
                {
                    fw_Functions.closeAllButMainWin();
                    d.switchTo().window(fw_Init.getMainWindow());
                    d.switchTo().defaultContent();
                }
                catch(SessionNotFoundException e)
                {
                    logger.warn((new StringBuilder("[testcaseExit] SessionNotFoundException: Browser main window might have been already closed ")).append(e.getMessage()).toString());
                }
                try
                {
                    d.quit();
                }
                catch(UnreachableBrowserException e)
                {
                    logger.warn((new StringBuilder("[testcaseExit] UnreachableBrowserException: Browser main window might have been already closed ")).append(e.getMessage()).toString());
                }
                catch(NoSuchWindowException e)
                {
                    logger.warn((new StringBuilder("[testcaseExit] NoSuchWindowException: Browser main window might have been already closed ")).append(e.getMessage()).toString());
                }
            }
        if(fw_Init.getPlatform().equals(FW_Enums.platform.WINDOWS) && fw_Init.getApptype().equals(FW_Enums.apptype.GUI))
        {
            WebDriver d = fw_Drivers.getDriver();
            try
            {
                fw_Functions.closeAllButMainWin();
                d.switchTo().window(fw_Init.getMainWindow());
                d.switchTo().defaultContent();
            }
            catch(SessionNotFoundException e)
            {
                logger.warn((new StringBuilder("[testcaseExit] SessionNotFoundException: Browser main window might have been already closed ")).append(e.getMessage()).toString());
            }
            try
            {
                d.quit();
            }
            catch(UnreachableBrowserException e)
            {
                logger.warn((new StringBuilder("[testcaseExit] UnreachableBrowserException: Browser main window might have been already closed ")).append(e.getMessage()).toString());
            }
            Ldtp ldtp = fw_Drivers.getLdtpDriver();
            try
            {
                if(ldtp.guiExist() != 0)
                    ldtp.closeWindow(winTitle);
            }
            catch(LdtpExecutionError e)
            {
                logger.warn((new StringBuilder("[testcaseExit] LdtpExecutionError: Main window might have been already closed ")).append(e.getMessage()).toString());
            }
            catch(NoSuchWindowException e)
            {
                logger.warn((new StringBuilder("[testcaseExit] NoSuchWindowException: Main window might have been already closed ")).append(e.getMessage()).toString());
            }
        }
        if(fw_Init.getPlatform().equals(FW_Enums.platform.ANDROID) && fw_Init.getApptype().equals(FW_Enums.apptype.NATIVE))
        {
            MobileDriver ad = fw_Drivers.getmDriver();
            try
            {
                ad.quit();
            }
            catch(NoSuchWindowException e)
            {
                logger.warn((new StringBuilder("[testcaseExit] NoSuchWindowException: Browser main window might have been already closed ")).append(e.getMessage()).toString());
            }
        }
        logger.info("[testcaseExit] Testcase execution completed...");
    }

    static int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool()
    {
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool;
        if($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[FW_Enums.mobiletool.values().length];
        try
        {
            ai[FW_Enums.mobiletool.APPIUM.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.mobiletool.SEETEST.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool = ai;
    }

    static int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()
    {
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype;
        if($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[FW_Enums.apptype.values().length];
        try
        {
            ai[FW_Enums.apptype.GUI.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.apptype.HYBRID.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.apptype.NATIVE.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.apptype.WEB.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype = ai;
    }

    static int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser()
    {
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser;
        if($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[FW_Enums.browser.values().length];
        try
        {
            ai[FW_Enums.browser.CHROME.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.browser.ELECTRON.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.browser.FIREFOX.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.browser.GUIAPP.ordinal()] = 6;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.browser.IE.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.browser.NATIVEAPP.ordinal()] = 7;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.browser.SAFARI.ordinal()] = 5;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser = ai;
    }

    static int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform()
    {
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform;
        if($SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[FW_Enums.platform.values().length];
        try
        {
            ai[FW_Enums.platform.ANDROID.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.platform.IOS.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.platform.MAC.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[FW_Enums.platform.WINDOWS.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform = ai;
    }

    private long startTime;
    private long endTime;
    private long totalExecutionTime;
    private int executed;
    private int passed;
    private int failed;
    public FW_PropertyReader fw_PropertyReader;
    public FW_Init fw_Init;
    public FW_Drivers fw_Drivers;
    public I_Reporter fw_Reporter;
    private static Logger logger;
    String winTitle;
    String seeTestHost;
    int seeTestPort;
    ChromeDriverService chromeDriverService;
    private static int $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool[];
    private static int $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype[];
    private static int $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser[];
    private static int $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform[];

    static 
    {
        logger = LogManager.getLogger(com/test/auto/fw_core/FW_TestPlan.getName());
        FW_PropertyReader fw_StaticPropertyReader = new FW_PropertyReader();
        if(Boolean.valueOf(fw_StaticPropertyReader.getFWXProperty("DEFAULT_REPORTER_ENABLED")).booleanValue())
        {
            String reporterDir = (new StringBuilder("config\\")).append(fw_StaticPropertyReader.getFWXProperty("REPORTER_PROPERTIES")).toString();
            System.setProperty(fw_StaticPropertyReader.getFWXProperty("REPORTER_CONFIG"), reporterDir);
            logger.debug((new StringBuilder("[static] Reporter Dir: ")).append(reporterDir).toString());
        }
    }
}
