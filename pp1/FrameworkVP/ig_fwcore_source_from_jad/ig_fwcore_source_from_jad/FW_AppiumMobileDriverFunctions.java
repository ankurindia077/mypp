// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_AppiumMobileDriverFunctions.java

package com.test.auto.fw_core;

import io.appium.java_client.MobileDriver;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Referenced classes of package com.test.auto.fw_core:
//            FW_Functions, FW_Drivers, FW_PropertyReader, FW_UtilFunctions, 
//            FW_PropertyFileReader, FW_Const, FW_Init

public class FW_AppiumMobileDriverFunctions extends FW_Functions
{

    public FW_AppiumMobileDriverFunctions()
    {
        fw_Drivers = new FW_Drivers();
        fw_PropertyReader = new FW_PropertyReader();
        fw_UtilFunctions = new FW_UtilFunctions();
        d = fw_Drivers.getmDriver();
        fw_PropertyFileReader = new FW_PropertyFileReader();
        resultsFolder = (new StringBuilder(String.valueOf(fw_PropertyReader.getReporterProperty("atu.reports.dir")))).append("/").append("Results").append("/").toString();
        settingsPropertiesFile = (new StringBuilder(String.valueOf(resultsFolder))).append("Settings.properties").toString();
        settingsProperties = fw_PropertyFileReader.loadProperties(settingsPropertiesFile);
        currentRun = Integer.valueOf(Integer.parseInt(settingsProperties.getProperty("run")));
        runFolder = (new StringBuilder("Run_")).append(currentRun.toString()).append("/").toString();
        suiteName = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("SUITE_NAME")))).append("/").toString();
        testName = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("TEST_NAME")))).append("/").toString();
        workingDir = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("WORKING_DIR")))).append("/").toString();
        testPlanDir = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("TESTPLAN_CLASS_NAME").replace(".", "/")))).append("/").toString();
        imageFolderPrefix = (new StringBuilder(String.valueOf(resultsFolder))).append(runFolder).append(suiteName).append(testName).append(workingDir).append(testPlanDir).toString();
    }

    public void launch(String url)
    {
        logger.debug((new StringBuilder("[launch] Launching application with URL '")).append(url).append("'.").toString());
        try
        {
            d.get(url);
            d.manage().window().maximize();
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
    }

    public void executeJS(String scriptName)
    {
        logger.debug((new StringBuilder("[executeJS] Executing Javascript: ")).append(scriptName).toString());
        JavascriptExecutor js = (JavascriptExecutor)d;
        js.executeScript(scriptName, new Object[0]);
    }

    public void overrideLink()
    {
        try
        {
            d.get("javascript:document.getElementById('overridelink').click();");
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("[overrideLink] Exception: ")).append(e.getMessage()).toString());
        }
    }

    public boolean isAlertPresent()
    {
        fw_UtilFunctions.fixedWaitForSeconds(Integer.valueOf(Integer.parseInt(fw_PropertyReader.getFWXProperty("EXEC_SPEED_CONTROLLER_SECONDS"))));
        try
        {
            d.switchTo().alert();
            logger.debug("[isAlertPresent] Switching to Alert");
        }
        catch(NoAlertPresentException Ex)
        {
            logger.error((new StringBuilder("[isAlertPresent] NoAlertPresentException: ")).append(Ex.getMessage()).toString());
            return false;
        }
        return true;
    }

    public void waitForElement(By by, String elementTitle, Integer timeoutInSeconds)
    {
        fw_UtilFunctions.fixedWaitForSeconds(Integer.valueOf(Integer.parseInt(fw_PropertyReader.getFWXProperty("EXEC_SPEED_CONTROLLER_SECONDS"))));
        WebDriverWait wait = new WebDriverWait(d, timeoutInSeconds.intValue());
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToDisappear(By by, String elementTitle, Integer timeoutInSeconds)
    {
        fw_UtilFunctions.fixedWaitForSeconds(Integer.valueOf(Integer.parseInt(fw_PropertyReader.getFWXProperty("EXEC_SPEED_CONTROLLER_SECONDS"))));
        Integer waitedFor = Integer.valueOf(0);
        WebDriverWait wait = new WebDriverWait(d, timeoutInSeconds.intValue());
        WebElement waitForElement = (WebElement)wait.until(ExpectedConditions.presenceOfElementLocated(by));
        try
        {
            while(waitForElement.isDisplayed()) 
            {
                fw_UtilFunctions.fixedWaitForSeconds(FW_Const.THREE);
                waitedFor = Integer.valueOf(waitedFor.intValue() + FW_Const.THREE.intValue());
                if(waitedFor.intValue() >= timeoutInSeconds.intValue())
                {
                    logger.error((new StringBuilder("[waitForElementToDisappear] TIMEOUT: Elemet is still displayed even after ")).append(timeoutInSeconds).append(" seconds").toString());
                    break;
                }
            }
        }
        catch(StaleElementReferenceException ex)
        {
            logger.error((new StringBuilder("[waitForElementToDisappear] StaleElementReferenceException: ")).append(ex.getMessage()).toString());
            fw_UtilFunctions.fixedWaitForSeconds(FW_Const.ONE);
        }
    }

    public void closeAllButMainWin()
    {
        FW_Init fw_Init = new FW_Init();
        Set handles = d.getWindowHandles();
        if(handles.size() > 1)
        {
            handles.remove(fw_Init.getMainWindow());
            for(Iterator iterator = handles.iterator(); iterator.hasNext();)
            {
                String windowHandle = (String)iterator.next();
                if(!windowHandle.equals(fw_Init.getMainWindow()))
                {
                    d.switchTo().window(windowHandle);
                    try
                    {
                        logger.debug((new StringBuilder("[closeAllButMainWin] Trying to close window with title: ")).append(d.getTitle()).toString());
                        d.close();
                    }
                    catch(NoSuchWindowException e)
                    {
                        logger.warn((new StringBuilder("[closeAllButMainWin] NoSuchWindowException: ")).append(e.getMessage()).toString());
                    }
                }
            }

        }
    }

    public void captureWebElementImage(WebElement ele, String imageFolder, String imageName)
    {
        imageFolder = (new StringBuilder(String.valueOf(imageFolder))).append(fw_PropertyReader.getFWXProperty("BROWSER")).append("/").toString();
        logger.debug((new StringBuilder("[captureWebElementImage] Image folder: ")).append(imageFolder).toString());
        File screenshot = (File)((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = null;
        try
        {
            fullImg = ImageIO.read(screenshot);
        }
        catch(IOException e)
        {
            logger.error((new StringBuilder("[captureWebElementImage] IOException: ")).append(e.getMessage()).toString());
        }
        Coordinates location = ((Locatable)ele).getCoordinates();
        Point point = location.inViewPort();
        int eleWidth = ele.getSize().getWidth() + 2;
        int eleHeight = ele.getSize().getHeight() + 2;
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        try
        {
            ImageIO.write(eleScreenshot, "png", screenshot);
        }
        catch(IOException e)
        {
            logger.error((new StringBuilder("[captureWebElementImage] IOException: ")).append(e.getMessage()).toString());
        }
        try
        {
            FileUtils.copyFile(screenshot, new File((new StringBuilder(String.valueOf(imageFolder))).append(imageName).append(".png").toString()));
            logger.debug((new StringBuilder("[captureWebElementImage] Saving WebElement image: ")).append(imageFolder).append(imageName).append(".png").toString());
        }
        catch(IOException e)
        {
            logger.error((new StringBuilder("[captureWebElementImage] IOException: ")).append(e.getMessage()).toString());
        }
    }

    public void captureScreenshot(String testcaseID, String imageName)
    {
        String imageFolder = (new StringBuilder(String.valueOf(imageFolderPrefix))).append(testcaseID).append("_Iteration1").append("/").append("img").append("/").toString();
        logger.debug((new StringBuilder("[captureScreenshot] Image folder: ")).append(imageFolder).toString());
        File screenshot = (File)((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = null;
        try
        {
            fullImg = ImageIO.read(screenshot);
        }
        catch(IOException e)
        {
            logger.error((new StringBuilder("[captureScreenshot] IOException: ")).append(e.getMessage()).toString());
        }
        try
        {
            ImageIO.write(fullImg, "png", screenshot);
        }
        catch(IOException e)
        {
            logger.error((new StringBuilder("[captureScreenshot] IOException: ")).append(e.getMessage()).toString());
        }
        try
        {
            FileUtils.copyFile(screenshot, new File((new StringBuilder(String.valueOf(imageFolder))).append(imageName).toString()));
            logger.debug((new StringBuilder("[captureScreenshot] Saving WebElement image: ")).append(imageFolder).append(imageName).toString());
        }
        catch(IOException e)
        {
            logger.error((new StringBuilder("[captureScreenshot] IOException: ")).append(e.getMessage()).toString());
        }
    }

    FW_Drivers fw_Drivers;
    FW_PropertyReader fw_PropertyReader;
    FW_UtilFunctions fw_UtilFunctions;
    MobileDriver d;
    FW_PropertyFileReader fw_PropertyFileReader;
    String resultsFolder;
    String settingsPropertiesFile;
    Properties settingsProperties;
    Integer currentRun;
    String runFolder;
    String suiteName;
    String testName;
    String workingDir;
    String testPlanDir;
    String imageFolderPrefix;
    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_Functions.getName());

}
