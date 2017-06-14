/**
 * @Title: Deamon_logoff_Call.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月25日 下午3:45:43
 * @version V1.0
 */

package com.test.framework.action.function.logoff;

import com.test.framework.consumer.CS_Greeter;

/**
 * @author Test
 *
 */
public class Deamon_logoff_Consumer {
	private static CS_Greeter cs_greeter;
	
	
	public static void main(String[] args) throws Exception {
		cs_greeter = new CS_Greeter();
		
		Thread.sleep(500L);
		cs_greeter.callHello();
		
	}

}
