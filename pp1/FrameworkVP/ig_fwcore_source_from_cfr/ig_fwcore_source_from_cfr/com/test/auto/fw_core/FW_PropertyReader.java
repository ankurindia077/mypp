/*
 * Decompiled with CFR 0_115.
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_Network;
import com.test.auto.fw_core.FW_PropertyFileReader;
import java.util.Map;
import java.util.Properties;

public class FW_PropertyReader
extends FW_PropertyFileReader {
    private Map<String, String> m_objFWXLevelProperties = null;
    private Map<String, String> resourceMap = null;
    private Properties appProperties = null;
    private Properties reporterProp = null;
    private FW_PropertyReader m_objFW_PropertyReader = null;
    FW_Network fw_Network = new FW_Network();

    public FW_PropertyReader() {
        this.m_objFWXLevelProperties = this.loadXProperties("config\\framework.properties");
        this.reporterProp = this.loadProperties("config\\" + this.m_objFWXLevelProperties.get("REPORTER_PROPERTIES"));
        this.appProperties = this.loadProperties("com\\test\\auto\\properties\\" + this.m_objFWXLevelProperties.get("APP_PROPERTIES"));
        this.resourceMap = this.getResourceMap(this.appProperties.getProperty("APP_LOCALE"), "com\\test\\auto\\properties\\resource");
    }

    public synchronized FW_PropertyReader getInstance() {
        if (this.m_objFW_PropertyReader == null) {
            this.m_objFW_PropertyReader = new FW_PropertyReader();
        }
        return this.m_objFW_PropertyReader;
    }

    public String getFWXProperty(String l_strKey) {
        return this.m_objFWXLevelProperties.get(l_strKey);
    }

    public String getResourceProperty(String l_strKey) {
        return this.resourceMap.get(l_strKey);
    }

    public String getAppProperty(String l_strKey) {
        return this.appProperties.getProperty(l_strKey);
    }

    public String getReporterProperty(String l_strKey) {
        return this.reporterProp.getProperty(l_strKey);
    }
}

