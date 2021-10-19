package com;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyInitiator {

  private PropertyInitiator() {}

  public static Properties objectReturn() {
    try {
      Properties obj = new Properties();
      FileInputStream objfile =
          new FileInputStream(System.getProperty("user.dir") + "\\ConfigConstants.properties");
      obj.load(objfile);
      return obj;
    } catch (Exception j) {
      j.printStackTrace();
      return null;
    }
  }
}
