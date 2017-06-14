/**
 * @Title: CS_Dinner.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午2:36:44
 * @version V1.0
 */

package com.test.framework.consumer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.DinnerGrpc;
import com.minrat.grpc.proto.helloworld.DinnerReply;
import com.minrat.grpc.proto.helloworld.DinnerRequest;
import com.test.framework.service.util.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class CS_Dinner {
	private static final Logger logger = LoggerFactory.getLogger(CS_Dinner.class);
	  private  ManagedChannel channel = null;
	  private  DinnerGrpc.DinnerBlockingStub blockingStub =null;
	  
	  public CS_Dinner()
	  {
//		  channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Dinner")
		  channel = ManagedChannelBuilder.forAddress(Constants.DINNER_SERVICE_IP, Constants.DINNER_SERVER_PORT)
		          .usePlaintext(true).build();
		  blockingStub = DinnerGrpc.newBlockingStub(channel);
	  }
	  
	  //dinner
	  public  void haveDinner() throws InterruptedException {
		    try {
		      DinnerRequest request = DinnerRequest.newBuilder().setName("CS_Dinner").build();
		      DinnerReply response = blockingStub.haveDinner(request);
		        logger.info(response.getMessage());
		        Thread.sleep(20000L);
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
}
