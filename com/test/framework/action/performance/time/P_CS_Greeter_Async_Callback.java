/**
 * @Title: P_Greeter.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月26日 下午4:44:28
 * @version V1.0
 */

package com.test.framework.action.performance.time;

import com.test.framework.consumer.CS_Greeter;

/**
 * @author Test
 *
 *	500 Threads consumer  single provider by one channel 
 */
public class P_CS_Greeter_Async_Callback {
	
	//consumer
	private static CS_Greeter cs_game=null;
	
	private static float max=0;
	private static float min=999999;
	private static int channel_count=0;
	private static int thread_count=0;
	private static float sum=0;
	private static float ava=0;
	 
	 public P_CS_Greeter_Async_Callback()
	 {
		 try {
			Inital();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 private void Inital() throws Exception
	 {
		 cs_game = new CS_Greeter();
	 }
	 
	 public void story_01()
	 {
		 System.out.println("Max-Min-Sum-Ava  kick off");
		
		 
		 //channel 
		 for (int i=0;i<1;i++)
			{
			 	long startTime=System.currentTimeMillis();
			 	
			 	new Thread(new Runnable() {
					
					@Override
					public void run() 
					{
						try {
							cs_game.callHello();
//							cs_game.shutdown();
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					}).start();;
			 	
			 	long endTime=System.currentTimeMillis();
				float excTime=(float)(endTime-startTime)/1000;
				System.out.println("Current [" +i+ "]  Cost : "+excTime +"s");
				
				channel_count++;
				
				if (excTime > max)
				{
					max = excTime;
				}
				else if (excTime < min)
				{
					min = excTime;
				}
				sum= sum+excTime;
			}
		 
		 ava= sum/channel_count;
		 
		 System.out.println("Total is :"+sum+" s");
		 System.out.println("Max is :"+max+" s");
		 System.out.println("Min is :"+min+" s");
		 System.out.println("Ava is :"+ava+" s");
		 System.out.println("Channel count is :"+channel_count);
	 }
	 
	 public static void main(String[] args) throws Exception {
		 P_CS_Greeter_Async_Callback p = new P_CS_Greeter_Async_Callback();
		 p.story_01();
		
	}

}
