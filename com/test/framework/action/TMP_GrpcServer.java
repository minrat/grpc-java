package com.test.framework.action;

import com.test.framework.service.register.single_impl.SP_Greeter_RegisterImpl;
import com.test.framework.service.util.Constants;

public class TMP_GrpcServer {
	public TMP_GrpcServer() {
		serverStart();
	}

	public static void serverStart() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Server is starting...");
				new SP_Greeter_RegisterImpl().start(Constants.GREETER_SERVER_NAME, Constants.GREETER_SERVER_PORT);
			}
		}).start();

	}

	public static void main(String[] args) {
		serverStart();
	}

}
