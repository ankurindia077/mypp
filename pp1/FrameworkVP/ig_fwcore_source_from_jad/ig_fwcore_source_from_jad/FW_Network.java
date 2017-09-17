// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FW_Network.java

package com.test.auto.fw_core;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

public class FW_Network
{

    public FW_Network()
    {
        log4JProperties = "config\\log4j.properties";
        PropertyConfigurator.configure(log4JProperties);
        List expectedMacAddress = new ArrayList();
        expectedMacAddress.add("00-50-56-C0-00-01");
        expectedMacAddress.add("3C-97-0E-90-52-0F");
        expectedMacAddress.add("EC-F4-BB-2E-92-2A");
        expectedMacAddress.add("82-86-F2-DC-22-79");
        expectedMacAddress.add("82-86-F2-DC-22-7A");
        expectedMacAddress.add("80-86-F2-DC-22-79");
        expectedMacAddress.add("80-86-F2-DC-22-7D");
        expectedMacAddress.add("60-67-20-CA-9D-FE");
        expectedMacAddress.add("60-67-20-CA-9D-FF");
        expectedMacAddress.add("D4-BE-D9-65-1B-D0");
        expectedMacAddress.add("6C-62-6D-AB-C6-E5");
        expectedMacAddress.add("34-17-EB-A0-06-02");
        expectedMacAddress.add("D4-BE-D9-0E-2D-F3");
        expectedMacAddress.add("34-E6-D7-7F-94-D0");
        expectedMacAddress.add("60-EB-69-85-F3-26");
        expectedMacAddress.add("44-39-C4-94-38-78");
        expectedMacAddress.add("98-90-96-DE-30-6D");
        expectedMacAddress.add("48-F8-B3-08-8B-85");
        expectedMacAddress.add("10-78-D2-95-67-5A");
        expectedMacAddress.add("B8-AC-6F-A1-B1-E9");
        expectedMacAddress.add("18-03-73-19-19-A3");
        expectedMacAddress.add("44-8A-5B-74-58-59");
        expectedMacAddress.add("18-03-73-19-13-97");
        expectedMacAddress.add("34-E6-D7-7F-94-D0");
        expectedMacAddress.add("74-46-A0-A5-8E-97");
        expectedMacAddress.add("00-50-56-C0-00-08");
        expectedMacAddress.add("00-50-56-C0-00-01");
        logger.debug((new StringBuilder("Authorized computers are: ")).append(expectedMacAddress.toString()).toString());
        StringBuilder sb = null;
        try
        {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte mac[] = network.getHardwareAddress();
            sb = new StringBuilder();
            for(int i = 0; i < mac.length; i++)
                sb.append(String.format("%02X%s", new Object[] {
                    Byte.valueOf(mac[i]), i >= mac.length - 1 ? "" : "-"
                }));

        }
        catch(UnknownHostException e)
        {
            logger.error((new StringBuilder("UnknownHostException: ")).append(e.getMessage()).toString());
        }
        catch(SocketException e)
        {
            logger.error((new StringBuilder("SocketException: ")).append(e.getMessage()).toString());
        }
        String macAddress = sb.toString();
        if(!expectedMacAddress.contains(macAddress))
        {
            logger.error((new StringBuilder("Not authorized to run on this computer: ")).append(macAddress).toString());
            logger.error((new StringBuilder("Authorized computers are: ")).append(expectedMacAddress.toString()).toString());
            System.exit(0);
        }
    }

    private String log4JProperties;
    private static Logger logger = LogManager.getLogger(com/test/auto/fw_core/FW_Network.getName());

}
