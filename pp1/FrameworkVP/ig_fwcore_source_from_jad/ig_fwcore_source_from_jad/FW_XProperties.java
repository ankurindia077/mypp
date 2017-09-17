// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_XProperties.java

package com.test.auto.fw_core;

import java.util.Properties;

public class FW_XProperties extends Properties
{

    public FW_XProperties()
    {
    }

    public FW_XProperties(Properties defaults)
    {
        super(defaults);
    }

    public String getProperty(String key)
    {
        return getProperty(key, 0);
    }

    private String getProperty(String key, int level)
    {
        String value = super.getProperty(key);
        if(value != null)
        {
            int beginIndex = 0;
            for(int startName = value.indexOf("{", beginIndex); startName != -1; startName = value.indexOf("{", beginIndex))
            {
                if(level + 1 > 5)
                    return value;
                int endName = value.indexOf("}", startName);
                if(endName == -1)
                    return value;
                String constName = value.substring(startName + 1, endName);
                String constValue = getProperty(constName, level + 1);
                if(constValue == null)
                    return value;
                String newValue = startName <= 0 ? "" : value.substring(0, startName);
                newValue = (new StringBuilder(String.valueOf(newValue))).append(constValue).toString();
                beginIndex = newValue.length();
                newValue = (new StringBuilder(String.valueOf(newValue))).append(value.substring(endName + 1)).toString();
                value = newValue;
            }

        }
        return value;
    }

    private static final String START_CONST = "{";
    private static final String END_CONST = "}";
    private static final int MAX_SUBST_DEPTH = 5;
}
