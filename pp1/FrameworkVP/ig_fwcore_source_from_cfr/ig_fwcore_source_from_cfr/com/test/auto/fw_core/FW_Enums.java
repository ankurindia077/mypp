/*
 * Decompiled with CFR 0_115.
 */
package com.test.auto.fw_core;

public class FW_Enums {

    public static enum Features {
        CORE(0),
        REPORTING(1),
        DATA_READER(2);
        
        private final int value;

        private Features(String newValue, int n2, int n3) {
            this.value = newValue;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static enum apptype {
        WEB,
        NATIVE,
        HYBRID,
        GUI;
        

        private apptype(String string2, int n2) {
        }
    }

    public static enum browser {
        IE,
        FIREFOX,
        CHROME,
        ELECTRON,
        SAFARI,
        GUIAPP,
        NATIVEAPP;
        

        private browser(String string2, int n2) {
        }
    }

    public static enum logAs {
        INFO,
        WARNING,
        PASSED,
        FAILED;
        

        private logAs(String string2, int n2) {
        }
    }

    public static enum mobiletool {
        APPIUM,
        SEETEST;
        

        private mobiletool(String string2, int n2) {
        }
    }

    public static enum months {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;
        

        private months(String string2, int n2) {
        }
    }

    public static enum platform {
        WINDOWS,
        MAC,
        ANDROID,
        IOS;
        

        private platform(String string2, int n2) {
        }
    }

    public static enum screenshotOf {
        BROWSER_PAGE,
        DESKTOP;
        

        private screenshotOf(String string2, int n2) {
        }
    }

    public static enum testPhase {
        NOT_STARTED,
        SETUP,
        TEST,
        VERIFY,
        CLEANUP,
        FINISHED;
        

        private testPhase(String string2, int n2) {
        }
    }

    public static enum testState {
        UNKNOWN,
        SETUP_FAIL,
        SETUP_PASS,
        TEST_FAIL,
        TEST_PASS,
        VERIFY_FAIL,
        VERIFY_PASS,
        CLEANUP_FAIL,
        CLEANUP_PASS;
        

        private testState(String string2, int n2) {
        }
    }

    public static enum truefalse {
        TRUE,
        FALSE;
        

        private truefalse(String string2, int n2) {
        }
    }

    public static enum yesno {
        YES,
        NO;
        

        private yesno(String string2, int n2) {
        }
    }

}

