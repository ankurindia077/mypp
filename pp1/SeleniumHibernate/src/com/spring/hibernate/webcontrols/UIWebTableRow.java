package com.spring.hibernate.webcontrols;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebCheckBox;
import com.spring.hibernate.webinterface.IWebImage;
import com.spring.hibernate.webinterface.IWebTableCell;
import com.spring.hibernate.webinterface.IWebTableRow;

public class UIWebTableRow implements IWebTableRow{
	
	 private WebElement _tableRow;
	  
	 public UIWebTableRow(WebElement tableRow)
     {
          _tableRow = tableRow;
     }

	@Override
	public IWebImage GetImageById(String id) {
		WebElement image = null;
        try
        {
            image = _tableRow.findElement(By.cssSelector("img[id*='" + id + "']"));
            if (image != null)
            {
                return new UIWebImage(image);
            }
            else
            {
            	throw new ElementNotInteractableException("Element not found");
            }
        }
        catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	public IWebCheckBox GetCheckBoxById(String id) {
		return new UIWebCheckBox(_tableRow.findElement(By.cssSelector("input[id*='" + id + "']")));
	}

	@Override
	public List<IWebTableCell> TableCells() {
		return GetWebTableCells();
	}
	
	private List<IWebTableCell> GetWebTableCells()
    {
        List<IWebTableCell> webTableCellList = new ArrayList<IWebTableCell>();
        try
        {
            List<WebElement> tableCells = _tableRow.findElements(By.xpath("td"));

            for(WebElement tableCell : tableCells)
            {
                webTableCellList.add(new UIWebTableCell(tableCell));
            }
            return webTableCellList;
        }
        catch(Exception e)
        {
       	 	System.out.println("Warning: Exception thrown");
	       	throw new ElementNotInteractableException("Element not found");
        }
    }
	  
}
