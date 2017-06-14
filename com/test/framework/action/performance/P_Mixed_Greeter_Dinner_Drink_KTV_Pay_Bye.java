/**
 * @Title: P_Mixed_Greeter_Dinner_Pay_Bey.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月18日 上午9:36:04
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
public class P_Mixed_Greeter_Dinner_Drink_KTV_Pay_Bye 
{
	static SP_KTV_RegisterImpl sp_ktv;
	static CS_KTV cs_ktv;
	
	public static void main(String[] args) throws Exception {
		System.out.println("========Mixed [Greeter & Dinner & Drink & KTV & Pay & Bye] Testing  Start============");
		String service ="Greeter_Dinner_Drink_KTV_Pay_Bye_Testing";
		
		int port = Constants.KTV_SERVER_PORT;
		
		//start the greet service
		new Thread(new Runnable() {
					
			@Override
			public void run() {
					sp_ktv = new SP_KTV_RegisterImpl();
					sp_ktv.Greeyet_Dinner_Drink_KTV_Pay_Bye(service, port);
						
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
		

		TimeUnit.SECONDS.sleep(30);
		System.exit(0);
		
		System.out.println("=========Mixed [Greeter & Dinner & Drink & KTV & Pay & Bye] Testing  End============");
	}
}
