/**
 * @Title: ServiceTrace.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午11:28:43
 * @version V1.0
 */

package com.test.framework.service.trace;

/**
 * @author Test
 *
 */
public interface ServiceTrace 
{
	//ensure trigger trace action
	public boolean Trace_Finished();
	
	//get information from kafka
	public String Trace_From_KFK(String TopicName);
}
