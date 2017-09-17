/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.testng.IRetryAnalyzer
 *  org.testng.ITestResult
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_PropertyReader;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FW_RetryAnalyzer
implements IRetryAnalyzer {
    FW_PropertyReader fw_PropertyReader = new FW_PropertyReader();
    private static Logger logger = LogManager.getLogger((String)FW_RetryAnalyzer.class.getName());
    int retryCount = 0;
    int retryMaxCount = Integer.parseInt(this.fw_PropertyReader.getAppProperty("FAILED_TEST_MAX_RETRY_COUNT"));

    public boolean retry(ITestResult tr) {
        if (!tr.getAttributeNames().contains("retry") && this.retryCount < this.retryMaxCount) {
            logger.info((Object)("Retrying " + tr.getName() + " for " + (this.retryCount + 1) + " of " + this.retryMaxCount + " times."));
            ++this.retryCount;
            return true;
        }
        return false;
    }
}

