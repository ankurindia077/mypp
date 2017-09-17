/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.cobra.ldtp.Ldtp
 *  com.cobra.ldtp.LdtpExecutionError
 *  com.experitest.client.Client
 *  com.experitest.selenium.MobileWebDriver
 *  com.igate.features.Reporter.I_Reporter
 *  com.igate.features.Reporter.Reporter
 *  io.appium.java_client.MobileDriver
 *  io.appium.java_client.android.AndroidDriver
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.openqa.selenium.Capabilities
 *  org.openqa.selenium.NoSuchWindowException
 *  org.openqa.selenium.WebDriver
 *  org.openqa.selenium.WebDriver$TargetLocator
 *  org.openqa.selenium.chrome.ChromeDriver
 *  org.openqa.selenium.chrome.ChromeDriverService
 *  org.openqa.selenium.chrome.ChromeDriverService$Builder
 *  org.openqa.selenium.chrome.ChromeOptions
 *  org.openqa.selenium.firefox.FirefoxDriver
 *  org.openqa.selenium.firefox.FirefoxProfile
 *  org.openqa.selenium.htmlunit.HtmlUnitDriver
 *  org.openqa.selenium.ie.InternetExplorerDriver
 *  org.openqa.selenium.remote.DesiredCapabilities
 *  org.openqa.selenium.remote.RemoteWebDriver
 *  org.openqa.selenium.remote.SessionNotFoundException
 *  org.openqa.selenium.remote.UnreachableBrowserException
 *  org.openqa.selenium.remote.service.DriverService
 *  org.openqa.selenium.remote.service.DriverService$Builder
 *  org.openqa.selenium.safari.SafariDriver
 *  org.testng.annotations.AfterMethod
 *  org.testng.annotations.AfterSuite
 *  org.testng.annotations.BeforeMethod
 *  org.testng.annotations.BeforeSuite
 *  org.testng.annotations.Optional
 *  org.testng.annotations.Parameters
 */
package com.test.auto.fw_core;

import com.cobra.ldtp.Ldtp;
import com.cobra.ldtp.LdtpExecutionError;
import com.experitest.client.Client;
import com.experitest.selenium.MobileWebDriver;
import com.igate.features.Reporter.I_Reporter;
import com.igate.features.Reporter.Reporter;
import com.test.auto.fw_core.FW_Const;
import com.test.auto.fw_core.FW_Drivers;
import com.test.auto.fw_core.FW_Enums;
import com.test.auto.fw_core.FW_Functions;
import com.test.auto.fw_core.FW_Init;
import com.test.auto.fw_core.FW_PropertyReader;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class FW_TestPlan {
    private long startTime;
    private long endTime;
    private long totalExecutionTime;
    private int executed;
    private int passed;
    private int failed;
    public FW_PropertyReader fw_PropertyReader = new FW_PropertyReader();
    public FW_Init fw_Init = new FW_Init();
    public FW_Drivers fw_Drivers = new FW_Drivers();
    public I_Reporter fw_Reporter = new Reporter();
    private static Logger logger = LogManager.getLogger((String)FW_TestPlan.class.getName());
    String winTitle = this.fw_PropertyReader.getAppProperty("GUI_APP_PAGE_TITLE");
    String seeTestHost = this.fw_PropertyReader.getFWXProperty("SEETEST_DEFAULT_URL");
    int seeTestPort = Integer.parseInt(this.fw_PropertyReader.getFWXProperty("SEETEST_DEFAULT_PORT"));
    ChromeDriverService chromeDriverService = (ChromeDriverService)((ChromeDriverService.Builder)((ChromeDriverService.Builder)new ChromeDriverService.Builder().usingDriverExecutable(new File(this.fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PATH")))).usingPort(Integer.parseInt(this.fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PORT")))).build();
    private static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform;

    static {
        FW_PropertyReader fw_StaticPropertyReader = new FW_PropertyReader();
        if (Boolean.valueOf(fw_StaticPropertyReader.getFWXProperty("DEFAULT_REPORTER_ENABLED")).booleanValue()) {
            String reporterDir = "config\\" + fw_StaticPropertyReader.getFWXProperty("REPORTER_PROPERTIES");
            System.setProperty(fw_StaticPropertyReader.getFWXProperty("REPORTER_CONFIG"), reporterDir);
            logger.debug((Object)("[static] Reporter Dir: " + reporterDir));
        }
    }

    private long getStartTime() {
        return this.startTime;
    }

    private long getEndTime() {
        return this.endTime;
    }

    private long getTotalExecutionTime() {
        return this.totalExecutionTime;
    }

    public int getExecuted() {
        return this.executed;
    }

    public int getPassed() {
        return this.passed;
    }

    public int getFailed() {
        return this.failed;
    }

    private void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    private void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    private void setTotalExecutionTime() {
        this.totalExecutionTime = (this.getEndTime() - this.getStartTime()) / (long)FW_Const.THOUSAND.intValue();
    }

    public void setExecuted(int executed) {
        this.executed = executed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    @BeforeSuite(alwaysRun=1)
    public void testplanEnter() {
        this.setStartTime(System.currentTimeMillis());
        if (Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("DEFAULT_REPORTER_ENABLED")).booleanValue()) {
            this.fw_Reporter.setIndexPageDescription("Hybrid Test Automation Framework<br/>");
        } else {
            logger.debug((Object)"[testplanEnter] Default Reporter DISABLED");
        }
        logger.info((Object)"[testplanEnter] Testplan execution started...");
    }

    @AfterSuite(alwaysRun=1)
    public void testplanExit() {
        this.setEndTime(System.currentTimeMillis());
        this.setTotalExecutionTime();
        logger.info((Object)"[testplanExit] EXECUTION SUMMARY");
        logger.info((Object)("[testplanExit] Testcases executed: " + this.getExecuted()));
        if (this.getExecuted() > 0) {
            logger.info((Object)("[testplanExit] Testcases Passed: " + this.getPassed() + " (" + this.getPassed() * FW_Const.HUNDRED / this.getExecuted() + "%)"));
            logger.info((Object)("[testplanExit] Testcases Failed: " + this.getFailed() + " (" + this.getFailed() * FW_Const.HUNDRED / this.getExecuted() + "%)"));
        }
        if (this.getTotalExecutionTime() >= (long)FW_Const.SIXTY.intValue()) {
            logger.info((Object)("[testplanExit] Executed in: " + this.getTotalExecutionTime() / (long)FW_Const.SIXTY.intValue() + " minutes."));
        } else {
            logger.info((Object)("[testplanExit] Executed in: " + this.getTotalExecutionTime() + " seconds."));
        }
    }

    @BeforeMethod(alwaysRun=1)
    @Parameters(value={"platform", "browser", "appType", "browserVersion"})
    public void testcaseEnter(@Optional String platform2, @Optional String browser2, @Optional String appType, @Optional String browserVersion) {
        if (!platform2.isEmpty() || platform2 != null) {
            this.fw_Init.setPlatform(FW_Enums.platform.valueOf(platform2));
        }
        if (!browser2.isEmpty() || browser2 != null) {
            this.fw_Init.setBrowser(FW_Enums.browser.valueOf(browser2));
        }
        if (!appType.isEmpty() || appType != null) {
            this.fw_Init.setApptype(FW_Enums.apptype.valueOf(appType));
        }
        logger.info((Object)("[testcaseEnter] Testcase execution started with: " + (Object)((Object)this.fw_Init.getPlatform()) + " " + (Object)((Object)this.fw_Init.getApptype()) + " " + (Object)((Object)this.fw_Init.getBrowser())));
        boolean parallelExecution = !this.fw_PropertyReader.getFWXProperty("SUITE_PARALLEL").equalsIgnoreCase("none");
        DesiredCapabilities mobileCap = new DesiredCapabilities();
        mobileCap.setCapability("newCommandTimeout", this.fw_PropertyReader.getFWXProperty("APP_COMMAND_TIMEOUT"));
        mobileCap.setCapability("platformName", this.fw_PropertyReader.getFWXProperty("PLATFORM"));
        mobileCap.setCapability("deviceName", this.fw_PropertyReader.getFWXProperty("DEVICE"));
        mobileCap.setCapability("platformVersion", this.fw_PropertyReader.getFWXProperty("PLATFORM_VERSION"));
        DesiredCapabilities androidCap = DesiredCapabilities.android();
        DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
        DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
        DesiredCapabilities safariCap = DesiredCapabilities.safari();
        DesiredCapabilities ffCap = DesiredCapabilities.firefox();
        block14 : switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform()[this.fw_Init.getPlatform().ordinal()]) {
            ChromeOptions options;
            File file;
            case 3: {
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[this.fw_Init.getApptype().ordinal()]) {
                    case 2: {
                        androidCap.merge((Capabilities)mobileCap);
                        androidCap.setCapability("appPackage", this.fw_PropertyReader.getFWXProperty("APP_PACKAGE"));
                        androidCap.setCapability("appActivity", this.fw_PropertyReader.getFWXProperty("APP_ACTIVITY"));
                        switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool()[this.fw_Init.getMobiletool().ordinal()]) {
                            case 2: {
                                Client cTestClient = new Client(this.seeTestHost, this.seeTestPort, true);
                                cTestClient.setDevice(this.fw_PropertyReader.getFWXProperty("DEVICE"));
                                this.fw_Drivers.setcTestDriver(new MobileWebDriver(cTestClient));
                                break block14;
                            }
                        }
                        try {
                            this.fw_Drivers.setmDriver((MobileDriver)new AndroidDriver(new URL(this.fw_PropertyReader.getFWXProperty("DEFAULT_URL")), (Capabilities)androidCap));
                        }
                        catch (MalformedURLException e) {
                            logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                        }
                        break block14;
                    }
                }
                androidCap.merge((Capabilities)mobileCap);
                androidCap.setCapability("browserName", this.fw_PropertyReader.getFWXProperty("BROWSER"));
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool()[this.fw_Init.getMobiletool().ordinal()]) {
                    case 2: {
                        Client cTestClient = new Client(this.seeTestHost, this.seeTestPort, true);
                        cTestClient.setDevice(this.fw_PropertyReader.getFWXProperty("DEVICE"));
                        this.fw_Drivers.setcTestDriver(new MobileWebDriver(cTestClient));
                        break block14;
                    }
                }
                try {
                    this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("DEFAULT_URL")), (Capabilities)androidCap));
                }
                catch (MalformedURLException e) {
                    logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                }
                break;
            }
            case 4: {
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[this.fw_Init.getApptype().ordinal()]) {
                    default: 
                }
                safariCap.merge((Capabilities)mobileCap);
                safariCap.setCapability("browserName", this.fw_PropertyReader.getFWXProperty("BROWSER"));
                safariCap.setCapability("udid", this.fw_PropertyReader.getFWXProperty("UDID"));
                safariCap.setCapability("bundleID", this.fw_PropertyReader.getFWXProperty("BUNDLE_ID"));
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool()[this.fw_Init.getMobiletool().ordinal()]) {
                    case 2: {
                        Client cTestClient = new Client(this.seeTestHost, this.seeTestPort, true);
                        cTestClient.setDevice(this.fw_PropertyReader.getFWXProperty("DEVICE"));
                        this.fw_Drivers.setcTestDriver(new MobileWebDriver(cTestClient));
                        break block14;
                    }
                }
                try {
                    this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("DEFAULT_URL")), (Capabilities)safariCap));
                }
                catch (MalformedURLException e) {
                    logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                }
                break;
            }
            case 2: {
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[this.fw_Init.getApptype().ordinal()]) {
                    default: 
                }
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser()[this.fw_Init.getBrowser().ordinal()]) {
                    case 3: {
                        file = new File(this.fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PATH"));
                        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                        options = new ChromeOptions();
                        options.addArguments(new String[]{"test-type"});
                        options.addArguments(new String[]{"disable-extensions"});
                        chromeCap.setCapability("chromeOptions", (Object)options);
                        chromeCap.setCapability("nativeEvents", (Object)Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                        if (parallelExecution) {
                            try {
                                this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("GRID_URL")), (Capabilities)chromeCap));
                            }
                            catch (MalformedURLException e) {
                                logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                            }
                            break;
                        }
                        this.fw_Drivers.setDriver((WebDriver)new ChromeDriver((Capabilities)chromeCap));
                        break;
                    }
                    case 2: {
                        FirefoxProfile profile;
                        if (Boolean.parseBoolean(this.fw_PropertyReader.getFWXProperty("USE_FIREFOX_AUTOAUTH"))) {
                            profile = new FirefoxProfile(new File(this.fw_PropertyReader.getFWXProperty("BROWSER_PROFILE_PATH")));
                            try {
                                profile.addExtension(new File(this.fw_PropertyReader.getFWXProperty("FIREFOX_AUTOAUTH_EXTENSION")));
                            }
                            catch (IOException e) {
                                logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                            }
                        } else {
                            profile = new FirefoxProfile();
                        }
                        profile.setEnableNativeEvents(Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")).booleanValue());
                        ffCap.setCapability("firefox_profile", (Object)profile);
                        if (parallelExecution) {
                            try {
                                this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("GRID_URL")), (Capabilities)ffCap));
                            }
                            catch (MalformedURLException e) {
                                logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                            }
                            break;
                        }
                        this.fw_Drivers.setDriver((WebDriver)new FirefoxDriver((Capabilities)ffCap));
                        break;
                    }
                    default: {
                        file = new File(this.fw_PropertyReader.getFWXProperty("SAFARI_EXTENSION"));
                        System.setProperty("webdriver.safari.driver", file.getAbsolutePath());
                        safariCap.setJavascriptEnabled(Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("JS_ENABLED")).booleanValue());
                        if (parallelExecution) {
                            try {
                                this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("GRID_URL")), (Capabilities)safariCap));
                            }
                            catch (MalformedURLException e) {
                                logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                            }
                            break;
                        }
                        this.fw_Drivers.setDriver((WebDriver)new SafariDriver((Capabilities)safariCap));
                    }
                }
            }
            default: {
                FirefoxProfile profile;
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype()[this.fw_Init.getApptype().ordinal()]) {
                    case 4: {
                        file = new File(this.fw_PropertyReader.getFWXProperty("IE_WEBDRIVER_PATH"));
                        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                        ieCap.setCapability("nativeEvents", (Object)Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                        this.fw_Drivers.setDriver((WebDriver)new HtmlUnitDriver());
                        this.fw_Drivers.setLdtpDriver(new Ldtp(this.winTitle));
                        this.fw_Drivers.getLdtpDriver().launchApp(this.fw_PropertyReader.getAppProperty("GUI_APP_EXE"));
                        break block14;
                    }
                }
                switch (FW_TestPlan.$SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser()[this.fw_Init.getBrowser().ordinal()]) {
                    case 1: {
                        file = new File(this.fw_PropertyReader.getFWXProperty("IE_WEBDRIVER_PATH"));
                        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                        ieCap.setCapability("nativeEvents", (Object)Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                        if (parallelExecution) {
                            try {
                                this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("GRID_URL")), (Capabilities)ieCap));
                            }
                            catch (MalformedURLException e) {
                                logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                            }
                            break block14;
                        }
                        this.fw_Drivers.setDriver((WebDriver)new InternetExplorerDriver((Capabilities)ieCap));
                        break block14;
                    }
                    case 3: {
                        file = new File(this.fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER_PATH"));
                        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                        options = new ChromeOptions();
                        options.addArguments(new String[]{"test-type"});
                        options.addArguments(new String[]{"disable-extensions"});
                        chromeCap.setCapability("chromeOptions", (Object)options);
                        chromeCap.setCapability("nativeEvents", (Object)Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")));
                        if (parallelExecution) {
                            try {
                                this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("GRID_URL")), (Capabilities)chromeCap));
                            }
                            catch (MalformedURLException e) {
                                logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                            }
                            break block14;
                        }
                        this.fw_Drivers.setDriver((WebDriver)new ChromeDriver((Capabilities)chromeCap));
                        break block14;
                    }
                    case 5: {
                        file = new File(this.fw_PropertyReader.getFWXProperty("SAFARI_EXTENSION"));
                        System.setProperty("webdriver.safari.driver", file.getAbsolutePath());
                        safariCap.setJavascriptEnabled(Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("JS_ENABLED")).booleanValue());
                        if (parallelExecution) {
                            try {
                                this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("GRID_URL")), (Capabilities)safariCap));
                            }
                            catch (MalformedURLException e) {
                                logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                            }
                            break block14;
                        }
                        this.fw_Drivers.setDriver((WebDriver)new SafariDriver((Capabilities)safariCap));
                        break block14;
                    }
                    case 4: {
                        try {
                            this.chromeDriverService.start();
                        }
                        catch (IOException e) {
                            logger.error((Object)("[testcaseEnter] IOException:" + e.getMessage()));
                        }
                        ChromeOptions electron = new ChromeOptions();
                        electron.setBinary(this.fw_PropertyReader.getAppProperty("ELECTRON_BINARY"));
                        chromeCap.setCapability("chromeOptions", (Object)electron);
                        chromeCap.setBrowserName("electron");
                        try {
                            this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("ELECTRON_URL")), (Capabilities)chromeCap));
                        }
                        catch (MalformedURLException e) {
                            logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                        }
                        break block14;
                    }
                }
                if (Boolean.parseBoolean(this.fw_PropertyReader.getFWXProperty("USE_FIREFOX_AUTOAUTH"))) {
                    profile = new FirefoxProfile(new File(this.fw_PropertyReader.getFWXProperty("BROWSER_PROFILE_PATH")));
                    try {
                        profile.addExtension(new File(this.fw_PropertyReader.getFWXProperty("FIREFOX_AUTOAUTH_EXTENSION")));
                    }
                    catch (IOException e) {
                        logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                    }
                } else {
                    profile = new FirefoxProfile();
                }
                profile.setEnableNativeEvents(Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("NATIVE_EVENTS")).booleanValue());
                ffCap.setCapability("firefox_profile", (Object)profile);
                if (parallelExecution) {
                    try {
                        this.fw_Drivers.setDriver((WebDriver)new RemoteWebDriver(new URL(this.fw_PropertyReader.getFWXProperty("GRID_URL")), (Capabilities)ffCap));
                    }
                    catch (MalformedURLException e) {
                        logger.error((Object)("[testcaseEnter] MalformedURLException:" + e.getMessage()));
                    }
                    break;
                }
                this.fw_Drivers.setDriver((WebDriver)new FirefoxDriver((Capabilities)ffCap));
            }
        }
        if (this.fw_Init.getApptype().equals((Object)FW_Enums.apptype.WEB) && Boolean.valueOf(this.fw_PropertyReader.getFWXProperty("DEFAULT_REPORTER_ENABLED")).booleanValue()) {
            this.fw_Reporter.setWebDriver(this.fw_Drivers.getDriver());
        }
        if (this.fw_Init.getPlatform().equals((Object)FW_Enums.platform.WINDOWS) && this.fw_Init.getApptype().equals((Object)FW_Enums.apptype.WEB)) {
            this.fw_Init.setMainWindow(this.fw_Drivers.getDriver().getWindowHandle());
        }
    }

    @AfterMethod(alwaysRun=1)
    public void testcaseExit() {
        WebDriver d;
        FW_Functions fw_Functions = new FW_Functions();
        this.chromeDriverService.stop();
        if (this.fw_Init.getApptype().equals((Object)FW_Enums.apptype.WEB) && (this.fw_Init.getPlatform().equals((Object)FW_Enums.platform.ANDROID) || this.fw_Init.getPlatform().equals((Object)FW_Enums.platform.IOS))) {
            if (this.fw_Init.getMobiletool().equals((Object)FW_Enums.mobiletool.SEETEST)) {
                this.fw_Drivers.getcTestDriver().quit();
                this.fw_Drivers.getcTestDriver().releaseClient();
            } else {
                d = this.fw_Drivers.getDriver();
                try {
                    fw_Functions.closeAllButMainWin();
                    d.switchTo().window(this.fw_Init.getMainWindow());
                    d.switchTo().defaultContent();
                }
                catch (SessionNotFoundException e) {
                    logger.warn((Object)("[testcaseExit] SessionNotFoundException: Browser main window might have been already closed " + e.getMessage()));
                }
                try {
                    d.quit();
                }
                catch (UnreachableBrowserException e) {
                    logger.warn((Object)("[testcaseExit] UnreachableBrowserException: Browser main window might have been already closed " + e.getMessage()));
                }
                catch (NoSuchWindowException e) {
                    logger.warn((Object)("[testcaseExit] NoSuchWindowException: Browser main window might have been already closed " + e.getMessage()));
                }
            }
        }
        if (this.fw_Init.getPlatform().equals((Object)FW_Enums.platform.WINDOWS) && this.fw_Init.getApptype().equals((Object)FW_Enums.apptype.GUI)) {
            d = this.fw_Drivers.getDriver();
            try {
                fw_Functions.closeAllButMainWin();
                d.switchTo().window(this.fw_Init.getMainWindow());
                d.switchTo().defaultContent();
            }
            catch (SessionNotFoundException e) {
                logger.warn((Object)("[testcaseExit] SessionNotFoundException: Browser main window might have been already closed " + e.getMessage()));
            }
            try {
                d.quit();
            }
            catch (UnreachableBrowserException e) {
                logger.warn((Object)("[testcaseExit] UnreachableBrowserException: Browser main window might have been already closed " + e.getMessage()));
            }
            Ldtp ldtp = this.fw_Drivers.getLdtpDriver();
            try {
                if (ldtp.guiExist() != 0) {
                    ldtp.closeWindow(this.winTitle);
                }
            }
            catch (LdtpExecutionError e) {
                logger.warn((Object)("[testcaseExit] LdtpExecutionError: Main window might have been already closed " + e.getMessage()));
            }
            catch (NoSuchWindowException e) {
                logger.warn((Object)("[testcaseExit] NoSuchWindowException: Main window might have been already closed " + e.getMessage()));
            }
        }
        if (this.fw_Init.getPlatform().equals((Object)FW_Enums.platform.ANDROID) && this.fw_Init.getApptype().equals((Object)FW_Enums.apptype.NATIVE)) {
            MobileDriver ad = this.fw_Drivers.getmDriver();
            try {
                ad.quit();
            }
            catch (NoSuchWindowException e) {
                logger.warn((Object)("[testcaseExit] NoSuchWindowException: Browser main window might have been already closed " + e.getMessage()));
            }
        }
        logger.info((Object)"[testcaseExit] Testcase execution completed...");
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[FW_Enums.mobiletool.values().length];
        try {
            arrn[FW_Enums.mobiletool.APPIUM.ordinal()] = 1;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[FW_Enums.mobiletool.SEETEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError v2) {}
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool = arrn;
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$mobiletool;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[FW_Enums.apptype.values().length];
        try {
            arrn[FW_Enums.apptype.GUI.ordinal()] = 4;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[FW_Enums.apptype.HYBRID.ordinal()] = 3;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[FW_Enums.apptype.NATIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError v3) {}
        try {
            arrn[FW_Enums.apptype.WEB.ordinal()] = 1;
        }
        catch (NoSuchFieldError v4) {}
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype = arrn;
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$apptype;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[FW_Enums.browser.values().length];
        try {
            arrn[FW_Enums.browser.CHROME.ordinal()] = 3;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[FW_Enums.browser.ELECTRON.ordinal()] = 4;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[FW_Enums.browser.FIREFOX.ordinal()] = 2;
        }
        catch (NoSuchFieldError v3) {}
        try {
            arrn[FW_Enums.browser.GUIAPP.ordinal()] = 6;
        }
        catch (NoSuchFieldError v4) {}
        try {
            arrn[FW_Enums.browser.IE.ordinal()] = 1;
        }
        catch (NoSuchFieldError v5) {}
        try {
            arrn[FW_Enums.browser.NATIVEAPP.ordinal()] = 7;
        }
        catch (NoSuchFieldError v6) {}
        try {
            arrn[FW_Enums.browser.SAFARI.ordinal()] = 5;
        }
        catch (NoSuchFieldError v7) {}
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser = arrn;
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$browser;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[FW_Enums.platform.values().length];
        try {
            arrn[FW_Enums.platform.ANDROID.ordinal()] = 3;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[FW_Enums.platform.IOS.ordinal()] = 4;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[FW_Enums.platform.MAC.ordinal()] = 2;
        }
        catch (NoSuchFieldError v3) {}
        try {
            arrn[FW_Enums.platform.WINDOWS.ordinal()] = 1;
        }
        catch (NoSuchFieldError v4) {}
        $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform = arrn;
        return $SWITCH_TABLE$com$test$auto$fw_core$FW_Enums$platform;
    }
}

