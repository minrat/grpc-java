/**
 * @Title: Deamon_Default_Connection.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月24日 下午9:50:06
 * @version V1.0
 */

package com.test.framework.action.function.loadbalance;



import com.test.framework.consumer.CS_Pay;
import com.test.framework.service.util.PropertyTool;

/**
 * @author Test
 *
 *	here need cover the following situation
 *	1.pick_first
 *	2.round_robin
 *	3.weighht_round_robin
 *
 */
public class Deamon_LoadBalance_Connection {
	
		//support count
		private static CS_Pay cs_pay;
		
		
		public Deamon_LoadBalance_Connection()
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
		
		//pick_first
		public void choose_pick_first()
		{
			String key="consumer.default.loadbalance";
			String value="pick_first";
			try {
				PropertyTool.SetTargetValue(key, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//round_robin
		public void choose_round_robin()
		{
			String key="consumer.default.loadbalance";
			String value="round_robin";
			try {
				PropertyTool.SetTargetValue(key, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//weight_round_robin
		public void choose_weight_round_robin()
		{
			String key="consumer.default.loadbalance";
			String value="weight_round_robin";
			try {
				PropertyTool.SetTargetValue(key, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public static void Story_02() throws Exception
		{
			Deamon_LoadBalance_Connection cs = new Deamon_LoadBalance_Connection();
			for (int i=0;i<100;i++)
			{
				System.out.println("Long Long Ag0, Start Pay Job........");
				
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
				
			}
		}
		
		public static void main(String[] args) throws Exception {
		
			Story_02();
		}

		
		
	}
