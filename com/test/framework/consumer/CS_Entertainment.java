/**
 * @Title: CS_Entertainment.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月21日 下午3:48:47
 * @version V1.0
 */

package com.test.framework.consumer;

import java.util.concurrent.atomic.AtomicLong;

import com.minrat.grpc.proto.helloworld.EntertainmentGrpc;
import com.minrat.grpc.proto.helloworld.GameReply;
import com.minrat.grpc.proto.helloworld.GameRequest;
import com.test.framework.service.util.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class CS_Entertainment {
	private ManagedChannel channel = null;
	private EntertainmentGrpc.EntertainmentBlockingStub blockingStub = null;

	public CS_Entertainment() {
		channel = ManagedChannelBuilder
				.forAddress(Constants.ENTERTAINMENT_SERVICE_IP, Constants.Entertainment_SERVER_PORT)
				// channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Entertainment")
				.usePlaintext(true).build();
		blockingStub = EntertainmentGrpc.newBlockingStub(channel);
	}

	// entertainment
	public void PlayGame() throws InterruptedException {

		try {
			String Param = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
			GameRequest request = GameRequest.newBuilder().setName(Param).build();
			blockingStub.game(request);
			// logger.info(response.getMessage());
			// Thread.sleep(20000L);
		} finally {
			if (channel != null) {
				// channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			}
		}
	}


	public CS_Entertainment(String param) {
		channel = ManagedChannelBuilder
				.forAddress(Constants.ENTERTAINMENT_SERVICE_IP, Constants.Entertainment_SERVER_PORT)
				// channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Entertainment")
				.usePlaintext(true).build();
		blockingStub = EntertainmentGrpc.newBlockingStub(channel);
	}

	public void testPlay(AtomicLong rowCount) throws InterruptedException {
		// 和原来的代码保持一致
		try {
			GameRequest request = GameRequest.newBuilder().setName("CS_Entertainment").build();
			GameReply response = blockingStub.game(request);
			rowCount.addAndGet(1);
			//System.out.println(response.getMessage());

		} finally {
			if (channel != null) {
				// channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			}
		}
	}
}
