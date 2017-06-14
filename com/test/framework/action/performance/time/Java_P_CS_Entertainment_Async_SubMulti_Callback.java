/**
 * @Title: P_Greeter.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月26日 下午4:44:28
 * @version V1.0
 */

package com.test.framework.action.performance.time;

import com.test.framework.consumer.CS_Entertainment;
import com.test.framework.consumer.CS_Greeter;

/**
 * @author Test
 *
 */
public class Java_P_CS_Entertainment_Async_SubMulti_Callback {
	
	//consumer
	private static CS_Entertainment cs_game=null;
	
	private static float max=0;
	private static float min=999999;
	private static int channel_count=0;
	private static int thread_count=0;
	private static float sum=0;
	private static float ava=0;
	public static String out="---";

	 
	private static Object lock = new Object();
	
	 public Java_P_CS_Entertainment_Async_SubMulti_Callback()
	 {
		 try {
			Inital();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 private void Inital() throws Exception
	 {
		 cs_game = new CS_Entertainment();
	 }
	 
	 public String  story_01()
	 {
		 System.out.println("Max-Min-Sum-Ava  kick off");
		int i;
		 
		 //channel 
		
		//situation 1: 100 thread(default async) * 1000 callback
		 for (i=0;i<100;i++)
			{
			 	long startTime=System.currentTimeMillis();
			 	
			 	
			 	new Thread(new Runnable() {
					
					@Override
					public void run() 
					{
						try {
							for (int j=0;j<100;j++)
							{
								long cs_game_startTime=System.currentTimeMillis();
								cs_game.PlayGame();
								long cs_game_endTime=System.currentTimeMillis();
								float cs_game_excTime=(float)(cs_game_endTime-cs_game_startTime)/1000;
								 synchronized(lock)
								 {
									 thread_count++;
								 }
								 
								 //time
								 if (cs_game_excTime > max)
									{
										max=cs_game_excTime;
									}
									else if (cs_game_excTime < min)
									{
										min=cs_game_excTime;
									}
								 
								System.out.println("Current [" +channel_count+"--"+j+ "] PlayGame   Cost : "+cs_game_excTime +"s");
								
								sum= sum+cs_game_excTime;
								
							}
							ava= sum/thread_count;
//							 System.out.println("Total is :"+sum +" s");
//							 System.out.println("Max is :"+max+" s");
//							 System.out.println("Min is :"+min+" s");
//							 System.out.println("Ava is :"+ava+" s");
							 System.out.println("thread * count:=======>>>>>>"+thread_count);
							 
							out="Thread :["+channel_count+"] Count: ["+thread_count+"] Max:"+max+" Min:"+min+" Ava: "+ava;
							 System.out.println(out);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					}).start();;
			 	
//			 	long endTime=System.currentTimeMillis();
//				float excTime=(float)(endTime-startTime)/1000;
//				System.out.println("Current Start Thread [" +i+ "]  Cost : "+excTime +"s");
				
				channel_count++;
				
//				if (excTime > max)
//				{
//					max=excTime;
//				}
//				else if (excTime < min)
//				{
//					min=excTime;
//				}
//				sum=sum+excTime;
			}
		 
//		 ava= sum/channel_count;
		 
//		 System.out.println("Total is :"+sum);
//		 System.out.println("Max is :"+max);
//		 System.out.println("Min is :"+min);
//		 System.out.println("Ava is :"+ava);
		 
		 return out;
	 }
	 
	 public static void main(String[] args) throws Exception {
		 Java_P_CS_Entertainment_Async_SubMulti_Callback p = new Java_P_CS_Entertainment_Async_SubMulti_Callback();
		 String out = p.story_01();
		 System.out.println(out);
		
	}

}
