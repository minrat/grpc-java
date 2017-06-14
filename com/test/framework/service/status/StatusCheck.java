/**
 * @Title: StatusCheck.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午11:26:04
 * @version V1.0
 */

package com.test.framework.service.status;

import java.util.List;

/**
 * @author Test
 *
 */
public interface StatusCheck 
{
	
	public boolean ZKStatus();
	
	public boolean KFKStatus();
	
	public List<?> GetKFKBrokers();
	
	public List<?> GetServiceProvider();
	
	public List<?> GetServiceComsumer();
}
