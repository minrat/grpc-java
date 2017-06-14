/**
 * @Title: Deamon_ServerStart.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月21日 下午2:09:59
 * @version V1.0
 */

package com.test.framework.action.function;

import com.test.framework.service.register.single_impl.SP_Bye_RegisterImpl;
import com.test.framework.service.register.single_impl.SP_Dinner_RegisterImpl;
import com.test.framework.service.register.single_impl.SP_Drink_RegisterImpl;
import com.test.framework.service.register.single_impl.SP_Entertainment_RegisterImpl;
import com.test.framework.service.register.single_impl.SP_Greeter_RegisterImpl;
import com.test.framework.service.register.single_impl.SP_KTV_RegisterImpl;
import com.test.framework.service.register.single_impl.SP_Pay_RegisterImpl;
import com.test.framework.service.util.Constants;

/**
 * @author Test
 *
 */
public class Function_Deamon_ServerStart {
	//SP-greeter
	private static SP_Greeter_RegisterImpl sp_greeter;
	//SP-dinner
	private static SP_Dinner_RegisterImpl sp_dinner;
	//SP-drink
	private static SP_Drink_RegisterImpl sp_drink;
	//SP-ktv
	private static SP_KTV_RegisterImpl sp_ktv;
	//SP-entertainment
	private static SP_Entertainment_RegisterImpl sp_entertainment;
	//SP-pay
	private static SP_Pay_RegisterImpl sp_pay;
	//SP-bye
	private static SP_Bye_RegisterImpl sp_bye;
	
	public Function_Deamon_ServerStart()
	{
		initServer();
	}
	
	
	public void initServer()
	{
		sp_greeter = new SP_Greeter_RegisterImpl();
		sp_dinner = new SP_Dinner_RegisterImpl();
		sp_drink = new SP_Drink_RegisterImpl();
		sp_ktv = new SP_KTV_RegisterImpl();
		sp_entertainment = new SP_Entertainment_RegisterImpl();
		sp_pay = new SP_Pay_RegisterImpl();
		sp_bye = new SP_Bye_RegisterImpl();
		
		
		
		//greeter
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				sp_greeter.start(Constants.GREETER_SERVER_NAME, Constants.GREETER_SERVER_PORT);
			}
		}).start();;
		
		//dinner
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sp_dinner.start(Constants.DINNER_SERVER_NAME, Constants.DINNER_SERVER_PORT);
			}
		}).start();;
		
		//drink
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sp_drink.start(Constants.DRINK_SERVER_NAME, Constants.DRINK_SERVER_PORT);
			}
		}).start();;
		
		//ktv
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sp_ktv.start(Constants.KTV_SERVER_NAME, Constants.KTV_SERVER_PORT);
			}
		}).start();;
		
		//entertainment
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sp_entertainment.start(Constants.Entertainment_SERVER_NAME, Constants.Entertainment_SERVER_PORT);
			}
		}).start();;
		
		//pay
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sp_pay.start(Constants.PAY_SERVER_NAME, Constants.PAY_SERVER_PORT);
			}
		}).start();;
		
		//bye
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				sp_bye.start(Constants.BYE_SERVER_NAME, Constants.BYE_SERVER_PORT);
			}
		}).start();;
	}
	
	public static void main(String[] args) {
		Function_Deamon_ServerStart ds = new Function_Deamon_ServerStart();
	}

}
