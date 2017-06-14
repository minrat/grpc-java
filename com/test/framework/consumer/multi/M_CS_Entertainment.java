/**
 * @Title: CS_Entertainment.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月21日 下午3:48:47
 * @version V1.0
 */

package com.test.framework.consumer.multi;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.EntertainmentGrpc;
import com.minrat.grpc.proto.helloworld.GameReply;
import com.minrat.grpc.proto.helloworld.GameRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class M_CS_Entertainment {
	
	private static final Logger logger = LoggerFactory.getLogger(M_CS_Entertainment.class);
	  private  ManagedChannel channel = null;
	  private EntertainmentGrpc.EntertainmentBlockingStub blockingStub=null;
	  
	  public M_CS_Entertainment()
	  {
		  channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Entertainment")
		          .usePlaintext(true).build();
		  blockingStub  = EntertainmentGrpc.newBlockingStub(channel);
	  }
	   
	  //entertainment
	  public  void PlayGame() throws Exception {
	 
	    try {
	      
	      GameRequest request = GameRequest.newBuilder().setName("CS_Entertainment").build();
	    	  
	      GameReply response = blockingStub.game(request);
	      
	        logger.info(response.getMessage());
	        
	        System.out.println("CS_Entertainment Action Done!");
	        
//	        Thread.sleep(20000L);

	        TMP_Pay();
	        
	    } finally {
	      if (channel != null) {

	      }
	    }
	  }
	  
	 public void TMP_Pay() throws Exception
	 {
		 M_CS_Pay cs_pay =new M_CS_Pay();
		 cs_pay.callPayBill();
	 }
	  
}
