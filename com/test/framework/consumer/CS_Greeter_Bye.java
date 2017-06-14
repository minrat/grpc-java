/**
 * @Title: CS_Greeter.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月13日 下午5:24:39
 * @version V1.0
 */

package com.test.framework.consumer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.ByeReply;
import com.minrat.grpc.proto.helloworld.ByeRequest;
import com.minrat.grpc.proto.helloworld.GoodByeGrpc;
import com.minrat.grpc.proto.helloworld.GreeterGrpc;
import com.minrat.grpc.proto.helloworld.HelloReply;
import com.minrat.grpc.proto.helloworld.HelloRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class CS_Greeter_Bye {

	  private static final Logger logger = LoggerFactory.getLogger(CS_Greeter_Bye.class);
	  private  ManagedChannel channel = null;
	   
		
	  //hello
	  public  void callHello() throws InterruptedException {
	    try {
	      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Greeter")
	          .usePlaintext(true).build();
	      GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);
	      HelloRequest request = HelloRequest.newBuilder().setName("CS_Greeter").build();
	      while (true) {
	        HelloReply response = blockingStub.sayHello(request);
	        logger.info(response.getMessage());
	        Thread.sleep(20000L);
	      }
	    } finally {
	      if (channel != null) {
	        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	      }
	    }
	  }
	  

	  //goodbye
	  public  void callGoodBye() throws InterruptedException {
	    try {
	      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.GoodBye")
	          .usePlaintext(true).build();
	      GoodByeGrpc.GoodByeBlockingStub blockingStub = GoodByeGrpc.newBlockingStub(channel);
	      ByeRequest request = ByeRequest.newBuilder().setName("Simple_Greeting_Bye").build();
	      while (true) {
	      
	      ByeReply response = blockingStub.sayBye(request);
	      System.out.println(response.getMessage());
	      logger.info(response.getMessage());
	      Thread.sleep(20000L);
	      }
	    } finally {
	      if (channel != null) {
	        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	      }
	    }
	  }
	  
	  
	  
	  //mixed
	  public void GreetAction() throws Exception
	  {
		  //greet
		  new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(1);
						callHello();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();;
			
			//Bye
			TimeUnit.SECONDS.sleep(2);
			 new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							TimeUnit.SECONDS.sleep(2);
							callGoodBye();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();;
			
		  
		  
	  }

	}
