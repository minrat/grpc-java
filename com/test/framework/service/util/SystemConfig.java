/**
 * @Title: SystemConfig.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月21日 下午11:37:10
 * @version V1.0
 */

package com.test.framework.service.util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Test
 *
 */
public class SystemConfig {
	private static final Logger log = Logger.getLogger(SystemConfig.class.getName());

	  private static Properties properties = null;

	  private static Properties switchProperties = null;

	  private static void init()
	  {
	    try
	    {
	      properties = PropertiesUtils.getProperties("htsc-grpc-java-config.properties");
	    } catch (Exception e) {
	      log.log(Level.SEVERE, e.getMessage());
	    }
	  }

//	  private static void initSwitchProperties() {
//	    try {
//	      switchProperties = PropertiesUtils.getProperties("htsc-switch.properties");
//	    } catch (Exception e) {
//	      log.log(Level.WARNING, e.getMessage());
//	    }
//	  }

	  public static Properties getProperties()
	  {
	    return properties;
	  }

	  public static Properties getSwitchProperties()
	  {
	    return switchProperties;
	  }

	  static
	  {
	    init();
//	    initSwitchProperties();
	  }
	}