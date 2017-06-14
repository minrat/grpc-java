package com.test.framework.action.performance.time;

import com.test.framework.consumer.CS_Entertainment;

public class hstc_All_org {

	public static void main(String[] args) {
	      for(int i=0;i<1;i++) {
	    	  test();
	      }

		}

		private static void test() {		
		 int exeCount = 1000;
		 int sleePMil = 0;
		 CS_Entertainment client = new CS_Entertainment();
		 try {
		  client.PlayGame();
		 } catch(Exception ex) {		 
		 }
		 System.out.println("-------------------------begin");
		 double begin = System.nanoTime();
		 new Thread(new Runnable() {
		      @Override
		      public void run() {
		        for(int i=0;i<exeCount;i++){
		          try { 
		            client.PlayGame();
		            if (sleePMil > 0){
		            	Thread.sleep(sleePMil);
		            }
		          } catch (InterruptedException e) {
		            System.out.println("-------------close client");	     
		            e.printStackTrace();
		          }
		        }
		        outResult(begin,exeCount,sleePMil);
		        System.out.println("-------------------------end");
		      }
		    }).start();
		}
		
		
		public static void outResult(double begin,int exeCount,int sleePMil) {
			double end = System.nanoTime();
			double avgTime = (end - begin)/1000000/exeCount; 
			System.out.println("---------avgTime:" + avgTime);
		}

}
