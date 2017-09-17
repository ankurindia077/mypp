// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_UtilFunctions.java

package com.test.auto.fw_core;

import java.awt.Image;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

// Referenced classes of package com.test.auto.fw_core:
//            FW_PropertyReader, FW_Const, FW_Init, FW_Enums

public class FW_UtilFunctions
{

    public FW_UtilFunctions()
    {
        fw_PropertyReader = new FW_PropertyReader();
    }

    public void fixedWaitForSeconds(Integer seconds)
    {
        try
        {
            logger.debug((new StringBuilder("[fixedWaitForSeconds] Waiting for ")).append(seconds).append(" seconds").toString());
            Thread.sleep(seconds.intValue() * FW_Const.THOUSAND.intValue());
        }
        catch(InterruptedException e)
        {
            logger.error((new StringBuilder("[fixedWaitForSeconds] InterruptedException: ")).append(e.getMessage()).toString());
        }
    }

    public void killWebDriverProcesses(FW_Enums.browser browser)
    {
        if(browser == FW_Enums.browser.IE)
            try
            {
                Runtime rt = Runtime.getRuntime();
                logger.debug((new StringBuilder("[killWebDriverProcesses] Trying to kill process: ")).append(fw_PropertyReader.getFWXProperty("IE_WEBDRIVER")).toString());
                rt.exec((new StringBuilder("taskkill /F /IM ")).append(fw_PropertyReader.getFWXProperty("IE_WEBDRIVER")).toString());
            }
            catch(IOException e)
            {
                logger.error((new StringBuilder("[killWebDriverProcesses] IOException: ")).append(e.getMessage()).toString());
            }
        if(browser == FW_Enums.browser.CHROME)
            try
            {
                Runtime rt = Runtime.getRuntime();
                logger.debug((new StringBuilder("[killWebDriverProcesses] Trying to kill process: ")).append(fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER")).toString());
                rt.exec((new StringBuilder("taskkill /F /IM ")).append(fw_PropertyReader.getFWXProperty("CHROME_WEBDRIVER")).toString());
            }
            catch(IOException e)
            {
                logger.error((new StringBuilder("[killWebDriverProcesses] IOException: ")).append(e.getMessage()).toString());
            }
    }

    public boolean compareImage(Image expectedImage, Image actualImage)
    {
        boolean match = false;
        int pixelData1[] = null;
        int pixelData2[] = null;
        int width = 0;
        int height = 0;
        try
        {
            PixelGrabber pixelSet1 = new PixelGrabber(expectedImage, 0, 0, -1, -1, false);
            PixelGrabber pixelSet2 = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
            if(pixelSet1.grabPixels())
            {
                width = pixelSet1.getWidth();
                height = pixelSet1.getHeight();
                pixelData1 = new int[width * height];
                pixelData1 = (int[])pixelSet1.getPixels();
            }
            if(pixelSet2.grabPixels())
            {
                width = pixelSet2.getWidth();
                height = pixelSet2.getHeight();
                pixelData2 = new int[width * height];
                pixelData2 = (int[])pixelSet2.getPixels();
            }
            match = Arrays.equals(pixelData1, pixelData2);
        }
        catch(InterruptedException e)
        {
            logger.error((new StringBuilder("[compareImage] InterruptedException: ")).append(e.getMessage()).toString());
        }
        return match;
    }

    public String getAbsoluteTestDataFilePath(String l_strFilename)
    {
        FW_Init fw_Init = new FW_Init();
        String absolutePath = "";
        try
        {
            String filename = (new StringBuilder(String.valueOf(fw_Init.getWorkingDir()))).append("/").append(fw_PropertyReader.getFWXProperty("WORKING_DIR")).append("/").append("testdata\\csv\\").append(l_strFilename).toString();
            logger.debug((new StringBuilder("[getAbsoluteTestDataFilePath] File name: ")).append(filename).toString());
            File fileObj = new File(filename);
            if(fileObj.isFile() && fileObj.canRead())
            {
                absolutePath = fileObj.getAbsolutePath();
            } else
            {
                logger.error((new StringBuilder("[getAbsoluteTestDataFilePath] File not found! ")).append(filename).toString());
                throw new UnknownError("File not found!");
            }
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("Exception: File not found! ")).append(e.getMessage()).toString());
            throw new UnknownError("File not found!");
        }
        return absolutePath;
    }

    FW_PropertyReader fw_PropertyReader;
    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_UtilFunctions.getName());

}
