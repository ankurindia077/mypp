package com.spring.hibernate.webinterface;

public interface IWebImage {
    void Click();
    
    boolean Exists();
    
    String GetAttribute(String attributeName);
}
