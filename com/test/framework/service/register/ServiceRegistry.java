/**
 * @Title: ServiceRegistry.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月11日 下午10:36:32
 * @version V1.0
 */

package com.test.framework.service.register;

/**
 * @author Test
 *
 */
public interface ServiceRegistry 
{
	//register service
	public boolean start(String service,int port);
	
	//verify the register action
	public boolean DoRegisterVerify(String service);
	
	//clean up tested
	public boolean DoRegisterClean(String service);
}

