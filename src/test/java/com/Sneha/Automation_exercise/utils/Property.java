package com.Sneha.Automation_exercise.utils;

import java.io.File;
//import java.io.FileInputStream;
//import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

public class Property {
	//  private static final Properties configFile = new Properties();

	  static {
	    //try {
	      // Log4j2 configuration
	      LoggerContext loggerContext =
	          (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
	      File file = new File("src/main/java/resources/log4j2.xml");
	      loggerContext.setConfigLocation(file.toURI());
	      // location of properties file
	      /*String path = System.getProperty("user.dir") + "/configuration.properties";
	      FileInputStream input = new FileInputStream(path);
	      // load properties file into Properties object
	      //configFile.load(input);
	      if (System.getProperty("browser") == null) {
	        System.setProperty("browser", "chrome");
	      }
	      if (System.getProperty("environment") == null) {
	        System.setProperty("environment", "QA");
	      }
	      input.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new RuntimeException("Failed to load properties file!");*/
	    }
	  

	  /**
	   * This method returns property value from configuration.properties file
	   *
	   * @param keyName property name
	   * @return property value
	   */
	 /* public static String getProperty(String keyName) {
	    //return configFile.getProperty(keyName);
	  }*/

	  public static Integer getWaitTime(WaitTime waitTime) {
	    switch (waitTime) {
	      case VERY_SHORT:
	        return 5;
	      case SHORT:
	        return 10;
	      case MEDIUM:
	        return 15;
	      case LONG:
	        return 20;
	      case VISIBILITY:
	        return 30;
	      default:
	        return 5;
	    }
	  }

	  /*public static String getEnvironmentUrl(Environment env) {
	    switch (env) {
	      case DEV:
	        return getProperty("DEV");
	      case UAT:
	        return getProperty("UAT");
	      case PROD:
	        return getProperty("PROD");
	      default:
	        return getProperty("QA");
	    }
	  }

	  public static Environment getEnvironmentType() {
	    String environment = System.getProperty("environment");
	    switch (environment) {
	      case "DEV":
	        return Environment.DEV;
	      case "UAT":
	        return Environment.UAT;
	      case "PROD":
	        return Environment.PROD;
	      default:
	        return Environment.QA;
	    }
	  }

	  public static String getDatabaseUrl(Database database) {
	    switch (database) {
	      case QA_eCommerce:
	        return getProperty("QA_eCommerce");
	      case QA_MDM:
	        return getProperty("QA_MDM");
	      case QA_Personify:
	        return getProperty("QA_Personify");
	      default:
	        return getProperty("TestDatabase");
	    }
	  }

	  public static String getEnvironmentUrl() {
	    return getEnvironmentUrl(getEnvironmentType());
	  }

	  public static String getAutomationUsername() {
	    return getProperty("Automation_db_username");
	  }

	  public static String getAutomationPassword() {
	    return getProperty("Automation_db_password");
	  }*/
	}
