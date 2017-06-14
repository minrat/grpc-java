/**
 * @Title: ServiceFind.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午11:14:43
 * @version V1.0
 */

package com.test.framework.service.discovery;

/**
 * @author Test
 *
 */
public interface InforFinding_Property 
{
	//kafka from local file
	public boolean KFKFind_File(); 
	
	//kafka from server
	public boolean KFKFind_Server(); 
}
