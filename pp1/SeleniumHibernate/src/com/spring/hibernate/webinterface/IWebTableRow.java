package com.spring.hibernate.webinterface;

import java.util.List;

public interface IWebTableRow {

    IWebImage GetImageById(String id);

    IWebCheckBox GetCheckBoxById(String id);

    List<IWebTableCell> TableCells();
    
}
