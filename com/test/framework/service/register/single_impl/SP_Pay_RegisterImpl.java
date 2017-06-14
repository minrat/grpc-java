/**
 * @Title: SP_Pay_RegisterImpl.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 上午11:27:08
 * @version V1.0
 */

package com.test.framework.service.register.single_impl;

import java.net.URLDecoder;

import com.test.framework.provider.SP_Bye;
import com.test.framework.provider.SP_Greeter;
import com.test.framework.provider.SP_Pay;
import com.test.framework.service.register.ServiceRegistry;
import com.test.framework.service.util.ZKTool;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author Test
 *
 */
public class SP_Pay_RegisterImpl implements ServiceRegistry{

	
	private ZKTool zk ;
	private SP_Pay sp_pay;
	private SP_Greeter sp_greet;
	private SP_Bye sp_bye;
	
	/* (non-Javadoc)
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegister(java.lang.String, int)
	 */
	public boolean flag=false;
	private Server server ;
	
	@Override
	public boolean start(String service, int port) {
		System.out.println("---------Pay Service is registering---------------------------");
		//time start
		long startTime=System.currentTimeMillis();
				
		sp_pay = new SP_Pay(service);
		
		try {
			 server = ServerBuilder.forPort(port)
					.addService(sp_pay).build().start();
			//time end
			long endTime=System.currentTimeMillis();
			//cal time
			float excTime=(float)(endTime-startTime)/1000;
			    
			System.out.println("Single [Pay] Service [Register] cost : "+excTime +"s");
			 
			flag = !server.isShutdown();
			
			DoRegisterVerify(service);
			
			Runtime.getRuntime().addShutdownHook(
					new Thread(){
						@Override
					     public void run()
						{
							server.shutdown();
						}
					}
					);
			
			server.awaitTermination();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	/*	mixed register
	 * 	00- hello
	 * 	01- pay
	 * 	02- goodbye
	 */
	public boolean MixedRegister(String service, int port) {
		
		sp_pay = new SP_Pay(service);
		sp_greet = new SP_Greeter(service);
		sp_bye = new SP_Bye (service);
		
		
		try {
			 server = ServerBuilder.forPort(port)
					 .addService(sp_greet)
					 .addService(sp_pay)
					 .addService(sp_bye)
					 .build().start();
			System.out.println("---------Mixed Pay Service(hello-pay-bye) is registering---------------------------");
			 
			flag = !server.isShutdown();
			
			DoRegisterVerify(service);
			
			Runtime.getRuntime().addShutdownHook(
					new Thread(){
						@Override
					     public void run()
						{
							server.shutdown();
						}
					}
					);
			
			server.awaitTermination();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	
	
	/* (non-Javadoc)
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegisterVerify(java.lang.String)
	 */
	@Override
	public boolean DoRegisterVerify(String service) {
		System.out.println("[SP_Pay] DoRegisterVerify  Start ---->>>>");
		String url ;

		//step-00:get the service url
		try {
			zk = new ZKTool();
			url = zk.getChild("/dubbo/com.bocloud.grpc.proto.helloworld.Pay/providers");
			url= URLDecoder.decode(url, "UTF-8").trim();
			
			System.out.println("[SP_Pay]--Current SP URL is :"+url+"\n Register Verify Step [PASS]");
			if (url!="")
			{
				flag=true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegisterClean(java.lang.String)
	 */
	@Override
	public boolean DoRegisterClean(String service) {
		// TODO Auto-generated method stub
		return false;
	}

}
