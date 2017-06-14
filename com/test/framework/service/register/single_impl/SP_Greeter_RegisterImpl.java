/**
 * @Title: ServiceRegisterImpl.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午11:37:52
 * @version V1.0
 */

package com.test.framework.service.register.single_impl;

import java.net.URLDecoder;

import com.test.framework.provider.SP_Greeter;
import com.test.framework.service.register.ServiceRegistry;
import com.test.framework.service.util.ZKTool;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author Test
 *
 */
public class SP_Greeter_RegisterImpl implements ServiceRegistry {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegister()
	 * 
	 * 服务注册发起
	 * 
	 */
	public boolean flag = false;
	private Server server;
	private ZKTool zk;
	private SP_Greeter sp_greeter;

	@Override
	public boolean start(String service, int port) {
		System.out.println("---------Greeter Service is registering---------------------------");
		long startTime = System.currentTimeMillis();
		// 执行方法
		// step-01: define SP
		sp_greeter = new SP_Greeter(service);

		// step-02: define server --> load service
		try {
			server = ServerBuilder.forPort(port).addService(sp_greeter).build().start();
			long endTime = System.currentTimeMillis();
			float excTime = (float) (endTime - startTime) / 1000;

			System.out.println("Single [Greeter] Service [Register] cost : " + excTime + "s");

			flag = !server.isShutdown();

//			DoRegisterVerify(service);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					server.shutdown();
				}
			});

			if (server != null) {
				server.awaitTermination();
			}
			// server.awaitTermination();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegisterVerify()
	 * 
	 * zk 查询是否存在该SP
	 * 
	 */
	@Override
	public boolean DoRegisterVerify(String service) {
		System.out.println("[SP_Greeter] DoRegisterVerify  Start ---->>>>");
		String url;

		// step-00:get the service url
		try {
			zk = new ZKTool();
			url = zk.getChild("/dubbo/com.bocloud.grpc.proto.helloworld.Greeter/providers");
			url = URLDecoder.decode(url, "UTF-8").trim();

			System.out.println("[SP_Greeter] Current SP URL is :" + url + "\n Register Verify Step [PASS]");
			if (url != "") {
				flag = true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegisterClean()
	 */
	@Override
	public boolean DoRegisterClean(String service) {

		server.shutdownNow();
		flag = server.isShutdown();
		return false;
	}

}
