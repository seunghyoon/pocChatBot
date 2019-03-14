package com.poc.chatbot.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SystemInfoUtil {
	
	public static final String SERVER_INFO_LOCAL = "LOCAL";
	public static final String SERVER_INFO_DEV = "DEV";
	public static final String SERVER_INFO_TESTBED = "TESTBED";
	public static final String SERVER_INFO_PRODUCTION = "PRODUCTION";
	
	public static String getHostAddress(){
		String hostAddress = "";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
            log.trace("SystemInfoUtil.getHostAddress error : {}", e);
		}
		return hostAddress;
	}
	public static String getHostAddressMasking(){
    	String hostAddressMasking = "";
        try {
        	String hostAddress = getHostAddress();
            if(!"".equals(hostAddress) && hostAddress.lastIndexOf(".") > -1) {
            	hostAddressMasking = hostAddress.replaceAll("(?>.{"+hostAddress.lastIndexOf(".")+"})." , "#");
            	//hostAddressMasking = hostAddress.replaceAll("(?>.{"+Integer.valueOf(hostAddress.lastIndexOf("."))+"})." , "#");//beanny
            	//hostAddressMasking = hostAddress.replaceAll("(?>.{"+new Integer(hostAddress.lastIndexOf(".")).toString()+"})." , "#");
            }
        } catch (Exception e) {
            log.trace("SystemInfoUtil.getHostAddressMasking error : {}", e);
        }
        return hostAddressMasking;
	}
}
