/**
 * @Title: P_CS_Entertainment_Sync_SubMulti_Callback.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月27日 下午3:07:30
 * @version V1.0
 */

package com.test.framework.action.performance.time;

import com.test.framework.consumer.CS_Entertainment;

/**
 * @author Test
 *
 */
public class LR_Java_P_CS_Entertainment_100 {
	
	//consumer
		private static CS_Entertainment cs_game=null;
		
		private static float max=0;
		private static float min=999999;
		private static int channel_count=0;
		private static int thread_count=0;
		private static float sum=0;
		private static float ava=0;
		 
		private static Object lock = new Object();
		
		 public LR_Java_P_CS_Entertainment_100()
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
	
	
	 public String story_00()
	 {
		 float out = 0;
		 
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
							 
							sum= sum+cs_game_excTime;
							
							out=cs_game_excTime;
						}
						 ava= sum/thread_count;
						
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		 
					 return "Count: ["+thread_count+"] Max:"+max+" Min:"+min+" Ava: "+ava;
	 }

	 public String  story_01()
	 {
		 System.out.println("Max-Min-Sum-Ava  kick off");
		 
		 //channel 
		//situation 1: 100 thread(default sync) * 1000 callback
		 for (int i=0;i<100;i++)
			{
			 	long startTime=System.currentTimeMillis();
			 	
						try {
							for (int j=0;j<1000;j++)
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
								 
								System.out.println("Current [" +channel_count+"--"+j+ " PlayGame ]  Cost : "+cs_game_excTime +"s");
								
								sum= sum+cs_game_excTime;
							}
							 ava= sum/thread_count;
							
							System.out.println("thread_count:=======>>>>>>"+thread_count);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
			 	
			 	long endTime=System.currentTimeMillis();
				float excTime=(float)(endTime-startTime)/1000;
				System.out.println("Current [" +i+ "]  Cost : "+excTime +"s");
				
				channel_count++;
			}
		 
		 return "Channel :["+channel_count+"] Count: ["+thread_count+"] Max:"+max+" Min:"+min+" Ava: "+ava;
	 }
	 
	 
//	 public static void main(String[] args) {
//			 LR_Htsc_P_CS_Entertainment_Sync p = new LR_Htsc_P_CS_Entertainment_Sync();
//			 String out = p.story_00();
//			 System.out.println(out);
//	}
}
