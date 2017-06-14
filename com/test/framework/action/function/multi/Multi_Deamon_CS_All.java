/**
 * @Title: Multi_Deamon_CS_All.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月28日 下午4:35:47
 * @version V1.0
 */

package com.test.framework.action.function.multi;

import com.test.framework.consumer.multi.M_CS_Greeter;

/**
 * @author Test
 * 
 * 	greeter -> dinner -> drink -> entertainment -> pay -> bye
 */
public class Multi_Deamon_CS_All {
	
	private static M_CS_Greeter cs_greeter=null;
	
	public Multi_Deamon_CS_All()
	{
		cs_greeter = new M_CS_Greeter();
	}
	
	
	public  void multiCall() throws Exception
	{
		
		long startTime=System.currentTimeMillis();
		
		cs_greeter.callHello();
		
		long endTime=System.currentTimeMillis();
		float excTime=(float)(endTime-startTime)/1000;
		System.out.println("Multi [ greeter -> dinner -> drink -> entertainment -> pay -> bye ] Action Cost : "+excTime +"s");
	}

	
	public static void main(String[] args) throws Exception {
		Multi_Deamon_CS_All all = new Multi_Deamon_CS_All();
		all.multiCall();
		
	}
	
}
