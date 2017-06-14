/**
 * @Title: PropertyTool.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月27日 下午3:49:11
 * @version V1.0
 */

package com.test.framework.service.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Test
 *
 */
public class PropertyTool {

	private static final Logger log = Logger.getLogger(PropertyTool.class.getName());
	private static Properties properties = null;
	
	public static void init()
	{
		 try {
			properties = PropertiesUtils.getProperties(Constants.PROPERTY_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static
	{
		init();
	}
	
	
	public static String GetTargetValue(String key)
	{
		String value = properties.getProperty(key);
		System.out.println(key+ "  : "+value);
		return value;
	}
	
	public static void SetTargetValue(String key,String value) throws Exception
	{
		properties.setProperty(key, value);
	}
	
	
	
	public static void getValue(String value) throws Exception
	{
		//读取属性文件
        InputStream in = new BufferedInputStream (new FileInputStream(Constants.PROPERTY_FILE));
        //加载属性列表
        properties.load(in);     
        Iterator<String> it=properties.stringPropertyNames().iterator();
        while(it.hasNext()){
            String key=it.next();
            System.out.println(key+":"+properties.getProperty(key));
        }
        in.close();
	}
	
	public void setValue(String key,String value) throws Exception
	{
		///保存属性
        FileOutputStream oFile = new FileOutputStream(Constants.PROPERTY_FILE, true);//true表示追加打开
        properties.setProperty(key, value);
        properties.store(oFile, "The New properties file");
        oFile.close();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		PropertyTool p = new PropertyTool();
		
		String key="consumer.default.loadbalance";
		
		String value_1="pick_first";
		String value_2="round_robin";
		String value_3="weight_round_robin";
		//get
		GetTargetValue(key);
		
		//set
		SetTargetValue(key, value_2);
		
		//get
		GetTargetValue(key);
		
		
		
	}
	
}
