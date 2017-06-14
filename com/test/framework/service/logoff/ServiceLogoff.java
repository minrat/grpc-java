/**
 * @Title: ServiceLogoff.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午11:12:46
 * @version V1.0
 */

package com.test.framework.service.logoff;

/**
 * @author Test
 *
 */
public interface ServiceLogoff 
{
	//logoff service
	public boolean DoLogoff(String service);
	
	//verify the logoff action
	public boolean DoLogoffVerify();
	
	//clean up testbed
	public boolean DoLogoffClean();
}
