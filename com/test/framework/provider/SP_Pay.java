/**
 * @Title: SP_Pay.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月13日 下午5:16:09
 * @version V1.0
 */

package com.test.framework.provider;

import com.minrat.grpc.proto.helloworld.PayGrpc;
import com.minrat.grpc.proto.helloworld.PayReply;
import com.minrat.grpc.proto.helloworld.PayRequest;
import com.test.framework.service.util.SystemTool;

import io.grpc.stub.StreamObserver;

/**
 * @author Test
 *
 *rpc SayHello (HelloRequest) returns (HelloReply) {}
 *rpc ConsumerPay (PayRequest) returns (PayReply) {}
 */
public class SP_Pay extends PayGrpc.PayImplBase {

	  private final String info;
	  private final  String  flagName= SystemTool.ServerFlag();
	  
	  private static Object lock = new Object();
	  private static long count=0L;
		 

	  public SP_Pay(String info) {
	    this.info = info;
	  }
	  

	  @Override
	  public void consumerPay(PayRequest request, StreamObserver<PayReply> responseObserver) {
	    System.out.println("[SP_Pay]  from ["+flagName+ "]   "+ info + "  {let's pay it}    " + request.getName() + " --start >>>");
	    try {
	      PayReply reply = PayReply.newBuilder().setMessage("Pay " + info).build();
	      responseObserver.onNext(reply);
	      responseObserver.onCompleted();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    synchronized(lock){
	    	 count++;
	    }
	   
	    System.out.println("Current [SP_Pay] Count is ["+count+" ] from :  "+flagName+" time : "+System.currentTimeMillis());
	    
	    System.out.println("[SP_Pay]  from ["+flagName+ "]   " + info + "   {let's pay it}    " + request.getName() + " --end <<<");
	  }

	}
