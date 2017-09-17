/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_Const;
import com.test.auto.fw_core.FW_Enums;
import com.test.auto.fw_core.FW_Init;
import com.test.auto.fw_core.FW_PropertyReader;
import java.awt.Image;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FW_UtilFunctions {
    FW_PropertyReader fw_PropertyReader = new FW_PropertyReader();
    private static Logger logger = LogManager.getLogger((String)FW_UtilFunctions.class.getName());

    public void fixedWaitForSeconds(Integer seconds) {
        try {
            logger.debug((Object)("[fixedWaitForSeconds] Waiting for " + seconds + " seconds"));
            Thread.sleep(seconds * FW_Const.THOUSAND);
        }
        catch (InterruptedException e) {
            logger.error((Object)("[fixedWaitForSeconds] InterruptedException: " + e.getMessage()));
        }
    }

    public void killWebDriverProcesses(FW_Enums.browser browser2) {
        Runtime rt;
        if (browser2 == FW_Enums.browser.IE) {
            try {
                rt = Runtime.getRuntime();
                logger.debug((Object)("[killWebDriverProcesses] Trying to kill process: " + this.fw_PropertyReader.getFWXProperty("IE_WEBDRIVER")));
                rt.exec("taskkill /F /IM " + this.fw_PropertyReader.getFWXProperty("IE_WEBDRIVER"));
            }
            catch (IOException e) {
                logger.error((Object)("[killWebDriverProcesses] IOException: " + e.getMessage()));
            }
        }
        if (browser2 == FW_Enums.browser.CHROME) {
            try {
                rt = Runtime.getRuntime();
                logger.debug((Object)("[killWebDriverProcesses] Trying to kill process: " + this.fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER")));
                rt.exec("taskkill /F /IM " + this.fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER"));
            }
            catch (IOException e) {
                logger.error((Object)("[killWebDriverProcesses] IOException: " + e.getMessage()));
            }
        }
    }

    public boolean compareImage(Image expectedImage, Image actualImage) {
        boolean match = false;
        int[] pixelData1 = null;
        int[] pixelData2 = null;
        int width = 0;
        int height = 0;
        try {
            PixelGrabber pixelSet1 = new PixelGrabber(expectedImage, 0, 0, -1, -1, false);
            PixelGrabber pixelSet2 = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
            if (pixelSet1.grabPixels()) {
                width = pixelSet1.getWidth();
                height = pixelSet1.getHeight();
                pixelData1 = new int[width * height];
                pixelData1 = (int[])pixelSet1.getPixels();
            }
            if (pixelSet2.grabPixels()) {
                width = pixelSet2.getWidth();
                height = pixelSet2.getHeight();
                pixelData2 = new int[width * height];
                pixelData2 = (int[])pixelSet2.getPixels();
            }
            match = Arrays.equals(pixelData1, pixelData2);
        }
        catch (InterruptedException e) {
            logger.error((Object)("[compareImage] InterruptedException: " + e.getMessage()));
        }
        return match;
    }

    public String getAbsoluteTestDataFilePath(String l_strFilename) {
        String absolutePath;
        block3 : {
            FW_Init fw_Init = new FW_Init();
            absolutePath = "";
            try {
                String filename = String.valueOf(fw_Init.getWorkingDir()) + "/" + this.fw_PropertyReader.getFWXProperty("WORKING_DIR") + "/" + "testdata\\csv\\" + l_strFilename;
                logger.debug((Object)("[getAbsoluteTestDataFilePath] File name: " + filename));
                File fileObj = new File(filename);
                if (fileObj.isFile() && fileObj.canRead()) {
                    absolutePath = fileObj.getAbsolutePath();
                    break block3;
                }
                logger.error((Object)("[getAbsoluteTestDataFilePath] File not found! " + filename));
                throw new UnknownError("File not found!");
            }
            catch (Exception e) {
                logger.error((Object)("Exception: File not found! " + e.getMessage()));
                throw new UnknownError("File not found!");
            }
        }
        return absolutePath;
    }
}

