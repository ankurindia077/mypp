// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_Testcases.java

package com.test.auto.fw_core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

// Referenced classes of package com.test.auto.fw_core:
//            FW_TestPlan, FW_Const, FW_Init, FW_AnyType, 
//            FW_Enums

public class FW_Testcases extends FW_TestPlan
{

    public FW_Testcases()
    {
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

    public boolean isResult()
    {
        return testResult;
    }

    private FW_Enums.testPhase getTcPhase()
    {
        return tcPhase;
    }

    public FW_Enums.testState getTcState()
    {
        return tcState;
    }

    public String getTestcaseID()
    {
        return testcaseID;
    }

    public String getTestcaseName()
    {
        return testcaseName;
    }

    public String getTestcaseFeature()
    {
        return testcaseFeature;
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

    public void setResult(boolean result)
    {
        testResult = result;
    }

    private void setTcPhase(FW_Enums.testPhase tcPhase)
    {
        this.tcPhase = tcPhase;
    }

    private void setTcState(FW_Enums.testState tcState)
    {
        this.tcState = tcState;
    }

    private void setTestcaseID(String testcaseID)
    {
        this.testcaseID = testcaseID;
    }

    private void setTestcaseName(String testcaseName)
    {
        this.testcaseName = testcaseName;
    }

    private void setTestcaseFeature(String testcaseFeature)
    {
        this.testcaseFeature = testcaseFeature;
    }

    public void setup()
        throws UnknownError
    {
        logger.error("[setup] setup() method not defined");
        throw new UnknownError("[ERROR] 'setup()' method not defined.");
    }

    public void test()
        throws UnknownError
    {
        logger.error("[test] test() method not defined");
        throw new UnknownError("[ERROR] 'test()' method not defined.");
    }

    public boolean verify()
        throws UnknownError
    {
        logger.error("[verify] verify() method not defined");
        throw new UnknownError("[ERROR] 'verify()' method not defined.");
    }

    public void teardown()
        throws UnknownError
    {
        logger.error("[teardown] teardown() method not defined");
        throw new UnknownError("[ERROR] 'teardown()' method not defined.");
    }

    public void run()
        throws UnknownError
    {
        boolean teardownExecuted = false;
        setStartTime(System.currentTimeMillis());
        logger.info((new StringBuilder("[RUN] Executing '")).append(getTestcaseName()).append("' using '").append(fw_Init.getBrowser()).append("' on '").append(fw_Init.getPlatform()).append("'.").toString());
        try
        {
            setTcPhase(FW_Enums.testPhase.NOT_STARTED);
            if(getTestcaseID() == "" || getTestcaseID() == null)
            {
                logger.error("[run] Testcase ID not set");
                throw new UnknownError("[ERROR] Testcase ID not set.");
            }
            if(getTestcaseID() == "" || getTestcaseID() == null)
            {
                logger.error("[run] Testcase description not set");
                throw new UnknownError("[ERROR] Testcase description not set.");
            }
            setTcState(FW_Enums.testState.TEST_PASS);
            setTcPhase(FW_Enums.testPhase.SETUP);
            setup();
            setTcPhase(FW_Enums.testPhase.TEST);
            test();
            setTcPhase(FW_Enums.testPhase.VERIFY);
            setResult(verify());
            setTcPhase(FW_Enums.testPhase.CLEANUP);
        }
        catch(UnknownError e)
        {
            markTCStateFail();
            logger.error((new StringBuilder("[run] UnknownError: ")).append(e.getMessage()).toString());
            SafeCleanup();
            teardownExecuted = true;
        }
        catch(WebDriverException e)
        {
            markTCStateFail();
            logger.error((new StringBuilder("[run] WebDriverException: ")).append(e.getMessage()).toString());
            SafeCleanup();
            teardownExecuted = true;
        }
        if(!teardownExecuted)
            SafeCleanup();
        setTcPhase(FW_Enums.testPhase.FINISHED);
        setEndTime(System.currentTimeMillis());
        setTotalExecutionTime();
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

    private void SafeCleanup()
    {
        try
        {
            teardown();
        }
        catch(UnknownError e)
        {
            logger.warn((new StringBuilder("[SafeCleanup] UnknownError: ")).append(e.getMessage()).toString());
            setTcState(FW_Enums.testState.CLEANUP_FAIL);
        }
    }

    public void setTestcaseInfo(String testcaseID, String testcaseName, String testcaseFeature)
    {
        setTestcaseID(testcaseID);
        setTestcaseName(testcaseName);
        setTestcaseFeature(testcaseFeature);
    }

    public void printTestSummary()
    {
        if(getTotalExecutionTime() >= (long)FW_Const.SIXTY.intValue())
            logger.info((new StringBuilder("Executed in: ")).append(getTotalExecutionTime() / (long)FW_Const.SIXTY.intValue()).append(" minutes.").toString());
        else
            logger.info((new StringBuilder("Executed in: ")).append(getTotalExecutionTime()).append(" seconds.").toString());
        if(isResult())
        {
            logger.info((new StringBuilder("Testcase '")).append(getTestcaseName()).append("' PASSED.").toString());
        } else
        {
            logger.info((new StringBuilder("Testcase '")).append(getTestcaseName()).append("' FAILED.").toString());
            Assert.fail((new StringBuilder("[printTestSummary] Testcase '")).append(getTestcaseName()).append("' FAILED.").toString());
        }
    }

    private void markTCStateFail()
    {
        if(getTcPhase() == FW_Enums.testPhase.NOT_STARTED)
            setTcState(FW_Enums.testState.UNKNOWN);
        if(getTcPhase() == FW_Enums.testPhase.SETUP)
            setTcState(FW_Enums.testState.SETUP_FAIL);
        if(getTcPhase() == FW_Enums.testPhase.TEST)
            setTcState(FW_Enums.testState.TEST_FAIL);
        if(getTcPhase() == FW_Enums.testPhase.VERIFY)
            setTcState(FW_Enums.testState.VERIFY_FAIL);
    }

    private String testcaseID;
    private String testcaseName;
    private String testcaseFeature;
    private FW_Enums.testPhase tcPhase;
    private FW_Enums.testState tcState;
    private long startTime;
    private long endTime;
    private long totalExecutionTime;
    private boolean testResult;
    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_Testcases.getName());

}
