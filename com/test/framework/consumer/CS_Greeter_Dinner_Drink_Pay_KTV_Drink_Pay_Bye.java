/**
 * @Title: CS_Greeter_Dinner_Drink_Pay_KTV_Drink_Pay_Bye.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月17日 下午2:40:02
 * @version V1.0
 */

package com.test.framework.consumer;


/**
 * @author Test
 *
 */
public class CS_Greeter_Dinner_Drink_Pay_KTV_Drink_Pay_Bye 
{
	
	//consumer
	private static CS_Greeter cs_greeter;
	private static CS_Dinner cs_dinner;
	private static CS_Drink cs_drink;
	private static CS_KTV cs_ktv;
	private static CS_Entertainment cs_entertainment;
	private static CS_Pay cs_pay;
	private static CS_Bye cs_bye;
	
	
	public CS_Greeter_Dinner_Drink_Pay_KTV_Drink_Pay_Bye()
	{
		try {
			Mixed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void Mixed() throws Exception
	{
		
		cs_greeter = new CS_Greeter();
		
		cs_dinner = new CS_Dinner();
		
		cs_drink = new CS_Drink();
		
		cs_ktv = new CS_KTV();
		
		cs_entertainment = new CS_Entertainment();
		
		cs_pay = new CS_Pay();
		
		cs_bye = new CS_Bye();
		
	}
	
	public static void Story_01() throws Exception
	{
		CS_Greeter_Dinner_Drink_Pay_KTV_Drink_Pay_Bye cs = new CS_Greeter_Dinner_Drink_Pay_KTV_Drink_Pay_Bye();
		for (int i=0;i<100;i++)
		{
			System.out.println("Long Long Ag0,........");
			Thread.sleep(2000L);
			cs_greeter.callHello();
			
			Thread.sleep(500L);
			cs_dinner.haveDinner();
			
			Thread.sleep(500L);
			cs_drink.haveDrink();
			
			Thread.sleep(500L);
			cs_ktv.goKTV();
			
			Thread.sleep(500L);
			cs_entertainment.PlayGame();
			
			Thread.sleep(500L);
			cs_pay.callPayBill();
			
			Thread.sleep(500L);
			cs_bye.callGoodBye();
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
	
		Story_01();
	
	}

	
	
}
