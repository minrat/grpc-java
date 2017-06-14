/**
 * @Title: SC_LoadBalance.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月18日 下午2:30:46
 * @version V1.0
 */

package com.test.framework.service.control;

/**
 * @author Test
 *
 */
public interface SC_LoadBalance 
{
	//当前LR使用
	public String CurrentLRUsing();
	
	//LR选择
	public boolean LRSetting(String name);
	
	//LR选择校验
	public boolean LRSettingVerify(String name);
	
	//clean up
	public void CleanUp();
}
