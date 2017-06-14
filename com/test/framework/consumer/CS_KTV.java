/**
 * @Title: CS_KTV.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午2:37:07
 * @version V1.0
 */

package com.test.framework.consumer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.KTVGrpc;
import com.minrat.grpc.proto.helloworld.KTVReply;
import com.minrat.grpc.proto.helloworld.KTVRequest;
import com.test.framework.service.util.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class CS_KTV {

	private static final Logger logger = LoggerFactory.getLogger(CS_KTV.class);
	  private  ManagedChannel channel = null;
	  private KTVGrpc.KTVBlockingStub blockingStub =null;

	  public CS_KTV()
	  {
		  channel = ManagedChannelBuilder.forAddress(Constants.KTV_SERVICE_IP, Constants.KTV_SERVER_PORT)
//		  channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.KTV")
		          .usePlaintext(true).build();
		  blockingStub = KTVGrpc.newBlockingStub(channel);
	  }
	  
	  //ktv
	  public  void goKTV() throws InterruptedException {
			 
		    try {
		      
		      KTVRequest request = KTVRequest.newBuilder().setName("CS_KTV").build();

		      KTVReply response = blockingStub.goKTV(request);
		        logger.info(response.getMessage());
//		        Thread.sleep(20000L);
		        
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
}
