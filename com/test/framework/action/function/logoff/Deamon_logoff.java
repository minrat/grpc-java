/**
 * @Title: Deamon_logoff.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月25日 下午3:32:01
 * @version V1.0
 */

package com.test.framework.action.function.logoff;

import com.test.framework.service.register.single_impl.SP_Greeter_RegisterImpl;
import com.test.framework.service.util.Constants;

/**
 * @author Test
 *
 */
public class Deamon_logoff {
	//SP-greeter
		private static SP_Greeter_RegisterImpl sp_greeter;

		public Deamon_logoff()
		{
			initServer();
		}
		
		public void initServer()
		{
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					sp_greeter = new SP_Greeter_RegisterImpl();
					sp_greeter.start(Constants.GREETER_SERVER_NAME, Constants.GREETER_SERVER_PORT);
				}
			}).start();;
		}
		
		public static void main(String[] args) throws Exception {
			
			Deamon_logoff logoff = new Deamon_logoff();
			
			Thread.sleep(2000L);
			sp_greeter.DoRegisterClean(Constants.GREETER_SERVER_NAME);
			
		}
}
