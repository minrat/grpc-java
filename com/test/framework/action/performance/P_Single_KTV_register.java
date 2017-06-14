/**
 * @Title: P_KTV.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月18日 下午2:46:07
 * @version V1.0
 */

package com.test.framework.action.performance;

import java.util.concurrent.TimeUnit;

import com.test.framework.consumer.CS_KTV;
import com.test.framework.service.register.single_impl.SP_KTV_RegisterImpl;
import com.test.framework.service.util.Constants;

/**
 * @author Test
 *
 */
public class P_Single_KTV_register {
	
	static SP_KTV_RegisterImpl sp_ktv;
	static CS_KTV cs_ktv;
	
	public static void main(String[] args) throws Exception {
		System.out.println("========Single KTV Testing  Start============");
		String service ="Single_Pay_Testing";
		
		int port = Constants.PAY_SERVER_PORT;
		
		//start the greet service
		new Thread(new Runnable() {
					
			@Override
			public void run() {
					sp_ktv = new SP_KTV_RegisterImpl();
					sp_ktv.start(service, port);
						
				}
			}).start();;
				
				
		TimeUnit.SECONDS.sleep(1);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				cs_ktv = new CS_KTV();	
				try {
					cs_ktv.goKTV();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}).start();;
		

		TimeUnit.SECONDS.sleep(5);
		System.exit(0);
		
		System.out.println("========Single KTV Testing  End============");
	}
}
