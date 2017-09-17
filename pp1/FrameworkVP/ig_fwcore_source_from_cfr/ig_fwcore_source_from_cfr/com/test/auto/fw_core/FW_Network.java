/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.apache.log4j.PropertyConfigurator
 */
package com.test.auto.fw_core;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FW_Network {
    private String log4JProperties = "config\\log4j.properties";
    private static Logger logger = LogManager.getLogger((String)FW_Network.class.getName());

    public FW_Network() {
        PropertyConfigurator.configure((String)this.log4JProperties);
        ArrayList<String> expectedMacAddress = new ArrayList<String>();
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
        logger.debug((Object)("Authorized computers are: " + expectedMacAddress.toString()));
        StringBuilder sb = null;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            sb = new StringBuilder();
            int i = 0;
            while (i < mac.length) {
                Object[] arrobject = new Object[2];
                arrobject[0] = Byte.valueOf(mac[i]);
                arrobject[1] = i < mac.length - 1 ? "-" : "";
                sb.append(String.format("%02X%s", arrobject));
                ++i;
            }
        }
        catch (UnknownHostException e) {
            logger.error((Object)("UnknownHostException: " + e.getMessage()));
        }
        catch (SocketException e) {
            logger.error((Object)("SocketException: " + e.getMessage()));
        }
        String macAddress = sb.toString();
        if (!expectedMacAddress.contains(macAddress)) {
            logger.error((Object)("Not authorized to run on this computer: " + macAddress));
            logger.error((Object)("Authorized computers are: " + expectedMacAddress.toString()));
            System.exit(0);
        }
    }
}

