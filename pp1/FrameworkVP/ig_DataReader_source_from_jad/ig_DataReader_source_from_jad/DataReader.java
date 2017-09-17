// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataReader.java

package com.igate.features.DataReader;

import au.com.bytecode.opencsv.CSVReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import jxl.*;
import jxl.read.biff.BiffException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

// Referenced classes of package com.igate.features.DataReader:
//            NameValuePair

public class DataReader
{

    public DataReader()
    {
    }

    private String getFilepath()
    {
        return filepath;
    }

    private ArrayList getDataListArray()
    {
        return dataListArray;
    }

    private ArrayList getDataNVPairArray()
    {
        return dataNVPairArray;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }

    private void setDataListArray(ArrayList dataListArray)
    {
        this.dataListArray = dataListArray;
    }

    private void setDataNVPairArray(ArrayList dataNVPairArray)
    {
        this.dataNVPairArray = dataNVPairArray;
    }

    public ArrayList getContents()
    {
        if(getFilepath().contains(".csv"))
            getCSVContent();
        else
        if(getFilepath().contains(".xls"))
        {
            getXLContents();
        } else
        {
            logger.error((new StringBuilder("[getContent] Failed to get the contents from file: ")).append(getFilepath()).toString());
            throw new UnknownError("getContent() failed.");
        }
        return getDataNVPairArray();
    }

    public void getCSVContent()
    {
        ArrayList array = new ArrayList();
        try
        {
            CSVReader reader = new CSVReader(new FileReader(getFilepath()));
            String nextLine[];
            while((nextLine = reader.readNext()) != null) 
            {
                ArrayList list = new ArrayList();
                for(int i = 0; i < nextLine.length; i++)
                    list.add(nextLine[i]);

                array.add(list);
            }
            setDataListArray(array);
            setDataNVPairArray(returnNVPairArray());
            reader.close();
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("[getCSVContent] Exception: ")).append(getFilepath()).append(" : ").append(e.getMessage()).toString());
            throw new UnknownError("getCSVContent() failed.");
        }
    }

    public void getXLContents()
    {
        ArrayList array = new ArrayList();
        boolean exitvar = false;
        File inputWorkbook = new File(getFilepath());
        try
        {
            Workbook w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0);
            for(int i = 0; i < sheet.getRows(); i++)
            {
                ArrayList list = new ArrayList();
                for(int j = 0; j < sheet.getColumns(); j++)
                {
                    Cell cell = sheet.getCell(j, i);
                    if(cell.getContents().equalsIgnoreCase("END"))
                    {
                        exitvar = true;
                        break;
                    }
                    list.add(cell.getContents());
                }

                if(exitvar)
                    break;
                array.add(list);
            }

            setDataListArray(array);
            setDataNVPairArray(returnNVPairArray());
        }
        catch(IOException e)
        {
            logger.error((new StringBuilder("[getXLContents] IOException: ")).append(getFilepath()).append(" : ").append(e.getMessage()).toString());
        }
        catch(BiffException e)
        {
            logger.error((new StringBuilder("[getXLContents] BiffException: ")).append(getFilepath()).append(" : ").append(e.getMessage()).toString());
        }
    }

    private ArrayList returnNVPairArray()
    {
        ArrayList data = new ArrayList();
        data = getDataListArray();
        ArrayList nvPairArray = new ArrayList();
        ArrayList header = (ArrayList)getDataListArray().get(0);
        data.remove(0);
        ArrayList nvPairRow;
        for(Iterator iterator = data.iterator(); iterator.hasNext(); nvPairArray.add(nvPairRow))
        {
            ArrayList row = (ArrayList)iterator.next();
            nvPairRow = new ArrayList();
            for(int i = 0; i < header.size(); i++)
            {
                NameValuePair nameVal = new NameValuePair();
                nameVal.setElementName((String)header.get(i));
                nameVal.setElementValue((String)row.get(i));
                nvPairRow.add(nameVal);
            }

        }

        return nvPairArray;
    }

    public Integer getColumnIndex(String columnName, ArrayList row)
    {
        Integer colIndex = Integer.valueOf(-1);
        for(Integer col = Integer.valueOf(0); col.intValue() < row.size(); col = Integer.valueOf(col.intValue() + 1))
        {
            if(!((NameValuePair)row.get(col.intValue())).getElementName().trim().equals(columnName))
                continue;
            colIndex = col;
            break;
        }

        return colIndex;
    }

    private static Logger logger = LogManager.getLogger(com/igate/features/DataReader/DataReader.getName());
    private String filepath;
    private ArrayList dataListArray;
    private ArrayList dataNVPairArray;

}
