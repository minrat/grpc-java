/**
 * @Title: PropertiesUtils.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月21日 下午11:36:13
 * @version V1.0
 */

package com.test.framework.service.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Test
 *
 */
public class PropertiesUtils {
	public static Properties getProperties(String filePath)
		    throws IOException
		  {
		    Properties p = null;
		    try
		    {
		      p = getProperties(filePath, false);
		    } catch (IOException e) {
		      p = getProperties(filePath, true);
		    }

		    return p;
		  }

		  private static Properties getProperties(String filePath, boolean isFileInJar)
		    throws IOException
		  {
		    Properties p = new Properties();
		    InputStream is = null;

		    if (isFileInJar)
		      is = PropertiesUtils.class.getClassLoader().getResourceAsStream(filePath);
		    else {
		      is = new FileInputStream(System.getProperty("user.dir") + "/" + filePath);
		    }

		    if (is == null) {
		      throw new IOException("PropertiesUtils.getProperties:无法读取属性文件，请确认属性文件的路径[" + filePath + "]是否正确！");
		    }

		    p.load(is);
		    is.close();

		    return p;
		  }
		}