/**
 * @Title: SP_Entertainment.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 上午9:48:38
 * @version V1.0
 */

package com.test.framework.provider;

import java.util.logging.Logger;

import com.minrat.grpc.proto.helloworld.EntertainmentGrpc;
import com.minrat.grpc.proto.helloworld.GameReply;
import com.minrat.grpc.proto.helloworld.GameRequest;
import com.test.framework.service.util.SystemTool;

import io.grpc.stub.StreamObserver;

/**
 * @author Test
 * 
 *
 */
public class SP_Entertainment extends EntertainmentGrpc.EntertainmentImplBase {
	private final String info;
	private final String flagName = SystemTool.ServerFlag();
	private static Object lock = new Object();
	private static long count = 0L;
	private static final Logger logger = Logger.getLogger(SP_Entertainment.class.getName());

	public SP_Entertainment(String info) {
		this.info = info;
	}

	@Override
	public void game(GameRequest request, StreamObserver<GameReply> responseObserver) {
		// 和原来的测试代码保持一致

		logger.info("[SP_Entertainment] from [" + flagName + "]  " + info + "   game time   " + request.getName()
				+ " start--->>>");

		try {
			//Thread.sleep(1);// 模拟业务处理时间

			GameReply reply = GameReply.newBuilder().setMessage("OK, It is game time now ! " + info).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		} catch (Exception e) {
			e.printStackTrace();
		}

		synchronized (lock) {
			count++;
		}

		logger.info("Current Count is " + count);
		logger.info("[SP_Entertainment] from [" + flagName + "]  " + info + "   game time " + request.getName()
				+ " >>>--- end");
	}

}
