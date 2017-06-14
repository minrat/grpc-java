/**
 * @Title: SP_Drink.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 上午9:46:54
 * @version V1.0
 */

package com.test.framework.provider;

import com.minrat.grpc.proto.helloworld.DrinkGrpc;
import com.minrat.grpc.proto.helloworld.DrinkReply;
import com.minrat.grpc.proto.helloworld.DrinkRequest;
import com.test.framework.service.util.SystemTool;

import io.grpc.stub.StreamObserver;
/**
 * @author Test
 * 
 */
public class SP_Drink extends DrinkGrpc.DrinkImplBase
{
	 private final String info;
	 private final  String  flagName= SystemTool.ServerFlag();
	 
	 public SP_Drink(String info)
	 {
		 this.info=info;
	 }
	 
	 /* (non-Javadoc)
	 * @see com.bocloud.grpc.proto.helloworld.DrinkGrpc.DrinkImplBase#haveDrink(com.bocloud.grpc.proto.helloworld.DrinkRequest, io.grpc.stub.StreamObserver)
	 */
	@Override
	public void haveDrink(DrinkRequest request, StreamObserver<DrinkReply> responseObserver) 
	{
		try 
		 {
			System.out.println("[SP_Drink] from ["+flagName+ "]  " + info + "  let's have a drink  " + request.getName()+ " start");
			
			DrinkReply reply = DrinkReply.newBuilder().setMessage("OK,Let's have a drink  " +info).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		 } 
		 catch (Exception e) 
		 {
		      e.printStackTrace();
		 }
		System.out.println("[SP_Drink] from ["+flagName+ "]  " + info + "{let's have a drink}  " + request.getName()+ " start");
	}
	
	
}
