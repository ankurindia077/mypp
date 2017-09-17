/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.jdom2.Document
 *  org.jdom2.Element
 *  org.jdom2.JDOMException
 *  org.jdom2.input.SAXBuilder
 *  org.jdom2.output.Format
 *  org.jdom2.output.XMLOutputter
 */
package com.test.auto.fw_core;

import com.test.auto.fw_core.FW_PropertyFileReader;
import com.test.auto.fw_core.FW_PropertyReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class FW_ProcessReport {
    private static Logger logger = LogManager.getLogger((String)FW_ProcessReport.class.getName());

    public void linkScreenShotsToHTMLReport(String testcaseID) {
        FW_PropertyFileReader fw_PropertyFileReader = new FW_PropertyFileReader();
        FW_PropertyReader fw_PropertyReader = new FW_PropertyReader();
        String resultsFolder = String.valueOf(fw_PropertyReader.getReporterProperty("atu.reports.dir")) + "/" + "Results" + "/";
        String settingsPropertiesFile = String.valueOf(resultsFolder) + "Settings.properties";
        Properties settingsProperties = fw_PropertyFileReader.loadProperties(settingsPropertiesFile);
        Integer currentRun = Integer.parseInt(settingsProperties.getProperty("run"));
        String runFolder = "Run_" + currentRun.toString() + "/";
        String suiteName = String.valueOf(fw_PropertyReader.getFWXProperty("SUITE_NAME")) + "/";
        String testName = String.valueOf(fw_PropertyReader.getFWXProperty("TEST_NAME")) + "/";
        String workingDir = String.valueOf(fw_PropertyReader.getFWXProperty("WORKING_DIR")) + "/";
        String testPlanDir = String.valueOf(fw_PropertyReader.getFWXProperty("TESTPLAN_CLASS_NAME").replace(".", "/")) + "/";
        String imageFolderPrefix = String.valueOf(resultsFolder) + runFolder + suiteName + testName + workingDir + testPlanDir;
        Document doc = null;
        String htmlFileName = String.valueOf(imageFolderPrefix) + testcaseID + "_Iteration1" + "/" + testcaseID + ".html";
        File htmlFile = new File(htmlFileName);
        try {
            doc = new SAXBuilder().build(htmlFile);
        }
        catch (JDOMException e1) {
            e1.printStackTrace();
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        Element root = doc.getRootElement();
        logger.debug((Object)("root - doc.getRootElement(): " + (Object)root));
        Element body = root.getChild("body");
        logger.debug((Object)("body - root.getChild('body'): " + (Object)body));
        Element mainTable = body.getChild("table");
        logger.debug((Object)("mainTable - body.getChild('table'): " + (Object)mainTable));
        Element container = (Element)mainTable.getChildren("tr").get(1);
        logger.debug((Object)("container - mainTable.getChildren('tr').get(1): " + (Object)container));
        Element content = (Element)container.getChildren("td").get(1);
        logger.debug((Object)("content - container.getChildren('td').get(1): " + (Object)content));
        Element div = (Element)content.getChildren("div").get(5);
        logger.debug((Object)("div - content.getChildren('div').get(5): " + (Object)div));
        Element chartStyleTable = div.getChild("table");
        logger.debug((Object)("chartStyleTable - div.getChild('table'): " + (Object)chartStyleTable));
        List tableRows = chartStyleTable.getChildren("tr");
        logger.debug((Object)("tableRows - chartStyleTable.getChildren('tr'): " + tableRows));
        logger.debug((Object)("tableRows.size(): " + tableRows.size()));
        int rowCount = 1;
        while (rowCount < tableRows.size()) {
            Element column = (Element)((Element)tableRows.get(rowCount)).getChildren("td").get(8);
            logger.debug((Object)("column - tableRows.get(rowCount).getChildren('td').get(8): " + (Object)column));
            column.setText("<a href=\"img/" + rowCount + ".PNG\"><img src=\"img/" + rowCount + ".PNG\" alt=\"No Screenshot\"/></a>");
            ++rowCount;
        }
        XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
        try {
            xout.output(doc, (Writer)new FileWriter(htmlFileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

