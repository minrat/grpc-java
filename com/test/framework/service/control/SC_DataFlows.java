/**
 * @Title: SC_DataFlows.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月18日 上午9:41:56
 * @version V1.0
 */

package com.test.framework.service.control;

/**
 * @author Test
 *
 */
public interface SC_DataFlows 
{
	//流量获取
	public int CurrentFlow();
	
	//流量控制
	public boolean FlowSetting(int value);
		
	//流量控制校验
	public boolean FlowSettingVerify(int value);
	
	//clean up
	public void Cleanup();
}
