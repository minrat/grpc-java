/**
 * @Title: CS_Bye.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午2:28:52
 * @version V1.0
 */

package com.test.framework.consumer.multi;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.ByeReply;
import com.minrat.grpc.proto.helloworld.ByeRequest;
import com.minrat.grpc.proto.helloworld.GoodByeGrpc;
import com.test.framework.service.util.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class M_CS_Bye {

	  private static final Logger logger = LoggerFactory.getLogger(M_CS_Bye.class);
	  private  ManagedChannel channel = null;
	  private GoodByeGrpc.GoodByeBlockingStub blockingStub =null;
	  
	  
	  public M_CS_Bye()
	  {
		  channel = ManagedChannelBuilder.forAddress(Constants.BYE_SERVICE_IP, Constants.BYE_SERVER_PORT)
		          .usePlaintext(true).build();
		  blockingStub = GoodByeGrpc.newBlockingStub(channel);
	  }
	  
	  //goodbye
	  public  void callGoodBye() throws Exception {
	    try {
	    	
	    	ByeRequest request = ByeRequest.newBuilder().setName("CS_Bye").build();
	      
	    	ByeReply response = blockingStub.sayBye(request);
	    	System.out.println(response.getMessage());
	    	logger.info(response.getMessage());
	    	System.out.println("CS_Bye Action Done!");
	    	
	    	
	    	
	    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~~~~~~~");
	    	

	    } finally {
	      if (channel != null) {
	        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	      }
	    }
	  }
	  
	  
}
