// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NameValuePair.java

package com.igate.features.DataReader;


public class NameValuePair
{

    public NameValuePair()
    {
    }

    public String getElementName()
    {
        return elementName;
    }

    public String getElementValue()
    {
        return elementValue;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }

    public void setElementValue(String elementValue)
    {
        this.elementValue = elementValue;
    }

    public String elementName;
    public String elementValue;
}
