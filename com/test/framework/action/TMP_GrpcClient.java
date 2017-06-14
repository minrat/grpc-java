package com.test.framework.action;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.minrat.grpc.proto.helloworld.GreeterGrpc;
import com.minrat.grpc.proto.helloworld.HelloRequest;
import com.test.framework.service.util.Constants;
import com.test.framework.service.util.PropertyTool;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class TMP_GrpcClient {
	private final ManagedChannel channel;
	private final GreeterGrpc.GreeterBlockingStub blockingStub;
	private AtomicLong rowCount;
	private static PropertyTool pt =new PropertyTool();

	public TMP_GrpcClient(AtomicLong rowCount) {
		this.rowCount = rowCount;
		channel = ManagedChannelBuilder.forAddress(Constants.GREETER_SERVICE_IP, Constants.GREETER_SERVER_PORT)
				.usePlaintext(true).build();
		blockingStub = GreeterGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void greet(long i) {
		HelloRequest request = HelloRequest.newBuilder().build();
		try {
			blockingStub.sayHello(request);
			rowCount.addAndGet(1);
		} catch (StatusRuntimeException e) {
			System.out.println("RPC failed: {0}" + e.getStatus());
			return;
		}
	}

	public static void main(String[] args) {
		
		String THREAD_COUNT=pt.GetTargetValue("grpc.testing.client.thread.count");
		String BASE_COUNT=pt.GetTargetValue("grpc.testing.client.base.count");
		
		//start
		clientStart(Integer.parseInt(BASE_COUNT), Integer.parseInt(THREAD_COUNT));
//		clientStart(1000000, 1);
	}

	public static void clientStart(int exeCount, int threadCount) {
		System.out.println("Starting Client.........");
		test(exeCount, threadCount);
	}

	private static void test(final int exeCount, final int threadCount) {
		// String param = "grpc";

		final AtomicLong rowCount = new AtomicLong(0L);
		final long stime = System.currentTimeMillis();

		ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);

		for (int j = 0; j < threadCount; j++) {
			threadPool.execute(new Runnable() {
				public void run() {
					long i = 0;
					long max = exeCount;
					final TMP_GrpcClient client = new TMP_GrpcClient(rowCount);

					try {
						while (i++ < max) {
							client.greet(i);
							if (i % 2000 == 0) {
								long spendTime = System.currentTimeMillis() - stime;
								System.out.println("Count:" + i + ", TPS:" + (i * 1000 / spendTime));
							}
						}
					} finally {
						try {
							client.shutdown();
						} catch (Exception e) {
						}
					}
				}
			});

			System.out.println("thread-" + j + " started.");
		}

		while (rowCount.get() < exeCount * threadCount) {
			System.out.println("sum:" + rowCount.get() + ", speed:"
					+ (rowCount.get() * 1000 / (System.currentTimeMillis() - stime)));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long spendTime = System.currentTimeMillis() - stime;
		System.out.println("Count:" + rowCount.get() + ",Cotst_Time: " + spendTime + " ms, TPS:"
				+ (rowCount.get() * 1000 / spendTime));
	}
}
