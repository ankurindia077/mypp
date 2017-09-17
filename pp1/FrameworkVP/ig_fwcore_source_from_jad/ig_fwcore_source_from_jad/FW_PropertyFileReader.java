// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_PropertyFileReader.java

package com.test.auto.fw_core;

import java.io.*;
import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

// Referenced classes of package com.test.auto.fw_core:
//            FW_XProperties

public class FW_PropertyFileReader
{

    public FW_PropertyFileReader()
    {
    }

    public Properties loadProperties(String p_StrFilePath)
    {
        Properties l_objReporterProperties = null;
        try
        {
            FileInputStream l_objPropFile = new FileInputStream(p_StrFilePath);
            l_objReporterProperties = new Properties();
            l_objReporterProperties.load(l_objPropFile);
        }
        catch(FileNotFoundException p_expFileNotFoundException)
        {
            logger.error((new StringBuilder("[loadProperties] FileNotFoundException: ")).append(p_expFileNotFoundException.getMessage()).toString());
        }
        catch(IOException p_expIOException)
        {
            logger.error((new StringBuilder("[loadProperties] IOException: ")).append(p_expIOException.getMessage()).toString());
        }
        return l_objReporterProperties;
    }

    public Map loadXProperties(String p_StrFileName)
    {
        Map l_objXLevelPropertiesMap = null;
        try
        {
            l_objXLevelPropertiesMap = getXMap(p_StrFileName);
        }
        catch(FileNotFoundException p_expFileNotFoundException)
        {
            logger.error((new StringBuilder("[loadXProperties] FileNotFoundException: ")).append(p_expFileNotFoundException.getMessage()).toString());
        }
        catch(IOException p_expIOException)
        {
            logger.error((new StringBuilder("[loadXProperties] IOException: ")).append(p_expIOException.getMessage()).toString());
        }
        return l_objXLevelPropertiesMap;
    }

    public Map getXMap(String p_strFilePath)
        throws FileNotFoundException, IOException
    {
        Map l_objXLevelPropMap = new HashMap();
        FileInputStream l_objPropFile = new FileInputStream(p_strFilePath);
        Properties l_objXLevelProperties = null;
        l_objXLevelProperties = new FW_XProperties();
        l_objXLevelProperties.load(l_objPropFile);
        if(!l_objXLevelProperties.isEmpty())
        {
            String l_strKey;
            for(Enumeration l_objEnum = l_objXLevelProperties.keys(); l_objEnum.hasMoreElements(); l_objXLevelPropMap.put(l_strKey, String.valueOf(l_objXLevelProperties.getProperty(l_strKey))))
                l_strKey = (String)l_objEnum.nextElement();

        }
        l_objPropFile.close();
        return l_objXLevelPropMap;
    }

    public Map getResourceMap(String p_strDisplayLang, String p_strFilename)
    {
        Map l_objResourceMap = new HashMap();
        if(p_strDisplayLang == null)
            p_strDisplayLang = "en_us";
        p_strFilename = (new StringBuilder(String.valueOf(p_strFilename))).append("_").append(p_strDisplayLang).toString();
        Locale locale = new Locale(p_strDisplayLang);
        ResourceBundle l_objResourceBundle = null;
        try
        {
            String l_strKey = null;
            String l_strValue = null;
            l_objResourceBundle = PropertyResourceBundle.getBundle(p_strFilename, locale);
            for(Enumeration l_objKeySet = l_objResourceBundle.getKeys(); l_objKeySet.hasMoreElements(); l_objResourceMap.put(l_strKey, l_strValue))
            {
                l_strKey = (String)l_objKeySet.nextElement();
                l_strValue = l_objResourceBundle.getString(l_strKey);
            }

        }
        catch(MissingResourceException p_objIOException)
        {
            logger.error((new StringBuilder("[getResourceMap] MissingResourceException: ")).append(p_objIOException.getMessage()).toString());
        }
        return l_objResourceMap;
    }

    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_PropertyFileReader.getName());

}
