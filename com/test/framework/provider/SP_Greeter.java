/**
 * @Title: SP_Greeter.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月13日 下午4:57:14
 * @version V1.0
 */

package com.test.framework.provider;

import com.minrat.grpc.proto.helloworld.GreeterGrpc;
import com.minrat.grpc.proto.helloworld.HelloReply;
import com.minrat.grpc.proto.helloworld.HelloRequest;
import com.test.framework.service.util.SystemTool;

import io.grpc.stub.StreamObserver;

/**
 * @author Test
 *
 */
public class SP_Greeter extends GreeterGrpc.GreeterImplBase {

	private final String info;
	private final String flagName = SystemTool.ServerFlag();

	private static Object lock = new Object();
	private static long count = 0L;

	public SP_Greeter(String info) {
		this.info = info;
	}

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {

		System.out.println("[SP_Greeter]  from [" + flagName + "]" + "   ---> Hello  to < " + info + ">  "
				+ request.getName() + " start >>>");
		try {
			HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + info).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		} catch (Exception e) {
			e.printStackTrace();
		}

		synchronized (lock) {
			count++;
		}

		System.out.println("Current Count is " + count);

		System.out.println("[SP_Greeter]   from [" + flagName + "]" + "  ---> Hello to < " + info + ">  "
				+ request.getName() + " end <<<");
	}

}