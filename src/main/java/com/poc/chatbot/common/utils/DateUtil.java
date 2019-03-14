package com.poc.chatbot.common.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateUtil {
	 public static final String PATTERN_SERVER_TIME_A = "yyyy.MM.dd HH:mm:ss.SSS";

     public static final String PATTERN_SERVER_TIME_B = "yyyy.MM.dd";

     public static final String PATTERN_SERVER_TIME_C = "yyyy.MM.dd HH";

     public static final String PATTERN_SERVER_TIME_D = "yyyy.MM.dd HH:mm";

     public static final String PATTERN_SERVER_TIME_E = "yyyy.MM.dd HH:mm:ss";


     public static final String PATTERN_SERVER_TIME_F = "yyyyMMddHHmmssSSS";

     public static final String PATTERN_SERVER_TIME_G = "yyyyMMdd";

     public static final String PATTERN_SERVER_TIME_H = "yyyyMMddHH";

     public static final String PATTERN_SERVER_TIME_I = "yyyyMMddHHmm";

     public static final String PATTERN_SERVER_TIME_J = "yyyyMMddHHmmss";


     public static String getNowLocalDateTime(String forPattern){

    	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(forPattern);

    	 return LocalDateTime.now().format(formatter);
     }
}
