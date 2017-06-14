/**
 * @Title: SP_Bye_RegisterImpl.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 下午5:42:39
 * @version V1.0
 */

package com.test.framework.service.register.single_impl;

import java.net.URLDecoder;

import com.test.framework.provider.SP_Bye;
import com.test.framework.provider.SP_Greeter;
import com.test.framework.service.register.ServiceRegistry;
import com.test.framework.service.util.ZKTool;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author Test
 *
 */
public class SP_Bye_RegisterImpl implements ServiceRegistry {
	
	private ZKTool zk ;

	/* (non-Javadoc)
	 * @see com.test.framework.service.register.ServiceRegistry#DoRegister(java.lang.String, int)
	 */
	public boolean flag=false;
	private Server server ;
	private SP_Bye sp_bye ;
	private SP_Greeter sp_greet ;
	
	@Override
	public boolean start(String service, int port) {
		// TODO Auto-generated method stub
		System.out.println("-----------Bye Service is registering---------------------------");
		
		long startTime=System.currentTimeMillis();
	       //执行方法
		
		sp_bye = new SP_Bye(service);
		
		try {
			 server = ServerBuilder.forPort(port)
					.addService(sp_bye).build().start();
			
			
			long endTime=System.currentTimeMillis();
		    float excTime=(float)(endTime-startTime)/1000;
		    
		    System.out.println("Single [Bye] Service [Register] cost : "+excTime +"s");
			
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

	//Mixed Service (hello bye)
	public boolean MixedRegister(String service, int port) {
		// TODO Auto-generated method stub
		sp_bye = new SP_Bye(service);
		sp_greet =  new SP_Greeter(service);
		
		try {
			 server = ServerBuilder.forPort(port)
					 .addService(sp_greet)
					.addService(sp_bye)
					.build().start();
			System.out.println("---------Mixed Bye Service(Greet && Bye) is registering---------------------------");
			
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
	public boolean DoRegisterVerify(String service) 
	{
		
		System.out.println("[SP_Bye] DoRegisterVerify  Start ---->>>>");
		String url ;

		//step-00:get the service url
		try {
			zk = new ZKTool();
			url = zk.getChild("/dubbo/com.bocloud.grpc.proto.helloworld.GoodBye/providers");
			url= URLDecoder.decode(url, "UTF-8").trim();
			
			System.out.println("[SP_Bye]--Current SP URL is :"+url+"\n Register Verify Step [PASS]");
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
