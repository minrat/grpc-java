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
public class Java_P_CS_Entertainment_Sync_100000 {
	
	//consumer
		private static CS_Entertainment cs_game=null;
		
		private static float max=0;
		private static float min=999999;
		private static int channel_count=0;
		private static int thread_count=0;
		private static float sum=0;
		private static float ava=0;
		 
		private static Object lock = new Object();
		
		 public Java_P_CS_Entertainment_Sync_100000()
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
						cs_game.PlayGame();
						for (int j=0;j<100000;j++)
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
							//add sleep action
							//Thread.sleep(1);
						}
						 ava= sum/thread_count;
//						 System.out.println("Total is :"+sum +" s");
//						 System.out.println("Max is :"+max+" s");
//						 System.out.println("Min is :"+min+" s");
//						 System.out.println("Ava is :"+ava+" s");
						
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		 
					return "Count: ["+thread_count+"] Max:"+max+" Min:"+min+" Ava: "+ava;
	 }

	 public void srory_01()
	 {
		 
	 }
	 
	 
	 public static void main(String[] args) {
			 Java_P_CS_Entertainment_Sync_100000 p = new Java_P_CS_Entertainment_Sync_100000();
				String out = p.story_00();
				 System.out.println(out);
		
	}
}
