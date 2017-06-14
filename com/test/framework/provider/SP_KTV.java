/**
 * @Title: SP_KTV.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 上午9:45:06
 * @version V1.0
 */

package com.test.framework.provider;

import com.minrat.grpc.proto.helloworld.KTVGrpc;
import com.minrat.grpc.proto.helloworld.KTVReply;
import com.minrat.grpc.proto.helloworld.KTVRequest;
import com.test.framework.service.util.SystemTool;

import io.grpc.stub.StreamObserver;

/**
 * @author Test
 * 
 */
public class SP_KTV extends KTVGrpc.KTVImplBase 
{
	 private final String info;
	 private final  String  flagName= SystemTool.ServerFlag();
	 
	 public SP_KTV(String info)
	 {
		 this.info=info;
	 }
	 
	 /* (non-Javadoc)
	 * @see com.bocloud.grpc.proto.helloworld.KTVGrpc.KTVImplBase#goKTV(com.bocloud.grpc.proto.helloworld.KTVRequest, io.grpc.stub.StreamObserver)
	 */
	@Override
	public void goKTV(KTVRequest request, StreamObserver<KTVReply> responseObserver) 
	{
		 try 
		 {
			System.out.println("[SP_KTV]  from ["+flagName+ "]" + info + "{let's go to ktv}  " + request.getName()+ " start");
			KTVReply reply = KTVReply.newBuilder().setMessage("OK, Let's go to ktv!"+info).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		 } 
		 catch (Exception e) 
		 {
		      e.printStackTrace();
		 }
		System.out.println("[SP_KTV]  from ["+flagName+ "]" + info + "{let's go to ktv}  " + request.getName() + " end");
	}
	 
	
	 
}
