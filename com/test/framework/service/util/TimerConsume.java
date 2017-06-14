/**
 * @Title: TimerConsume.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午9:37:01
 * @version V1.0
 */

package com.test.framework.service.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Test
 *
 */
public class TimerConsume 
{
	public static Log log = LogFactory.getLog(TimerConsume.class.getName());
	
	public void cal()
	{
		long startTime=System.currentTimeMillis();
	       //执行方法
		System.out.println("-----------------");
		
		long endTime=System.currentTimeMillis();
		
	       float excTime=(float)(endTime-startTime)/1000;
//	       log.debug("执行时间："+excTime+"s");
	       System.out.println("执行时间："+excTime+"s");
	}
	
	public static void main(String[] args) 
	{
		TimerConsume tc = new TimerConsume();
		tc.cal();
	}
}
