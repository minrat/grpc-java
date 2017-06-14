/**
 * @Title: SP_KTV_ServiceImpl.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 上午11:25:43
 * @version V1.0
 */

package com.test.framework.service.register.single_impl;

import java.net.URLDecoder;

import com.test.framework.provider.SP_Bye;
import com.test.framework.provider.SP_Dinner;
import com.test.framework.provider.SP_Greeter;
import com.test.framework.provider.SP_Pay;
import com.test.framework.service.register.ServiceRegistry;
import com.test.framework.service.util.ZKTool;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author Test
 *
 */
public class SP_Dinner_RegisterImpl implements ServiceRegistry{

	ManagedChannel mchannel =null;
	
	/* (non-Javadoc)
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegister(java.lang.String, int)
	 *
	 *	01 Dinner
	 */
	public boolean flag=false;
	private Server server ;
	
	private ZKTool zk ;
	private SP_Greeter sp_greeter ;
	private SP_Dinner sp_dinner ;
	private SP_Pay sp_pay ;
	private SP_Bye sp_bye;
	
	@Override
	public boolean start(String service, int port) {
		System.out.println("---------Dinner Service is registering---------------------------");
		long startTime=System.currentTimeMillis();
	       //执行方法
		 sp_dinner = new SP_Dinner(service);
		
		try {
			 server = ServerBuilder.forPort(port)
					.addService(sp_dinner).build().start();
			 
			 
			 long endTime=System.currentTimeMillis();
			 float excTime=(float)(endTime-startTime)/1000;
			    
			 System.out.println("Single [Dinner] Service [Register] cost : "+excTime +"s");
			 
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
		return false;
	}

	/*
	 * 00- Greeter
	 * 01- Dinner
	 * 
	 */
	public boolean Greeter_Dinner(String service, int port) {
		sp_greeter = new SP_Greeter(service);
		 sp_dinner = new SP_Dinner(service);
		 
		try {
			 server = ServerBuilder.forPort(port)
					.addService(sp_greeter)
					.addService(sp_dinner)
					.build().start();
			 
			 System.out.println("---------Greeter && Dinner Service is registering---------------------------");
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
		return false;
	}
	
	/*
	 * 00- Greeter
	 * 01- Dinner
	 * 02- Bye
	 * 
	 */
	public boolean Greeter_Dinner_Bye(String service, int port) {
		sp_greeter =  new SP_Greeter(service);
		sp_dinner = new SP_Dinner(service);
		sp_bye = new SP_Bye(service);
		 
		
		try {
			 server = ServerBuilder.forPort(port)
					.addService(sp_greeter)
					.addService(sp_dinner)
					.addService(sp_bye)
					.build().start();
			 System.out.println("---------Greeter && Dinner && Bye Service is registering---------------------------");
			 
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
		return false;
	}
	
	
	/*
	 * 00- Greeter
	 * 01- Dinner
	 * 02- Pay
	 * 03- Bye
	 * 
	 */
	public boolean Greeter_Dinner_Pay_Bye(String service, int port) {
		sp_greeter =  new SP_Greeter(service);
		 sp_dinner = new SP_Dinner(service);
		 sp_pay = new SP_Pay(service);
		 sp_bye = new SP_Bye(service);
		 
		
		try {
			 server = ServerBuilder.forPort(port)
					 .addService(sp_greeter)
						.addService(sp_dinner)
						.addService(sp_pay)
						.addService(sp_bye)
					.build().start();
			
			 System.out.println("---------Greeter && Dinner && Pay && Bye Service is registering---------------------------");
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
		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegisterVerify(java.lang.String)
	 */
	@Override
	public boolean DoRegisterVerify(String service) {
		System.out.println("[SP_Dinner] DoRegisterVerify  Start ---->>>>");
		String url ;

		//step-00:get the service url
		try {
			zk = new ZKTool();
			url = zk.getChild("/dubbo/com.bocloud.grpc.proto.helloworld.Dinner/providers");
			url= URLDecoder.decode(url, "UTF-8").trim();
			
			System.out.println("[SP_Dinner]--Current SP URL is :"+url+"\n Register Verify Step [PASS]");
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
