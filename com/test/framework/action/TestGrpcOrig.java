package com.test.framework.action;

public class TestGrpcOrig {

	public static void main(String[] args) {
		System.out.println("Pass Param 'C' start Client, Else Start Server ..");
	       if (null == args || args.length == 0) {	    	   
	    	   TMP_GrpcServer.serverStart();
	       }
	       if ("C".equals(args[0])) {
	    	   int exeCount = 5;
	    	   int threadCount = 1;
	    	   if(args.length >=2) {
	    		   exeCount = Integer.valueOf(args[1]);
	    	   }
	    	   if(args.length>=3) {
	    		   threadCount = Integer.valueOf(args[2]);
	    	   }
	    	   System.out.println("Client exeCount : " + exeCount + " threadCount:" + threadCount);
	    	   TMP_GrpcClient.clientStart(exeCount,threadCount);
	       }
	       else {	    	   
	    		TMP_GrpcServer.serverStart(); 	   
	       }
	}

}
