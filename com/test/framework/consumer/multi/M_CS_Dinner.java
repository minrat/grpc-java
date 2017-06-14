/**
 * @Title: CS_Dinner.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午2:36:44
 * @version V1.0
 */

package com.test.framework.consumer.multi;

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
public class M_CS_Dinner {
	private static final Logger logger = LoggerFactory.getLogger(M_CS_Dinner.class);
	  private  ManagedChannel channel = null;
	  private  DinnerGrpc.DinnerBlockingStub blockingStub =null;
	  
	  public M_CS_Dinner()
	  {
		  channel = ManagedChannelBuilder.forAddress(Constants.DINNER_SERVICE_IP, Constants.DINNER_SERVER_PORT)
		          .usePlaintext(true).build();
		  blockingStub = DinnerGrpc.newBlockingStub(channel);
	  }
	  
	  //dinner
	  public  void haveDinner() throws Exception {
		    try {
		      DinnerRequest request = DinnerRequest.newBuilder().setName("CS_Dinner").build();
		      DinnerReply response = blockingStub.haveDinner(request);
		        logger.info(response.getMessage());
		        System.out.println("CS_Dinner Action Done!");
//		        Thread.sleep(20000L);
		        
		        //entertainment
		        TMP_Drink();
		        
		    } finally {
		      if (channel != null) {
//		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  
	  public void TMP_Drink() throws Exception
	  {
		  M_CS_Drink cs_drink = new M_CS_Drink();
		  cs_drink.haveDrink();
	  }
	  
	  
}
