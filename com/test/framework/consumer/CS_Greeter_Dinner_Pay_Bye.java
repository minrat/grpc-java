/**
 * @Title: CS_Dinner.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 下午4:08:25
 * @version V1.0
 */

package com.test.framework.consumer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.ByeReply;
import com.minrat.grpc.proto.helloworld.ByeRequest;
import com.minrat.grpc.proto.helloworld.DinnerGrpc;
import com.minrat.grpc.proto.helloworld.DinnerReply;
import com.minrat.grpc.proto.helloworld.DinnerRequest;
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
public class CS_Greeter_Dinner_Pay_Bye 
{
	 private static final Logger logger = LoggerFactory.getLogger(CS_Greeter_Dinner_Pay_Bye.class.getClass());


	 private  ManagedChannel channel = null;
	 
	   
	  //hello
	  public  void callHello() throws InterruptedException {
	 
	    try {
	      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Greeter")
	          .usePlaintext(true).build();
	      GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);
	      HelloRequest request = HelloRequest.newBuilder().setName("Simple_Greeting_Dinner_Bye").build();
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
	  
	  //dinner
	  public void haveDinner()throws InterruptedException {
	  
		  try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Dinner")
		          .usePlaintext(true).build();
		      DinnerGrpc.DinnerBlockingStub blockingStub = DinnerGrpc.newBlockingStub(channel);
		      DinnerRequest request = DinnerRequest.newBuilder().setName("CS_Dinner").build();
		      while (true) {
		      
		      DinnerReply response = blockingStub.haveDinner(request);
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

	  
	  //pay
	  public void PayBill() throws InterruptedException {
		  try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.GoodBye")
		          .usePlaintext(true).build();
		      GoodByeGrpc.GoodByeBlockingStub blockingStub = GoodByeGrpc.newBlockingStub(channel);
		      ByeRequest request = ByeRequest.newBuilder().setName("Simple_Greeting_Dinner_Bye").build();
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
	  
	  //goodbye
	  public  void callGoodBye() throws InterruptedException {
	    try {
	      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.GoodBye")
	          .usePlaintext(true).build();
	      GoodByeGrpc.GoodByeBlockingStub blockingStub = GoodByeGrpc.newBlockingStub(channel);
	      ByeRequest request = ByeRequest.newBuilder().setName("Simple_Greeting_Dinner_Bye").build();
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
	  
	  
	  public void HaveDinner() throws Exception
	  {
		  //01- hello
		  callHello();
		  //02- dinner
		  haveDinner();
		  //03- pay
		  PayBill();
		  //04- bye
		  callGoodBye();
	  }
	  

	}
