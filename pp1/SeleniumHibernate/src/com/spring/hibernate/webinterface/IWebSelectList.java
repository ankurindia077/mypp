package com.spring.hibernate.webinterface;

public interface IWebSelectList {
	
    void SelectByValue(String value);     
    void SelectByIndex(int id);
    void SelectByText(String value);
    
    String Style();   
    String SelectedItem();
    
    boolean HasSelectedItems();     
    boolean Enabled();
    boolean IsVisible();
    
}
