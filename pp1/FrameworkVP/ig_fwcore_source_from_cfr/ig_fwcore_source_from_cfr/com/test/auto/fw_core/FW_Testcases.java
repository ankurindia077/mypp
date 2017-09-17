/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.openqa.selenium.WebDriverException
 *  org.testng.Assert
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_AnyType;
import com.test.auto.fw_core.FW_Const;
import com.test.auto.fw_core.FW_Enums;
import com.test.auto.fw_core.FW_Init;
import com.test.auto.fw_core.FW_TestPlan;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

public class FW_Testcases
extends FW_TestPlan {
    private String testcaseID;
    private String testcaseName;
    private String testcaseFeature;
    private FW_Enums.testPhase tcPhase;
    private FW_Enums.testState tcState;
    private long startTime;
    private long endTime;
    private long totalExecutionTime;
    private boolean testResult;
    private static Logger logger = LogManager.getLogger((String)FW_Testcases.class.getName());

    private long getStartTime() {
        return this.startTime;
    }

    private long getEndTime() {
        return this.endTime;
    }

    private long getTotalExecutionTime() {
        return this.totalExecutionTime;
    }

    public boolean isResult() {
        return this.testResult;
    }

    private FW_Enums.testPhase getTcPhase() {
        return this.tcPhase;
    }

    public FW_Enums.testState getTcState() {
        return this.tcState;
    }

    public String getTestcaseID() {
        return this.testcaseID;
    }

    public String getTestcaseName() {
        return this.testcaseName;
    }

    public String getTestcaseFeature() {
        return this.testcaseFeature;
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

    public void setResult(boolean result) {
        this.testResult = result;
    }

    private void setTcPhase(FW_Enums.testPhase tcPhase) {
        this.tcPhase = tcPhase;
    }

    private void setTcState(FW_Enums.testState tcState) {
        this.tcState = tcState;
    }

    private void setTestcaseID(String testcaseID) {
        this.testcaseID = testcaseID;
    }

    private void setTestcaseName(String testcaseName) {
        this.testcaseName = testcaseName;
    }

    private void setTestcaseFeature(String testcaseFeature) {
        this.testcaseFeature = testcaseFeature;
    }

    public void setup() throws UnknownError {
        logger.error((Object)"[setup] setup() method not defined");
        throw new UnknownError("[ERROR] 'setup()' method not defined.");
    }

    public void test() throws UnknownError {
        logger.error((Object)"[test] test() method not defined");
        throw new UnknownError("[ERROR] 'test()' method not defined.");
    }

    public boolean verify() throws UnknownError {
        logger.error((Object)"[verify] verify() method not defined");
        throw new UnknownError("[ERROR] 'verify()' method not defined.");
    }

    public void teardown() throws UnknownError {
        logger.error((Object)"[teardown] teardown() method not defined");
        throw new UnknownError("[ERROR] 'teardown()' method not defined.");
    }

    public void run() throws UnknownError {
        boolean teardownExecuted = false;
        this.setStartTime(System.currentTimeMillis());
        logger.info((Object)("[RUN] Executing '" + this.getTestcaseName() + "' using '" + (Object)((Object)this.fw_Init.getBrowser()) + "' on '" + (Object)((Object)this.fw_Init.getPlatform()) + "'."));
        try {
            this.setTcPhase(FW_Enums.testPhase.NOT_STARTED);
            if (this.getTestcaseID() == "" || this.getTestcaseID() == null) {
                logger.error((Object)"[run] Testcase ID not set");
                throw new UnknownError("[ERROR] Testcase ID not set.");
            }
            if (this.getTestcaseID() == "" || this.getTestcaseID() == null) {
                logger.error((Object)"[run] Testcase description not set");
                throw new UnknownError("[ERROR] Testcase description not set.");
            }
            this.setTcState(FW_Enums.testState.TEST_PASS);
            this.setTcPhase(FW_Enums.testPhase.SETUP);
            this.setup();
            this.setTcPhase(FW_Enums.testPhase.TEST);
            this.test();
            this.setTcPhase(FW_Enums.testPhase.VERIFY);
            this.setResult(this.verify());
            this.setTcPhase(FW_Enums.testPhase.CLEANUP);
        }
        catch (UnknownError e) {
            this.markTCStateFail();
            logger.error((Object)("[run] UnknownError: " + e.getMessage()));
            this.SafeCleanup();
            teardownExecuted = true;
        }
        catch (WebDriverException e) {
            this.markTCStateFail();
            logger.error((Object)("[run] WebDriverException: " + e.getMessage()));
            this.SafeCleanup();
            teardownExecuted = true;
        }
        if (!teardownExecuted) {
            this.SafeCleanup();
        }
        this.setTcPhase(FW_Enums.testPhase.FINISHED);
        this.setEndTime(System.currentTimeMillis());
        this.setTotalExecutionTime();
    }

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

    private void SafeCleanup() {
        try {
            this.teardown();
        }
        catch (UnknownError e) {
            logger.warn((Object)("[SafeCleanup] UnknownError: " + e.getMessage()));
            this.setTcState(FW_Enums.testState.CLEANUP_FAIL);
        }
    }

    public void setTestcaseInfo(String testcaseID, String testcaseName, String testcaseFeature) {
        this.setTestcaseID(testcaseID);
        this.setTestcaseName(testcaseName);
        this.setTestcaseFeature(testcaseFeature);
    }

    public void printTestSummary() {
        if (this.getTotalExecutionTime() >= (long)FW_Const.SIXTY.intValue()) {
            logger.info((Object)("Executed in: " + this.getTotalExecutionTime() / (long)FW_Const.SIXTY.intValue() + " minutes."));
        } else {
            logger.info((Object)("Executed in: " + this.getTotalExecutionTime() + " seconds."));
        }
        if (this.isResult()) {
            logger.info((Object)("Testcase '" + this.getTestcaseName() + "' PASSED."));
        } else {
            logger.info((Object)("Testcase '" + this.getTestcaseName() + "' FAILED."));
            Assert.fail((String)("[printTestSummary] Testcase '" + this.getTestcaseName() + "' FAILED."));
        }
    }

    private void markTCStateFail() {
        if (this.getTcPhase() == FW_Enums.testPhase.NOT_STARTED) {
            this.setTcState(FW_Enums.testState.UNKNOWN);
        }
        if (this.getTcPhase() == FW_Enums.testPhase.SETUP) {
            this.setTcState(FW_Enums.testState.SETUP_FAIL);
        }
        if (this.getTcPhase() == FW_Enums.testPhase.TEST) {
            this.setTcState(FW_Enums.testState.TEST_FAIL);
        }
        if (this.getTcPhase() == FW_Enums.testPhase.VERIFY) {
            this.setTcState(FW_Enums.testState.VERIFY_FAIL);
        }
    }
}

