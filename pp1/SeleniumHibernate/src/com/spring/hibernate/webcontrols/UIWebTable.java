package com.spring.hibernate.webcontrols;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebTable;
import com.spring.hibernate.webinterface.IWebTableCell;
import com.spring.hibernate.webinterface.IWebTableRow;

public class UIWebTable implements IWebTable{
	
	private WebElement _table;
	
	public UIWebTable(WebElement table)
    {
        _table = table;
    }

	@Override
	public IWebTableRow GetTableRow(int rowIndex) {
		try
        {
            if (_table.isDisplayed())
            {
                List<WebElement> tableRows = _table.findElements(By.xpath("tbody/tr"));
                return (IWebTableRow) new UIWebTableRow((WebElement) tableRows.get(rowIndex));
            }
            else 
            	throw new ElementNotInteractableException("Element not found");
        }
		catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
	}
		
	@Override
	public IWebTableRow GetTableRow(String text) {
		 try
         {
             if (_table.isDisplayed())
             {
                 List<WebElement> rows = _table.findElements(By.tagName("tr"));  
                 IWebTableRow iWebTableRow = null;
                 for(WebElement row:rows)
                 {
                	 if (row.getText() != " " && row.getText()!=null)
                	 {
                		 List<WebElement> cells = row.findElements(By.tagName("td"));
                		 for(WebElement cell:cells)
                		 {
                			 if (cell.getText().trim().contains(text.trim()))
                			 {
                				 iWebTableRow = (IWebTableRow) new UIWebTableRow(row);
                			 }
                		 }
                		 
                	 }               
                 }
                 return iWebTableRow;
             }
             else
            	throw new ElementNotInteractableException("Element not found");    
         }
		 catch(Exception e)
	        {
	       	 	System.out.println("Warning: Exception thrown");
		       	throw new ElementNotInteractableException("Element not found");
	        }
	}

	@Override
	public IWebTableCell GetCell(String colName) {
		try
        {
			@SuppressWarnings("unused")
			int colNum = 0;
            if (_table.isDisplayed())
            {
                List<WebElement> rows = _table.findElements(By.tagName("tr"));
                IWebTableCell iWebTableCell = null;
               
                // Iterate through each row     
                for(WebElement row : rows)
                {
                	
                    if (row.getText() != " " && row.getText()!=null)
                    {
                        List<WebElement> cells = row.findElements(By.xpath("td"));
                       
                        //for every column
                        for(WebElement cell:cells)
                        {
                        	
                            if (cell.getText() != " " && cell.getText() != null)
                            {
                                if (cell.getText().trim().contains(colName))
                                {
                                	iWebTableCell = (IWebTableCell) new UIWebTableCell(cell); 
                                }
                            }
                            colNum++;
                        }
                    }
                }
                return iWebTableCell;
            }
            else 
            	throw new ElementNotInteractableException("Element not found");   
        }
		catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	public int RowCount() {
       if (_table.isDisplayed())
          {
              List<WebElement> tableRows = _table.findElements(By.xpath("tbody/tr"));
              return tableRows.size();
          }
       else 	
          throw new ElementNotInteractableException("Element not found");
	}

	@Override
	public int GetColumnIndex(String colName) {
		try
        {
			int colNum = 0;
            if (_table.isDisplayed())
            {
                List<WebElement> rows = _table.findElements(By.tagName("tr"));
                // Iterate through each row     
                for(WebElement row : rows)
                {
                    if (row.getText() != " " && row.getText()!=null)
                    {
                        List<WebElement> cells = row.findElements(By.xpath("td"));
                       
                        //for every column
                        for(WebElement cell : cells)
                        {
                            if (cell.getText() != " " && cell.getText() != null)
                            {
                                if (cell.getText().trim().contains(colName))
                                {
                                    return colNum;
                                }
                            }
                            colNum++;
                        }
                    }
                }
                return colNum;
            }
             else 
            	 throw new ElementNotInteractableException("Element not found");
        }
		catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	public List<String> GetColumnList(int index) {
		List<String> colList = new ArrayList<String>();
        try
        {
            if (_table.isDisplayed())
            {

                List<WebElement> rows = _table.findElements(By.xpath("tbody/tr"));

                // for every row                    
                for(WebElement row : rows)
                {
                    if (row.getText() != " " && row.getText()!=null)
                    {
                        int colNum = 0;
                        String strResult = null;
                        List<WebElement> cells = row.findElements(By.xpath("td"));

                        //for every column
                        for(WebElement cell : cells)
                        {
                            if (colNum == index)
                            {
                                if (cell.getText() != "" && cell.getText() != null)
                                {

                                    strResult = cell.getText().toString();
                                    break;
                                }
                            }
                            colNum++;
                        }
                        if (strResult != null) colList.add(strResult);
                    }

                }
                return colList;
            }
        	throw new ElementNotInteractableException("Element not found");
        }
        catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
	}
	
}
