/**
 * @Title: CS_Pay.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午2:21:26
 * @version V1.0
 */

package com.test.framework.consumer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.PayGrpc;
import com.minrat.grpc.proto.helloworld.PayReply;
import com.minrat.grpc.proto.helloworld.PayRequest;
import com.test.framework.service.util.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class CS_Pay {

	 private static final Logger logger = LoggerFactory.getLogger(CS_Pay.class);
	  private  ManagedChannel channel = null;
	  private PayGrpc.PayBlockingStub blockingStub = null;
	  
	  
	  public CS_Pay()
	  {
		  channel = ManagedChannelBuilder.forAddress(Constants.PAY_SERVICE_IP, Constants.PAY_SERVER_PORT)
//		  channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Pay")
		          .usePlaintext(true).build();
		  blockingStub = PayGrpc.newBlockingStub(channel);
	  }
	  
	  
	  //pay the bill
	  public  void callPayBill() throws InterruptedException {
		    try {
		     
		      PayRequest request = PayRequest.newBuilder().setName("Simple_Pay_Testing").build();
		      
		      PayReply response = blockingStub.consumerPay(request);
//		      System.out.println(response.getMessage());
		      logger.info(response.getMessage());
//		      Thread.sleep(20000L);
		      System.out.println("Pay Action Done!");
		      
		      
		    } finally {
		      if (channel != null) {
		       
		      }
		    }
		  }
	  
	  
	  public void shutdown() throws Exception
	  {
		  channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	  }
}
