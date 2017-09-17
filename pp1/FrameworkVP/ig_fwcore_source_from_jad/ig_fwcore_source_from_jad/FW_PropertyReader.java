// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_PropertyReader.java

package com.test.auto.fw_core;

import java.util.Map;
import java.util.Properties;

// Referenced classes of package com.test.auto.fw_core:
//            FW_PropertyFileReader, FW_Network

public class FW_PropertyReader extends FW_PropertyFileReader
{

    public FW_PropertyReader()
    {
        m_objFWXLevelProperties = null;
        resourceMap = null;
        appProperties = null;
        reporterProp = null;
        m_objFW_PropertyReader = null;
        fw_Network = new FW_Network();
        m_objFWXLevelProperties = loadXProperties("config\\framework.properties");
        reporterProp = loadProperties((new StringBuilder("config\\")).append((String)m_objFWXLevelProperties.get("REPORTER_PROPERTIES")).toString());
        appProperties = loadProperties((new StringBuilder("com\\test\\auto\\properties\\")).append((String)m_objFWXLevelProperties.get("APP_PROPERTIES")).toString());
        resourceMap = getResourceMap(appProperties.getProperty("APP_LOCALE"), "com\\test\\auto\\properties\\resource");
    }

    public synchronized FW_PropertyReader getInstance()
    {
        if(m_objFW_PropertyReader == null)
            m_objFW_PropertyReader = new FW_PropertyReader();
        return m_objFW_PropertyReader;
    }

    public String getFWXProperty(String l_strKey)
    {
        return (String)m_objFWXLevelProperties.get(l_strKey);
    }

    public String getResourceProperty(String l_strKey)
    {
        return (String)resourceMap.get(l_strKey);
    }

    public String getAppProperty(String l_strKey)
    {
        return appProperties.getProperty(l_strKey);
    }

    public String getReporterProperty(String l_strKey)
    {
        return reporterProp.getProperty(l_strKey);
    }

    private Map m_objFWXLevelProperties;
    private Map resourceMap;
    private Properties appProperties;
    private Properties reporterProp;
    private FW_PropertyReader m_objFW_PropertyReader;
    FW_Network fw_Network;
}
