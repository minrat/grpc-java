/**
 * @Title: CS_Drink.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午5:25:36
 * @version V1.0
 */

package com.test.framework.consumer.multi;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.DrinkGrpc;
import com.minrat.grpc.proto.helloworld.DrinkReply;
import com.minrat.grpc.proto.helloworld.DrinkRequest;
import com.test.framework.service.util.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class M_CS_Drink {
	
	private static final Logger logger = LoggerFactory.getLogger(M_CS_Drink.class);
	  private  ManagedChannel channel = null;
	  private DrinkGrpc.DrinkBlockingStub blockingStub =null;
	  
	  public M_CS_Drink()
	  {
		  channel = ManagedChannelBuilder.forAddress(Constants.DRINK_SERVICE_IP, Constants.DRINK_SERVER_PORT)
		          .usePlaintext(true).build();
		  blockingStub = DrinkGrpc.newBlockingStub(channel);
	  }

	 //drink
	  public  void haveDrink() throws Exception {
		    try {
		      
		      DrinkRequest request = DrinkRequest.newBuilder().setName("CS_Drink").build();

		      DrinkReply response = blockingStub.haveDrink(request);
		        logger.info(response.getMessage());
		        
		        System.out.println("CS_Drink Action Done!");
//		        Thread.sleep(20000L);

		        //entertainment
		        TMPEntertainment();
		        
		    } finally {
		      if (channel != null) {
//		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  
	  
	  public void TMPEntertainment() throws Exception
	  {
		  M_CS_Entertainment cs_entertainment = new M_CS_Entertainment();
		  cs_entertainment.PlayGame();
	  }
}
