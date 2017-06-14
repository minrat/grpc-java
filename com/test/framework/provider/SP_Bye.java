/**
 * @Title: SP_Bye.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 下午12:06:42
 * @version V1.0
 */

package com.test.framework.provider;

import com.minrat.grpc.proto.helloworld.ByeReply;
import com.minrat.grpc.proto.helloworld.ByeRequest;
import com.minrat.grpc.proto.helloworld.GoodByeGrpc;
import com.test.framework.service.util.SystemTool;

import io.grpc.stub.StreamObserver;

/**
 * @author Test
 *
 */
public class SP_Bye extends GoodByeGrpc.GoodByeImplBase{

	 private final String info;
	 private final  String  flagName= SystemTool.ServerFlag();
	 

	  

	  public SP_Bye(String info) {
	    this.info = info;
	  }
	  
	/* (non-Javadoc)
	 * @see com.bocloud.grpc.proto.helloworld.GoodByeGrpc.GoodByeImplBase#sayBye(com.bocloud.grpc.proto.helloworld.ByeRequest, io.grpc.stub.StreamObserver)
	 */
	@Override
	public void sayBye(ByeRequest request, StreamObserver<ByeReply> responseObserver) {
		
		System.out.println("[SP_Bye]    from ["+flagName+ "]   ---> Bye  to < " +  info +">  "+  request.getName() + " start >>>");
	    try {
	      ByeReply reply = ByeReply.newBuilder().setMessage("Bye " + info).build();
	      responseObserver.onNext(reply);
	      responseObserver.onCompleted();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    
	    
	    System.out.println("[SP_Bye]  from ["+flagName+ "] ---> Bye to < " + info  +">  "+ request.getName() + " end <<<");
	  }


}
