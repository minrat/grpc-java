/**
 * @Title: CS_Greeter_Dinner_Drink_KTV_Pay_Bye.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午2:39:21
 * @version V1.0
 */

package com.test.framework.consumer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minrat.grpc.proto.helloworld.ByeReply;
import com.minrat.grpc.proto.helloworld.ByeRequest;
import com.minrat.grpc.proto.helloworld.DinnerGrpc;
import com.minrat.grpc.proto.helloworld.DinnerReply;
import com.minrat.grpc.proto.helloworld.DinnerRequest;
import com.minrat.grpc.proto.helloworld.DrinkGrpc;
import com.minrat.grpc.proto.helloworld.DrinkReply;
import com.minrat.grpc.proto.helloworld.DrinkRequest;
import com.minrat.grpc.proto.helloworld.GoodByeGrpc;
import com.minrat.grpc.proto.helloworld.GreeterGrpc;
import com.minrat.grpc.proto.helloworld.HelloReply;
import com.minrat.grpc.proto.helloworld.HelloRequest;
import com.minrat.grpc.proto.helloworld.KTVGrpc;
import com.minrat.grpc.proto.helloworld.KTVReply;
import com.minrat.grpc.proto.helloworld.KTVRequest;
import com.minrat.grpc.proto.helloworld.PayGrpc;
import com.minrat.grpc.proto.helloworld.PayReply;
import com.minrat.grpc.proto.helloworld.PayRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Test
 *
 */
public class CS_Greeter_Dinner_Drink_KTV_Pay_Bye 
{
	private static final Logger logger = LoggerFactory.getLogger(CS_Greeter_Dinner_Drink_KTV_Pay_Bye.class.getName());
	  private  ManagedChannel channel = null;

	  //greeter
	  public  void callHello() throws InterruptedException {
			 
		    try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Greeter")
		          .usePlaintext(true).build();
		      GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);
		      HelloRequest request = HelloRequest.newBuilder().setName("CS_Greeter").build();
		      while (true) {
		        HelloReply response = blockingStub.sayHello(request);
		        logger.info(response.getMessage());
		        Thread.sleep(20000L);
		      }
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  //dinner
	  public  void haveDinner() throws InterruptedException {
		    try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Dinner")
		          .usePlaintext(true).build();
		      DinnerGrpc.DinnerBlockingStub blockingStub = DinnerGrpc.newBlockingStub(channel);
		      DinnerRequest request = DinnerRequest.newBuilder().setName("CS_Dinner").build();
		      while (true) {
		        DinnerReply response = blockingStub.haveDinner(request);
		        logger.info(response.getMessage());
		        Thread.sleep(20000L);
		      }
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  
	  //drink
	  public  void haveDrink() throws InterruptedException {
		    try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Drink")
		          .usePlaintext(true).build();
		      DrinkGrpc.DrinkBlockingStub blockingStub = DrinkGrpc.newBlockingStub(channel);
		      DrinkRequest request = DrinkRequest.newBuilder().setName("CS_Drink").build();
		      while (true) {
		    	  DrinkReply response = blockingStub.haveDrink(request);
		        logger.info(response.getMessage());
		        Thread.sleep(20000L);
		      }
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  //ktv
	  public  void goKTV() throws InterruptedException {
			 
		    try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.KTV")
		          .usePlaintext(true).build();
		      KTVGrpc.KTVBlockingStub blockingStub = KTVGrpc.newBlockingStub(channel);
		      KTVRequest request = KTVRequest.newBuilder().setName("CS_KTV").build();
		      while (true) {
		        KTVReply response = blockingStub.goKTV(request);
		        logger.info(response.getMessage());
		        Thread.sleep(20000L);
		      }
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  //pay
	  public  void callPayBill() throws InterruptedException {
		    try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.Pay")
		          .usePlaintext(true).build();
		      PayGrpc.PayBlockingStub blockingStub = PayGrpc.newBlockingStub(channel);
		      PayRequest request = PayRequest.newBuilder().setName("Simple_Pay_Testing").build();
		      while (true) {
		      
		      PayReply response = blockingStub.consumerPay(request);
		      System.out.println(response.getMessage());
		      logger.info(response.getMessage());
		      Thread.sleep(20000L);
		      System.out.println("Pay Action Done!");
		      }
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  //bye
	  public  void callGoodBye() throws InterruptedException {
		    try {
		      channel = ManagedChannelBuilder.forTarget("zookeeper:///com.bocloud.grpc.proto.helloworld.GoodBye")
		          .usePlaintext(true).build();
		      GoodByeGrpc.GoodByeBlockingStub blockingStub = GoodByeGrpc.newBlockingStub(channel);
		      ByeRequest request = ByeRequest.newBuilder().setName("Simple_Bye_Testing").build();
		      while (true) {
		      
		      ByeReply response = blockingStub.sayBye(request);
		      System.out.println(response.getMessage());
		      logger.info(response.getMessage());
		      Thread.sleep(20000L);
		      }
		    } finally {
		      if (channel != null) {
		        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		      }
		    }
		  }
	  
	  
	  public void CS_Greeter_Dinner_Drink_KTV_Pay_Bye() throws Exception
	  {
		//00 hello
		  new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(1);
						callHello();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();;
			
			TimeUnit.SECONDS.sleep(2);
			
			//01 dinner
			  new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							TimeUnit.SECONDS.sleep(1);
							haveDinner();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();;
				
				TimeUnit.SECONDS.sleep(2);
			
				//02 drink
				  new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								TimeUnit.SECONDS.sleep(1);
								haveDrink();;
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}).start();;
					
					TimeUnit.SECONDS.sleep(2);			
					//03 ktv
					  new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									TimeUnit.SECONDS.sleep(1);
									goKTV();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}).start();;
						
						TimeUnit.SECONDS.sleep(2);
					
		  //04 pay
		  new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(2);
						callPayBill();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();;
			
			TimeUnit.SECONDS.sleep(2);
			
		  //05 bye
		  new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(3);
						callGoodBye();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();;
	  }
	  
}
