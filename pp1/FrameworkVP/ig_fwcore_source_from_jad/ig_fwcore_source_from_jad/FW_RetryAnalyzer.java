// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_RetryAnalyzer.java

package com.test.auto.fw_core;

import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// Referenced classes of package com.test.auto.fw_core:
//            FW_PropertyReader

public class FW_RetryAnalyzer
    implements IRetryAnalyzer
{

    public FW_RetryAnalyzer()
    {
        fw_PropertyReader = new FW_PropertyReader();
        retryCount = 0;
        retryMaxCount = Integer.parseInt(fw_PropertyReader.getAppProperty("FAILED_TEST_MAX_RETRY_COUNT"));
    }

    public boolean retry(ITestResult tr)
    {
        if(!tr.getAttributeNames().contains("retry") && retryCount < retryMaxCount)
        {
            logger.info((new StringBuilder("Retrying ")).append(tr.getName()).append(" for ").append(retryCount + 1).append(" of ").append(retryMaxCount).append(" times.").toString());
            retryCount++;
            return true;
        } else
        {
            return false;
        }
    }

    FW_PropertyReader fw_PropertyReader;
    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_RetryAnalyzer.getName());
    int retryCount;
    int retryMaxCount;

}
