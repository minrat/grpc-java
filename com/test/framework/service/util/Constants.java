/**
 * @Title: Constants.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月13日 下午5:28:19
 * @version V1.0
 */

package com.test.framework.service.util;

/**
 * @author Test
 *
 */
public class Constants 
{
	
	//property file
	public static final String PROPERTY_FILE="grpc-java-config.properties";
	
	//channel account
	public static final int CONSUMER_SCOPE =100;
	
	//concurrent account
	public static final int CONCURRENT_THREAD =1000;
 	
	//system flag
	private final static String flag = SystemTool.ServerFlag();
	
	public static final int GREETER_SERVER_PORT_SINGLE = 50900;
	public static final int BYE_SERVER_PORT_SINGLE = 50901;
	
	//service name
	public static final String GREETER_SERVER_NAME="SP_Greeter-"+flag;
	public static final String DINNER_SERVER_NAME="SP_Dinner-"+flag;
	public static final String DRINK_SERVER_NAME="SP_Drink-"+flag;
	public static final String KTV_SERVER_NAME="SP_KTV-"+flag;
	public static final String Entertainment_SERVER_NAME="SP_Entertainment-"+flag;
	public static final String PAY_SERVER_NAME="SP_Pay-"+flag;
	public static final String BYE_SERVER_NAME="SP_Bye-"+flag;
	
	//service port
	public static final int GREETER_SERVER_PORT = 50101;
	public static final int DINNER_SERVER_PORT = 50201;
	public static final int DRINK_SERVER_PORT = 50301;
	public static final int KTV_SERVER_PORT = 50401;
	public static final int Entertainment_SERVER_PORT = 50501;
	public static final int PAY_SERVER_PORT = 50601;
	public static final int BYE_SERVER_PORT = 50701;
	
//	private static final String COMMON="168.61.2.8";
//	private static final String COMMON="192.168.207.71";
	
//	private static final String COMMON="168.168.207.6";
	
//	private static final String COMMON="168.61.2.52";
	private static final String COMMON=PropertyTool.GetTargetValue("grpc.testing.server.ip");
	
	
	//service ip
	public static final String GREETER_SERVICE_IP=COMMON;
	public static final String DINNER_SERVICE_IP=COMMON;
	public static final String DRINK_SERVICE_IP=COMMON;
	public static final String ENTERTAINMENT_SERVICE_IP=COMMON;
//	public static final String ENTERTAINMENT_SERVICE_IP="127.0.0.1";
	public static final String KTV_SERVICE_IP=COMMON;
	public static final String PAY_SERVICE_IP=COMMON;
	public static final String BYE_SERVICE_IP=COMMON;
	
}
