/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_XProperties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FW_PropertyFileReader {
    private static Logger logger = LogManager.getLogger((String)FW_PropertyFileReader.class.getName());

    public Properties loadProperties(String p_StrFilePath) {
        Properties l_objReporterProperties = null;
        try {
            FileInputStream l_objPropFile = new FileInputStream(p_StrFilePath);
            l_objReporterProperties = new Properties();
            l_objReporterProperties.load(l_objPropFile);
        }
        catch (FileNotFoundException p_expFileNotFoundException) {
            logger.error((Object)("[loadProperties] FileNotFoundException: " + p_expFileNotFoundException.getMessage()));
        }
        catch (IOException p_expIOException) {
            logger.error((Object)("[loadProperties] IOException: " + p_expIOException.getMessage()));
        }
        return l_objReporterProperties;
    }

    public Map<String, String> loadXProperties(String p_StrFileName) {
        Map<String, String> l_objXLevelPropertiesMap = null;
        try {
            l_objXLevelPropertiesMap = this.getXMap(p_StrFileName);
        }
        catch (FileNotFoundException p_expFileNotFoundException) {
            logger.error((Object)("[loadXProperties] FileNotFoundException: " + p_expFileNotFoundException.getMessage()));
        }
        catch (IOException p_expIOException) {
            logger.error((Object)("[loadXProperties] IOException: " + p_expIOException.getMessage()));
        }
        return l_objXLevelPropertiesMap;
    }

    public Map<String, String> getXMap(String p_strFilePath) throws FileNotFoundException, IOException {
        HashMap<String, String> l_objXLevelPropMap = new HashMap<String, String>();
        FileInputStream l_objPropFile = new FileInputStream(p_strFilePath);
        FW_XProperties l_objXLevelProperties = null;
        l_objXLevelProperties = new FW_XProperties();
        l_objXLevelProperties.load(l_objPropFile);
        if (!l_objXLevelProperties.isEmpty()) {
            Enumeration l_objEnum = l_objXLevelProperties.keys();
            while (l_objEnum.hasMoreElements()) {
                String l_strKey = (String)l_objEnum.nextElement();
                l_objXLevelPropMap.put(l_strKey, String.valueOf(l_objXLevelProperties.getProperty(l_strKey)));
            }
        }
        l_objPropFile.close();
        return l_objXLevelPropMap;
    }

    public Map<String, String> getResourceMap(String p_strDisplayLang, String p_strFilename) {
        HashMap<String, String> l_objResourceMap = new HashMap<String, String>();
        if (p_strDisplayLang == null) {
            p_strDisplayLang = "en_us";
        }
        p_strFilename = String.valueOf(p_strFilename) + "_" + p_strDisplayLang;
        Locale locale = new Locale(p_strDisplayLang);
        ResourceBundle l_objResourceBundle = null;
        try {
            String l_strKey = null;
            String l_strValue = null;
            l_objResourceBundle = PropertyResourceBundle.getBundle(p_strFilename, locale);
            Enumeration<String> l_objKeySet = l_objResourceBundle.getKeys();
            while (l_objKeySet.hasMoreElements()) {
                l_strKey = l_objKeySet.nextElement();
                l_strValue = l_objResourceBundle.getString(l_strKey);
                l_objResourceMap.put(l_strKey, l_strValue);
            }
        }
        catch (MissingResourceException p_objIOException) {
            logger.error((Object)("[getResourceMap] MissingResourceException: " + p_objIOException.getMessage()));
        }
        return l_objResourceMap;
    }
}

