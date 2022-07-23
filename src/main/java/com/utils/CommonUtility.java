package com.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtility {
	 public static String getDateTime() {
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss.ms");
	        LocalDateTime current = LocalDateTime.now();
	        return current.format(format);
	    }

}
