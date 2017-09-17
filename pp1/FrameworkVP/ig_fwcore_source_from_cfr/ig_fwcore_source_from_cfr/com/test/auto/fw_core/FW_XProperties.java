/*
 * Decompiled with CFR 0_115.
 */
package com.test.auto.fw_core;

import java.util.Properties;

public class FW_XProperties
extends Properties {
    private static final String START_CONST = "{";
    private static final String END_CONST = "}";
    private static final int MAX_SUBST_DEPTH = 5;

    public FW_XProperties() {
    }

    public FW_XProperties(Properties defaults) {
        super(defaults);
    }

    @Override
    public String getProperty(String key) {
        return this.getProperty(key, 0);
    }

    private String getProperty(String key, int level) {
        String value = super.getProperty(key);
        if (value != null) {
            int beginIndex = 0;
            int startName = value.indexOf("{", beginIndex);
            while (startName != -1) {
                if (level + 1 > 5) {
                    return value;
                }
                int endName = value.indexOf("}", startName);
                if (endName == -1) {
                    return value;
                }
                String constName = value.substring(startName + 1, endName);
                String constValue = this.getProperty(constName, level + 1);
                if (constValue == null) {
                    return value;
                }
                String newValue = startName > 0 ? value.substring(0, startName) : "";
                newValue = String.valueOf(newValue) + constValue;
                beginIndex = newValue.length();
                value = newValue = String.valueOf(newValue) + value.substring(endName + 1);
                startName = value.indexOf("{", beginIndex);
            }
        }
        return value;
    }
}

