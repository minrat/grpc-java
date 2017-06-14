/**
 * @Title: SP_Dinner.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 上午10:49:12
 * @version V1.0
 */

package com.test.framework.provider;

import com.minrat.grpc.proto.helloworld.DinnerReply;
import com.minrat.grpc.proto.helloworld.DinnerRequest;
import com.minrat.grpc.proto.helloworld.DinnerGrpc.DinnerImplBase;
import com.test.framework.service.util.SystemTool;

import io.grpc.stub.StreamObserver;

/**
 * @author Test
 *
 */
public class SP_Dinner extends DinnerImplBase
{
	 private final String info;
	 private final  String  flagName= SystemTool.ServerFlag();

	  public SP_Dinner(String info) {
	    this.info = info;
	  }
	  
	  
	/* (non-Javadoc)
	 * @see com.bocloud.grpc.proto.helloworld.DinnerGrpc.DinnerImplBase#haveDinner(com.bocloud.grpc.proto.helloworld.DinnerRequest, io.grpc.stub.StreamObserver)
	 */
	@Override
	public void haveDinner(DinnerRequest request, StreamObserver<DinnerReply> responseObserver) {
		try 
		 {
			System.out.println("[SP_Dinner] from  ["+flagName+ "]   " + info + "  [let's have a dinner!]   " + request.getName()+ "   start");
			DinnerReply reply = DinnerReply.newBuilder().setMessage("OK , Let's have a dinner!").build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		 } 
		 catch (Exception e) 
		 {
		      e.printStackTrace();
		 }
		System.out.println("[SP_Dinner] from  ["+flagName+ "]   "+ info + "   [let's have a dinner!]  " + request.getName() + " end");
	}
	
	
	
}
