/**
 * @Title: KTVRegisterImpl.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 上午9:42:57
 * @version V1.0
 */

package com.test.framework.service.register.single_impl;

import java.net.URLDecoder;

import com.test.framework.provider.SP_Bye;
import com.test.framework.provider.SP_Dinner;
import com.test.framework.provider.SP_Drink;
import com.test.framework.provider.SP_Greeter;
import com.test.framework.provider.SP_KTV;
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
public class SP_KTV_RegisterImpl implements ServiceRegistry {
	
	ManagedChannel mchannel =null;
	private ZKTool zk ;
	public boolean flag=false;
	private Server server ;
	
	private SP_Greeter sp_greeter ;
	private SP_Dinner sp_dinner ;
	private SP_Drink sp_drink;
	private SP_KTV sp_ktv;
	private SP_Pay sp_pay ;
	private SP_Bye sp_bye;
	
	
	
	/* (non-Javadoc)
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegister(java.lang.String, int)
	 */
	@Override
	public boolean start(String service, int port) 
	{
		System.out.println("---------KTV Service is registering---------------------------");
		
		//time start
		long startTime=System.currentTimeMillis();
		
		sp_ktv = new SP_KTV(service);
		
		try {
			 server = ServerBuilder.forPort(port)
					.addService(sp_ktv).build().start();
			
			
			//time end
			long endTime=System.currentTimeMillis();
		    //cal time
			float excTime=(float)(endTime-startTime)/1000;
		    
			System.out.println("Single [KTV] Service [Register] cost : "+excTime +"s");
			
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

	public boolean Greeyet_Dinner_Drink_KTV_Pay_Bye(String service, int port) 
	{
		//time start
		long startTime=System.currentTimeMillis();
		
		 sp_greeter =  new SP_Greeter(service);
		 sp_dinner = new SP_Dinner(service);
		 sp_drink = new SP_Drink(service);
		 sp_ktv = new SP_KTV(service);
		 sp_pay = new SP_Pay(service);
		 sp_bye = new SP_Bye(service);
		
		
		try {
			 server = ServerBuilder.forPort(port)
					 .addService(sp_greeter)
					 .addService(sp_dinner)
					 .addService(sp_drink)
					.addService(sp_ktv)
					.addService(sp_pay)
					.addService(sp_bye)
					.build().start();
			System.out.println("---------Greeter & Dinner & Drink & KTV & Pay & Bye Service is registering---------------------------");
			
			//time end
			long endTime=System.currentTimeMillis();
		    //cal time
			float excTime=(float)(endTime-startTime)/1000;
		    
			System.out.println("[Greeter & Dinner & Drink & KTV & Pay & Bye ] Register Action : "+excTime +" s");
			
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
		System.out.println("[SP_KTV] DoRegisterVerify  Start ---->>>>");
		String url ;

		//step-00:get the service url
		try {
			zk = new ZKTool();
			url = zk.getChild("/dubbo/com.bocloud.grpc.proto.helloworld.KTV/providers");
			url= URLDecoder.decode(url, "UTF-8").trim();
			
			System.out.println("[SP_KTV]--Current SP URL is :"+url+"\n Register Verify Step [PASS]");
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
