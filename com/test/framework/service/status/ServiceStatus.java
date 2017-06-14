/**
 * @Title: ServiceStatus.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月18日 上午11:07:13
 * @version V1.0
 */

package com.test.framework.service.status;

/**
 * @author Test
 *
 */
public interface ServiceStatus 
{
	//get status
	public boolean CurrentState(String ServiceName);
	
	//provider.deprecated=true
	public boolean SetDeprecat(String ServiceName);
	
	//verify
	public boolean SettedDeprecatVerify(String ServiceName);
	
	//clean up(provider.deprecated=false)
	public void CleanUp();
	
}
