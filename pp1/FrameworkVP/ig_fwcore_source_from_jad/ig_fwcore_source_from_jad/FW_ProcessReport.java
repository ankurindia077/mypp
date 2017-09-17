// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_ProcessReport.java

package com.test.auto.fw_core;

import java.io.*;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

// Referenced classes of package com.test.auto.fw_core:
//            FW_PropertyFileReader, FW_PropertyReader

public class FW_ProcessReport
{

    public FW_ProcessReport()
    {
    }

    public void linkScreenShotsToHTMLReport(String testcaseID)
    {
        FW_PropertyFileReader fw_PropertyFileReader = new FW_PropertyFileReader();
        FW_PropertyReader fw_PropertyReader = new FW_PropertyReader();
        String resultsFolder = (new StringBuilder(String.valueOf(fw_PropertyReader.getReporterProperty("atu.reports.dir")))).append("/").append("Results").append("/").toString();
        String settingsPropertiesFile = (new StringBuilder(String.valueOf(resultsFolder))).append("Settings.properties").toString();
        Properties settingsProperties = fw_PropertyFileReader.loadProperties(settingsPropertiesFile);
        Integer currentRun = Integer.valueOf(Integer.parseInt(settingsProperties.getProperty("run")));
        String runFolder = (new StringBuilder("Run_")).append(currentRun.toString()).append("/").toString();
        String suiteName = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("SUITE_NAME")))).append("/").toString();
        String testName = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("TEST_NAME")))).append("/").toString();
        String workingDir = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("WORKING_DIR")))).append("/").toString();
        String testPlanDir = (new StringBuilder(String.valueOf(fw_PropertyReader.getFWXProperty("TESTPLAN_CLASS_NAME").replace(".", "/")))).append("/").toString();
        String imageFolderPrefix = (new StringBuilder(String.valueOf(resultsFolder))).append(runFolder).append(suiteName).append(testName).append(workingDir).append(testPlanDir).toString();
        Document doc = null;
        String htmlFileName = (new StringBuilder(String.valueOf(imageFolderPrefix))).append(testcaseID).append("_Iteration1").append("/").append(testcaseID).append(".html").toString();
        File htmlFile = new File(htmlFileName);
        try
        {
            doc = (new SAXBuilder()).build(htmlFile);
        }
        catch(JDOMException e1)
        {
            e1.printStackTrace();
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
        Element root = doc.getRootElement();
        logger.debug((new StringBuilder("root - doc.getRootElement(): ")).append(root).toString());
        Element body = root.getChild("body");
        logger.debug((new StringBuilder("body - root.getChild('body'): ")).append(body).toString());
        Element mainTable = body.getChild("table");
        logger.debug((new StringBuilder("mainTable - body.getChild('table'): ")).append(mainTable).toString());
        Element container = (Element)mainTable.getChildren("tr").get(1);
        logger.debug((new StringBuilder("container - mainTable.getChildren('tr').get(1): ")).append(container).toString());
        Element content = (Element)container.getChildren("td").get(1);
        logger.debug((new StringBuilder("content - container.getChildren('td').get(1): ")).append(content).toString());
        Element div = (Element)content.getChildren("div").get(5);
        logger.debug((new StringBuilder("div - content.getChildren('div').get(5): ")).append(div).toString());
        Element chartStyleTable = div.getChild("table");
        logger.debug((new StringBuilder("chartStyleTable - div.getChild('table'): ")).append(chartStyleTable).toString());
        List tableRows = chartStyleTable.getChildren("tr");
        logger.debug((new StringBuilder("tableRows - chartStyleTable.getChildren('tr'): ")).append(tableRows).toString());
        logger.debug((new StringBuilder("tableRows.size(): ")).append(tableRows.size()).toString());
        for(int rowCount = 1; rowCount < tableRows.size(); rowCount++)
        {
            Element column = (Element)((Element)tableRows.get(rowCount)).getChildren("td").get(8);
            logger.debug((new StringBuilder("column - tableRows.get(rowCount).getChildren('td').get(8): ")).append(column).toString());
            column.setText((new StringBuilder("<a href=\"img/")).append(rowCount).append(".PNG\"><img src=\"img/").append(rowCount).append(".PNG\" alt=\"No Screenshot\"/></a>").toString());
        }

        XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
        try
        {
            xout.output(doc, new FileWriter(htmlFileName));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_ProcessReport.getName());

}
