// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_Functions.java

package com.test.auto.fw_core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Referenced classes of package com.test.auto.fw_core:
//            I_FW_Functions, FW_Drivers, FW_PropertyReader, FW_UtilFunctions, 
//            FW_Const, FW_Init, FW_AnyType

public class FW_Functions
    implements I_FW_Functions
{

    public FW_Functions()
    {
        fw_Drivers = new FW_Drivers();
        fw_PropertyReader = new FW_PropertyReader();
        fw_UtilFunctions = new FW_UtilFunctions();
        d = fw_Drivers.getDriver();
    }

    public void launch(String url)
    {
        logger.debug((new StringBuilder("[launch] Launching application with URL '")).append(url).append("'.").toString());
        try
        {
            d.get(url);
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

    public void captureScreenshot(String s, String s1)
    {
    }

    public void linkScreenShotsToHTMLReport(String s)
    {
    }

    public boolean VerifySafely(String description, FW_AnyType expected, FW_AnyType actual)
    {
        boolean result = true;
        try
        {
            Assert.assertEquals(actual.getT(), expected.getT(), description);
        }
        catch(AssertionError e)
        {
            result = false;
            logger.error((new StringBuilder("[VerifySafely] AssertionError: ")).append(description).append(" \t[Expected]: ").append(expected.getT().toString()).append("\t\t[Actual]: ").append(actual.getT().toString()).toString());
        }
        if(result)
            logger.info((new StringBuilder("VERIFIED - ")).append(description).append(" \t[Expected]: ").append(expected.getT().toString()).append("\t\t[Actual]: ").append(actual.getT().toString()).toString());
        return result;
    }

    public boolean VerifyPartial(String description, FW_AnyType expected, FW_AnyType actual)
    {
        boolean result = true;
        try
        {
            Assert.assertEquals(actual.getT().toString().contains(expected.getT().toString()), true, description);
        }
        catch(AssertionError e)
        {
            result = false;
            logger.error((new StringBuilder("[VerifySafely] AssertionError: ")).append(description).append(" \t[Expected]: ").append(expected.getT().toString()).append("\t\t[Actual]: ").append(actual.getT().toString()).toString());
        }
        if(result)
            logger.info((new StringBuilder("VERIFIED - ")).append(description).append(" \t[Expected]: ").append(expected.getT().toString()).append("\t\t[Actual]: ").append(actual.getT().toString()).toString());
        return result;
    }

    FW_Drivers fw_Drivers;
    FW_PropertyReader fw_PropertyReader;
    FW_UtilFunctions fw_UtilFunctions;
    WebDriver d;
    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_Functions.getName());

}
