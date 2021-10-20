package com.config;

import java.util.Properties;

public class ConfigConstants {
  private static Properties properties = PropertyInitiator.objectReturn();
  public static String URL = properties.getProperty("baseURL");
  //sample
}
