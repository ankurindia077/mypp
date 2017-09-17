package com.spring.hibernate.webinterface;

import java.util.List;

public interface IWebTable {

    IWebTableRow GetTableRow(int rowIndex);
    IWebTableRow GetTableRow(String text);

    IWebTableCell GetCell(String colName);
    
    int RowCount();
    int GetColumnIndex(String colName);
    
    List<String> GetColumnList(int index);

}
