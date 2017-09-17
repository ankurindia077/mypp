/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Function
 *  org.apache.commons.io.FileUtils
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.openqa.selenium.Alert
 *  org.openqa.selenium.By
 *  org.openqa.selenium.Dimension
 *  org.openqa.selenium.JavascriptExecutor
 *  org.openqa.selenium.NoAlertPresentException
 *  org.openqa.selenium.NoSuchWindowException
 *  org.openqa.selenium.OutputType
 *  org.openqa.selenium.Point
 *  org.openqa.selenium.StaleElementReferenceException
 *  org.openqa.selenium.TakesScreenshot
 *  org.openqa.selenium.WebDriver
 *  org.openqa.selenium.WebDriver$TargetLocator
 *  org.openqa.selenium.WebElement
 *  org.openqa.selenium.interactions.internal.Coordinates
 *  org.openqa.selenium.internal.Locatable
 *  org.openqa.selenium.support.ui.ExpectedConditions
 *  org.openqa.selenium.support.ui.WebDriverWait
 *  org.testng.Assert
 */
package com.test.auto.fw_core;

import com.google.common.base.Function;
import com.test.auto.fw_core.FW_AnyType;
import com.test.auto.fw_core.FW_Const;
import com.test.auto.fw_core.FW_Drivers;
import com.test.auto.fw_core.FW_Init;
import com.test.auto.fw_core.FW_PropertyReader;
import com.test.auto.fw_core.FW_UtilFunctions;
import com.test.auto.fw_core.I_FW_Functions;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FW_Functions
implements I_FW_Functions {
    FW_Drivers fw_Drivers = new FW_Drivers();
    FW_PropertyReader fw_PropertyReader = new FW_PropertyReader();
    FW_UtilFunctions fw_UtilFunctions = new FW_UtilFunctions();
    WebDriver d = this.fw_Drivers.getDriver();
    private static Logger logger = LogManager.getLogger((String)FW_Functions.class.getName());

    @Override
    public void launch(String url) {
        logger.debug((Object)("[launch] Launching application with URL '" + url + "'."));
        try {
            this.d.get(url);
        }
        catch (Exception e) {
            logger.error((Object)("Exception: " + e.getMessage()));
        }
    }

    @Override
    public void executeJS(String scriptName) {
        logger.debug((Object)("[executeJS] Executing Javascript: " + scriptName));
        JavascriptExecutor js = (JavascriptExecutor)this.d;
        js.executeScript(scriptName, new Object[0]);
    }

    @Override
    public void overrideLink() {
        try {
            this.d.get("javascript:document.getElementById('overridelink').click();");
        }
        catch (Exception e) {
            logger.error((Object)("[overrideLink] Exception: " + e.getMessage()));
        }
    }

    @Override
    public boolean isAlertPresent() {
        this.fw_UtilFunctions.fixedWaitForSeconds(Integer.parseInt(this.fw_PropertyReader.getFWXProperty("EXEC_SPEED_CONTROLLER_SECONDS")));
        try {
            this.d.switchTo().alert();
            logger.debug((Object)"[isAlertPresent] Switching to Alert");
            return true;
        }
        catch (NoAlertPresentException Ex) {
            logger.error((Object)("[isAlertPresent] NoAlertPresentException: " + Ex.getMessage()));
            return false;
        }
    }

    @Override
    public void waitForElement(By by, String elementTitle, Integer timeoutInSeconds) {
        this.fw_UtilFunctions.fixedWaitForSeconds(Integer.parseInt(this.fw_PropertyReader.getFWXProperty("EXEC_SPEED_CONTROLLER_SECONDS")));
        WebDriverWait wait = new WebDriverWait(this.d, (long)timeoutInSeconds.intValue());
        wait.until((Function)ExpectedConditions.presenceOfElementLocated((By)by));
    }

    @Override
    public void waitForElementToDisappear(By by, String elementTitle, Integer timeoutInSeconds) {
        this.fw_UtilFunctions.fixedWaitForSeconds(Integer.parseInt(this.fw_PropertyReader.getFWXProperty("EXEC_SPEED_CONTROLLER_SECONDS")));
        Integer waitedFor = 0;
        WebDriverWait wait = new WebDriverWait(this.d, (long)timeoutInSeconds.intValue());
        WebElement waitForElement = (WebElement)wait.until((Function)ExpectedConditions.presenceOfElementLocated((By)by));
        try {
            while (waitForElement.isDisplayed()) {
                this.fw_UtilFunctions.fixedWaitForSeconds(FW_Const.THREE);
                waitedFor = waitedFor + FW_Const.THREE;
                if (waitedFor < timeoutInSeconds) continue;
                logger.error((Object)("[waitForElementToDisappear] TIMEOUT: Elemet is still displayed even after " + timeoutInSeconds + " seconds"));
                break;
            }
        }
        catch (StaleElementReferenceException ex) {
            logger.error((Object)("[waitForElementToDisappear] StaleElementReferenceException: " + ex.getMessage()));
            this.fw_UtilFunctions.fixedWaitForSeconds(FW_Const.ONE);
        }
    }

    @Override
    public void closeAllButMainWin() {
        FW_Init fw_Init = new FW_Init();
        Set handles = this.d.getWindowHandles();
        if (handles.size() > 1) {
            handles.remove(fw_Init.getMainWindow());
            for (String windowHandle : handles) {
                if (windowHandle.equals(fw_Init.getMainWindow())) continue;
                this.d.switchTo().window(windowHandle);
                try {
                    logger.debug((Object)("[closeAllButMainWin] Trying to close window with title: " + this.d.getTitle()));
                    this.d.close();
                    continue;
                }
                catch (NoSuchWindowException e) {
                    logger.warn((Object)("[closeAllButMainWin] NoSuchWindowException: " + e.getMessage()));
                }
            }
        }
    }

    @Override
    public void captureWebElementImage(WebElement ele, String imageFolder, String imageName) {
        imageFolder = String.valueOf(imageFolder) + this.fw_PropertyReader.getFWXProperty("BROWSER") + "/";
        logger.debug((Object)("[captureWebElementImage] Image folder: " + imageFolder));
        File screenshot = (File)((TakesScreenshot)this.d).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = null;
        try {
            fullImg = ImageIO.read(screenshot);
        }
        catch (IOException e) {
            logger.error((Object)("[captureWebElementImage] IOException: " + e.getMessage()));
        }
        Coordinates location = ((Locatable)ele).getCoordinates();
        Point point = location.inViewPort();
        int eleWidth = ele.getSize().getWidth() + 2;
        int eleHeight = ele.getSize().getHeight() + 2;
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        try {
            ImageIO.write((RenderedImage)eleScreenshot, "png", screenshot);
        }
        catch (IOException e) {
            logger.error((Object)("[captureWebElementImage] IOException: " + e.getMessage()));
        }
        try {
            FileUtils.copyFile((File)screenshot, (File)new File(String.valueOf(imageFolder) + imageName + ".png"));
            logger.debug((Object)("[captureWebElementImage] Saving WebElement image: " + imageFolder + imageName + ".png"));
        }
        catch (IOException e) {
            logger.error((Object)("[captureWebElementImage] IOException: " + e.getMessage()));
        }
    }

    @Override
    public void captureScreenshot(String testcaseName, String imageName) {
    }

    @Override
    public void linkScreenShotsToHTMLReport(String testcaseName) {
    }

    @Override
    public boolean VerifySafely(String description, FW_AnyType<?> expected, FW_AnyType<?> actual) {
        boolean result = true;
        try {
            Assert.assertEquals(actual.getT(), expected.getT(), (String)description);
        }
        catch (AssertionError e) {
            result = false;
            logger.error((Object)("[VerifySafely] AssertionError: " + description + " \t[Expected]: " + expected.getT().toString() + "\t\t[Actual]: " + actual.getT().toString()));
        }
        if (result) {
            logger.info((Object)("VERIFIED - " + description + " \t[Expected]: " + expected.getT().toString() + "\t\t[Actual]: " + actual.getT().toString()));
        }
        return result;
    }

    @Override
    public boolean VerifyPartial(String description, FW_AnyType<?> expected, FW_AnyType<?> actual) {
        boolean result = true;
        try {
            Assert.assertEquals((boolean)actual.getT().toString().contains(expected.getT().toString()), (boolean)true, (String)description);
        }
        catch (AssertionError e) {
            result = false;
            logger.error((Object)("[VerifySafely] AssertionError: " + description + " \t[Expected]: " + expected.getT().toString() + "\t\t[Actual]: " + actual.getT().toString()));
        }
        if (result) {
            logger.info((Object)("VERIFIED - " + description + " \t[Expected]: " + expected.getT().toString() + "\t\t[Actual]: " + actual.getT().toString()));
        }
        return result;
    }
}

