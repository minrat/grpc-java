/**
 * @Title: Deamon_Default_Connection.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月24日 下午9:50:06
 * @version V1.0
 */

package com.test.framework.action.function.connections;


import java.net.URLEncoder;

import com.test.framework.consumer.CS_Greeter;
import com.test.framework.consumer.CS_Pay;

/**
 * @author Test
 *
 */
public class Deamon_Default_Connection {
	//consumer
		private static CS_Pay cs_pay;
		
		
		public Deamon_Default_Connection()
		{
			try {
				Mixed();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public  void Mixed() throws Exception
		{
			
			cs_pay = new CS_Pay();
			
		}
		
		
		public static void Story_02() throws Exception
		{
			Deamon_Default_Connection cs = new Deamon_Default_Connection();
			for (int i=0;i<1;i++)
			{
				System.out.println("Long Long Ag0,........");
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							
							long startTime=System.currentTimeMillis();
							
							cs_pay.callPayBill();
							
							
							long endTime=System.currentTimeMillis();
							float excTime=(float)(endTime-startTime)/1000;
							System.out.println("Single [ CS_Pay.callPayBill ] Action Cost : "+excTime +"s");
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
				}).start();;
				
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							cs_pay.callPayBill();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
				}).start();;
				
				
			}
		}
		
		public static void main(String[] args) throws Exception {
		
			Story_02();
//			String url ="override://0.0.0.0/com.bocloud.grpc.proto.helloworld.Pay?category=configurators&dynamic=false&application=test-app-01&deprecated=true";
//			System.out.println(URLEncoder.encode(url));
		}

		
		
	}
