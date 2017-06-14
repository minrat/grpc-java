/**
 * @Title: CS_Greeter.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 上午11:30:12
 * @version V1.0
 */

package com.test.framework.consumer.multi;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.GreeterGrpc;
import com.minrat.grpc.proto.helloworld.HelloReply;
import com.minrat.grpc.proto.helloworld.HelloRequest;
import com.test.framework.service.util.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class M_CS_Greeter 
{
		  private static final Logger logger = LoggerFactory.getLogger(M_CS_Greeter.class);
		  private  ManagedChannel channel = null;
		  GreeterGrpc.GreeterBlockingStub blockingStub=null;
		  
		  
		  public M_CS_Greeter () {
			  channel = ManagedChannelBuilder.forAddress(Constants.GREETER_SERVICE_IP, Constants.GREETER_SERVER_PORT)
			          .usePlaintext(true).build();
			  blockingStub = GreeterGrpc.newBlockingStub(channel);
		  }
		   
		//greeter
		  public  void callHello() throws Exception {
		 
		    try {
		    	HelloRequest request = HelloRequest.newBuilder().setName("CS_Greeter").build();
		        HelloReply response = blockingStub.sayHello(request);
		        logger.info(response.getMessage());
		        

		        System.out.println("CS_Greeter Action Done!");
		        
//		        Thread.sleep(20000L);
		        
		        //dinner
		        TMP_Dinner();
		        
		    } finally {
		      if (channel != null) {
		      }
		    }
		  }
		  
		  // call dinner
		  public void TMP_Dinner() throws Exception
		  {
			  M_CS_Dinner cs_dinner = new M_CS_Dinner();
			  cs_dinner.haveDinner();
			  
		  }
		  
		  
		  public void shutdown() throws InterruptedException{
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		  }
}
