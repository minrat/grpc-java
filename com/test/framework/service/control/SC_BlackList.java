/**
 * @Title: ServiceControl.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午11:15:18
 * @version V1.0
 */

package com.test.framework.service.control;

/**
 * @author Test
 *
 */
public interface SC_BlackList 
{
	
	//黑名单获取
	public String CurrentBlackList(String service);
	
	//黑名单增加
	public boolean AddBlackList(String serice,String strategy);
	
	//黑名单增加校验
	public boolean AddBlackListVerify(String serice,String strategy);
	
	//黑名单移除
	public boolean DeleteBlackList(String serice);
	
	//黑名单移除校验
	public boolean DeleteBlackListVerify(String serice);
	
	
	public void CleanUp();
	
}
