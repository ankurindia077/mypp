/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  au.com.bytecode.opencsv.CSVReader
 *  jxl.Cell
 *  jxl.Sheet
 *  jxl.Workbook
 *  jxl.read.biff.BiffException
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 */
package com.igate.features.DataReader;

import au.com.bytecode.opencsv.CSVReader;
import com.igate.features.DataReader.NameValuePair;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DataReader {
    private static Logger logger = LogManager.getLogger((String)DataReader.class.getName());
    private String filepath;
    private ArrayList<ArrayList<String>> dataListArray;
    private ArrayList<ArrayList<NameValuePair>> dataNVPairArray;

    private String getFilepath() {
        return this.filepath;
    }

    private ArrayList<ArrayList<String>> getDataListArray() {
        return this.dataListArray;
    }

    private ArrayList<ArrayList<NameValuePair>> getDataNVPairArray() {
        return this.dataNVPairArray;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    private void setDataListArray(ArrayList<ArrayList<String>> dataListArray) {
        this.dataListArray = dataListArray;
    }

    private void setDataNVPairArray(ArrayList<ArrayList<NameValuePair>> dataNVPairArray) {
        this.dataNVPairArray = dataNVPairArray;
    }

    public ArrayList<ArrayList<NameValuePair>> getContents() {
        if (this.getFilepath().contains(".csv")) {
            this.getCSVContent();
        } else if (this.getFilepath().contains(".xls")) {
            this.getXLContents();
        } else {
            logger.error((Object)("[getContent] Failed to get the contents from file: " + this.getFilepath()));
            throw new UnknownError("getContent() failed.");
        }
        return this.getDataNVPairArray();
    }

    public void getCSVContent() {
        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        try {
            String[] nextLine;
            CSVReader reader = new CSVReader((Reader)new FileReader(this.getFilepath()));
            while ((nextLine = reader.readNext()) != null) {
                ArrayList<String> list = new ArrayList<String>();
                int i = 0;
                while (i < nextLine.length) {
                    list.add(nextLine[i]);
                    ++i;
                }
                array.add(list);
            }
            this.setDataListArray(array);
            this.setDataNVPairArray(this.returnNVPairArray());
            reader.close();
        }
        catch (Exception e) {
            logger.error((Object)("[getCSVContent] Exception: " + this.getFilepath() + " : " + e.getMessage()));
            throw new UnknownError("getCSVContent() failed.");
        }
    }

    public void getXLContents() {
        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        boolean exitvar = false;
        File inputWorkbook = new File(this.getFilepath());
        try {
            Workbook w = Workbook.getWorkbook((File)inputWorkbook);
            Sheet sheet = w.getSheet(0);
            int i = 0;
            while (i < sheet.getRows()) {
                ArrayList<String> list = new ArrayList<String>();
                int j = 0;
                while (j < sheet.getColumns()) {
                    Cell cell = sheet.getCell(j, i);
                    if (cell.getContents().equalsIgnoreCase("END")) {
                        exitvar = true;
                        break;
                    }
                    list.add(cell.getContents());
                    ++j;
                }
                if (exitvar) break;
                array.add(list);
                ++i;
            }
            this.setDataListArray(array);
            this.setDataNVPairArray(this.returnNVPairArray());
        }
        catch (IOException e) {
            logger.error((Object)("[getXLContents] IOException: " + this.getFilepath() + " : " + e.getMessage()));
        }
        catch (BiffException e) {
            logger.error((Object)("[getXLContents] BiffException: " + this.getFilepath() + " : " + e.getMessage()));
        }
    }

    private ArrayList<ArrayList<NameValuePair>> returnNVPairArray() {
        ArrayList data = new ArrayList();
        data = this.getDataListArray();
        ArrayList<ArrayList<NameValuePair>> nvPairArray = new ArrayList<ArrayList<NameValuePair>>();
        ArrayList<String> header = this.getDataListArray().get(0);
        data.remove(0);
        for (ArrayList row : data) {
            ArrayList<NameValuePair> nvPairRow = new ArrayList<NameValuePair>();
            int i = 0;
            while (i < header.size()) {
                NameValuePair nameVal = new NameValuePair();
                nameVal.setElementName(header.get(i));
                nameVal.setElementValue((String)row.get(i));
                nvPairRow.add(nameVal);
                ++i;
            }
            nvPairArray.add(nvPairRow);
        }
        return nvPairArray;
    }

    public Integer getColumnIndex(String columnName, ArrayList<NameValuePair> row) {
        Integer colIndex = -1;
        Integer col = 0;
        while (col < row.size()) {
            if (row.get(col).getElementName().trim().equals(columnName)) {
                colIndex = col;
                break;
            }
            col = col + 1;
        }
        return colIndex;
    }
}

