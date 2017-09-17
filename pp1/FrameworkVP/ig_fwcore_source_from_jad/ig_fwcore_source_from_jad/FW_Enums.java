// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_Enums.java

package com.test.auto.fw_core;


public class FW_Enums
{
    public static final class Features extends Enum
    {

        public int getValue()
        {
            return value;
        }

        public static Features[] values()
        {
            Features afeatures[];
            int i;
            Features afeatures1[];
            System.arraycopy(afeatures = ENUM$VALUES, 0, afeatures1 = new Features[i = afeatures.length], 0, i);
            return afeatures1;
        }

        public static Features valueOf(String s)
        {
            return (Features)Enum.valueOf(com/test/auto/fw_core/FW_Enums$Features, s);
        }

        public static final Features CORE;
        public static final Features REPORTING;
        public static final Features DATA_READER;
        private final int value;
        private static final Features ENUM$VALUES[];

        static 
        {
            CORE = new Features("CORE", 0, 0);
            REPORTING = new Features("REPORTING", 1, 1);
            DATA_READER = new Features("DATA_READER", 2, 2);
            ENUM$VALUES = (new Features[] {
                CORE, REPORTING, DATA_READER
            });
        }

        private Features(String s, int i, int newValue)
        {
            super(s, i);
            value = newValue;
        }
    }

    public static final class apptype extends Enum
    {

        public static apptype[] values()
        {
            apptype aapptype[];
            int i;
            apptype aapptype1[];
            System.arraycopy(aapptype = ENUM$VALUES, 0, aapptype1 = new apptype[i = aapptype.length], 0, i);
            return aapptype1;
        }

        public static apptype valueOf(String s)
        {
            return (apptype)Enum.valueOf(com/test/auto/fw_core/FW_Enums$apptype, s);
        }

        public static final apptype WEB;
        public static final apptype NATIVE;
        public static final apptype HYBRID;
        public static final apptype GUI;
        private static final apptype ENUM$VALUES[];

        static 
        {
            WEB = new apptype("WEB", 0);
            NATIVE = new apptype("NATIVE", 1);
            HYBRID = new apptype("HYBRID", 2);
            GUI = new apptype("GUI", 3);
            ENUM$VALUES = (new apptype[] {
                WEB, NATIVE, HYBRID, GUI
            });
        }

        private apptype(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class browser extends Enum
    {

        public static browser[] values()
        {
            browser abrowser[];
            int i;
            browser abrowser1[];
            System.arraycopy(abrowser = ENUM$VALUES, 0, abrowser1 = new browser[i = abrowser.length], 0, i);
            return abrowser1;
        }

        public static browser valueOf(String s)
        {
            return (browser)Enum.valueOf(com/test/auto/fw_core/FW_Enums$browser, s);
        }

        public static final browser IE;
        public static final browser FIREFOX;
        public static final browser CHROME;
        public static final browser ELECTRON;
        public static final browser SAFARI;
        public static final browser GUIAPP;
        public static final browser NATIVEAPP;
        private static final browser ENUM$VALUES[];

        static 
        {
            IE = new browser("IE", 0);
            FIREFOX = new browser("FIREFOX", 1);
            CHROME = new browser("CHROME", 2);
            ELECTRON = new browser("ELECTRON", 3);
            SAFARI = new browser("SAFARI", 4);
            GUIAPP = new browser("GUIAPP", 5);
            NATIVEAPP = new browser("NATIVEAPP", 6);
            ENUM$VALUES = (new browser[] {
                IE, FIREFOX, CHROME, ELECTRON, SAFARI, GUIAPP, NATIVEAPP
            });
        }

        private browser(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class logAs extends Enum
    {

        public static logAs[] values()
        {
            logAs alogas[];
            int i;
            logAs alogas1[];
            System.arraycopy(alogas = ENUM$VALUES, 0, alogas1 = new logAs[i = alogas.length], 0, i);
            return alogas1;
        }

        public static logAs valueOf(String s)
        {
            return (logAs)Enum.valueOf(com/test/auto/fw_core/FW_Enums$logAs, s);
        }

        public static final logAs INFO;
        public static final logAs WARNING;
        public static final logAs PASSED;
        public static final logAs FAILED;
        private static final logAs ENUM$VALUES[];

        static 
        {
            INFO = new logAs("INFO", 0);
            WARNING = new logAs("WARNING", 1);
            PASSED = new logAs("PASSED", 2);
            FAILED = new logAs("FAILED", 3);
            ENUM$VALUES = (new logAs[] {
                INFO, WARNING, PASSED, FAILED
            });
        }

        private logAs(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class mobiletool extends Enum
    {

        public static mobiletool[] values()
        {
            mobiletool amobiletool[];
            int i;
            mobiletool amobiletool1[];
            System.arraycopy(amobiletool = ENUM$VALUES, 0, amobiletool1 = new mobiletool[i = amobiletool.length], 0, i);
            return amobiletool1;
        }

        public static mobiletool valueOf(String s)
        {
            return (mobiletool)Enum.valueOf(com/test/auto/fw_core/FW_Enums$mobiletool, s);
        }

        public static final mobiletool APPIUM;
        public static final mobiletool SEETEST;
        private static final mobiletool ENUM$VALUES[];

        static 
        {
            APPIUM = new mobiletool("APPIUM", 0);
            SEETEST = new mobiletool("SEETEST", 1);
            ENUM$VALUES = (new mobiletool[] {
                APPIUM, SEETEST
            });
        }

        private mobiletool(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class months extends Enum
    {

        public static months[] values()
        {
            months amonths[];
            int i;
            months amonths1[];
            System.arraycopy(amonths = ENUM$VALUES, 0, amonths1 = new months[i = amonths.length], 0, i);
            return amonths1;
        }

        public static months valueOf(String s)
        {
            return (months)Enum.valueOf(com/test/auto/fw_core/FW_Enums$months, s);
        }

        public static final months JANUARY;
        public static final months FEBRUARY;
        public static final months MARCH;
        public static final months APRIL;
        public static final months MAY;
        public static final months JUNE;
        public static final months JULY;
        public static final months AUGUST;
        public static final months SEPTEMBER;
        public static final months OCTOBER;
        public static final months NOVEMBER;
        public static final months DECEMBER;
        private static final months ENUM$VALUES[];

        static 
        {
            JANUARY = new months("JANUARY", 0);
            FEBRUARY = new months("FEBRUARY", 1);
            MARCH = new months("MARCH", 2);
            APRIL = new months("APRIL", 3);
            MAY = new months("MAY", 4);
            JUNE = new months("JUNE", 5);
            JULY = new months("JULY", 6);
            AUGUST = new months("AUGUST", 7);
            SEPTEMBER = new months("SEPTEMBER", 8);
            OCTOBER = new months("OCTOBER", 9);
            NOVEMBER = new months("NOVEMBER", 10);
            DECEMBER = new months("DECEMBER", 11);
            ENUM$VALUES = (new months[] {
                JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, 
                NOVEMBER, DECEMBER
            });
        }

        private months(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class platform extends Enum
    {

        public static platform[] values()
        {
            platform aplatform[];
            int i;
            platform aplatform1[];
            System.arraycopy(aplatform = ENUM$VALUES, 0, aplatform1 = new platform[i = aplatform.length], 0, i);
            return aplatform1;
        }

        public static platform valueOf(String s)
        {
            return (platform)Enum.valueOf(com/test/auto/fw_core/FW_Enums$platform, s);
        }

        public static final platform WINDOWS;
        public static final platform MAC;
        public static final platform ANDROID;
        public static final platform IOS;
        private static final platform ENUM$VALUES[];

        static 
        {
            WINDOWS = new platform("WINDOWS", 0);
            MAC = new platform("MAC", 1);
            ANDROID = new platform("ANDROID", 2);
            IOS = new platform("IOS", 3);
            ENUM$VALUES = (new platform[] {
                WINDOWS, MAC, ANDROID, IOS
            });
        }

        private platform(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class screenshotOf extends Enum
    {

        public static screenshotOf[] values()
        {
            screenshotOf ascreenshotof[];
            int i;
            screenshotOf ascreenshotof1[];
            System.arraycopy(ascreenshotof = ENUM$VALUES, 0, ascreenshotof1 = new screenshotOf[i = ascreenshotof.length], 0, i);
            return ascreenshotof1;
        }

        public static screenshotOf valueOf(String s)
        {
            return (screenshotOf)Enum.valueOf(com/test/auto/fw_core/FW_Enums$screenshotOf, s);
        }

        public static final screenshotOf BROWSER_PAGE;
        public static final screenshotOf DESKTOP;
        private static final screenshotOf ENUM$VALUES[];

        static 
        {
            BROWSER_PAGE = new screenshotOf("BROWSER_PAGE", 0);
            DESKTOP = new screenshotOf("DESKTOP", 1);
            ENUM$VALUES = (new screenshotOf[] {
                BROWSER_PAGE, DESKTOP
            });
        }

        private screenshotOf(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class testPhase extends Enum
    {

        public static testPhase[] values()
        {
            testPhase atestphase[];
            int i;
            testPhase atestphase1[];
            System.arraycopy(atestphase = ENUM$VALUES, 0, atestphase1 = new testPhase[i = atestphase.length], 0, i);
            return atestphase1;
        }

        public static testPhase valueOf(String s)
        {
            return (testPhase)Enum.valueOf(com/test/auto/fw_core/FW_Enums$testPhase, s);
        }

        public static final testPhase NOT_STARTED;
        public static final testPhase SETUP;
        public static final testPhase TEST;
        public static final testPhase VERIFY;
        public static final testPhase CLEANUP;
        public static final testPhase FINISHED;
        private static final testPhase ENUM$VALUES[];

        static 
        {
            NOT_STARTED = new testPhase("NOT_STARTED", 0);
            SETUP = new testPhase("SETUP", 1);
            TEST = new testPhase("TEST", 2);
            VERIFY = new testPhase("VERIFY", 3);
            CLEANUP = new testPhase("CLEANUP", 4);
            FINISHED = new testPhase("FINISHED", 5);
            ENUM$VALUES = (new testPhase[] {
                NOT_STARTED, SETUP, TEST, VERIFY, CLEANUP, FINISHED
            });
        }

        private testPhase(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class testState extends Enum
    {

        public static testState[] values()
        {
            testState ateststate[];
            int i;
            testState ateststate1[];
            System.arraycopy(ateststate = ENUM$VALUES, 0, ateststate1 = new testState[i = ateststate.length], 0, i);
            return ateststate1;
        }

        public static testState valueOf(String s)
        {
            return (testState)Enum.valueOf(com/test/auto/fw_core/FW_Enums$testState, s);
        }

        public static final testState UNKNOWN;
        public static final testState SETUP_FAIL;
        public static final testState SETUP_PASS;
        public static final testState TEST_FAIL;
        public static final testState TEST_PASS;
        public static final testState VERIFY_FAIL;
        public static final testState VERIFY_PASS;
        public static final testState CLEANUP_FAIL;
        public static final testState CLEANUP_PASS;
        private static final testState ENUM$VALUES[];

        static 
        {
            UNKNOWN = new testState("UNKNOWN", 0);
            SETUP_FAIL = new testState("SETUP_FAIL", 1);
            SETUP_PASS = new testState("SETUP_PASS", 2);
            TEST_FAIL = new testState("TEST_FAIL", 3);
            TEST_PASS = new testState("TEST_PASS", 4);
            VERIFY_FAIL = new testState("VERIFY_FAIL", 5);
            VERIFY_PASS = new testState("VERIFY_PASS", 6);
            CLEANUP_FAIL = new testState("CLEANUP_FAIL", 7);
            CLEANUP_PASS = new testState("CLEANUP_PASS", 8);
            ENUM$VALUES = (new testState[] {
                UNKNOWN, SETUP_FAIL, SETUP_PASS, TEST_FAIL, TEST_PASS, VERIFY_FAIL, VERIFY_PASS, CLEANUP_FAIL, CLEANUP_PASS
            });
        }

        private testState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class truefalse extends Enum
    {

        public static truefalse[] values()
        {
            truefalse atruefalse[];
            int i;
            truefalse atruefalse1[];
            System.arraycopy(atruefalse = ENUM$VALUES, 0, atruefalse1 = new truefalse[i = atruefalse.length], 0, i);
            return atruefalse1;
        }

        public static truefalse valueOf(String s)
        {
            return (truefalse)Enum.valueOf(com/test/auto/fw_core/FW_Enums$truefalse, s);
        }

        public static final truefalse TRUE;
        public static final truefalse FALSE;
        private static final truefalse ENUM$VALUES[];

        static 
        {
            TRUE = new truefalse("TRUE", 0);
            FALSE = new truefalse("FALSE", 1);
            ENUM$VALUES = (new truefalse[] {
                TRUE, FALSE
            });
        }

        private truefalse(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class yesno extends Enum
    {

        public static yesno[] values()
        {
            yesno ayesno[];
            int i;
            yesno ayesno1[];
            System.arraycopy(ayesno = ENUM$VALUES, 0, ayesno1 = new yesno[i = ayesno.length], 0, i);
            return ayesno1;
        }

        public static yesno valueOf(String s)
        {
            return (yesno)Enum.valueOf(com/test/auto/fw_core/FW_Enums$yesno, s);
        }

        public static final yesno YES;
        public static final yesno NO;
        private static final yesno ENUM$VALUES[];

        static 
        {
            YES = new yesno("YES", 0);
            NO = new yesno("NO", 1);
            ENUM$VALUES = (new yesno[] {
                YES, NO
            });
        }

        private yesno(String s, int i)
        {
            super(s, i);
        }
    }


    public FW_Enums()
    {
    }
}
