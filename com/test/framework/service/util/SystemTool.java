/**
 * @Title: SystemTool.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月21日 上午10:05:22
 * @version V1.0
 */

package com.test.framework.service.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Test
 *
 */
public class SystemTool {
	
	private final static InetAddress netAddress = getInetAddress(); 
	
	public static void main(String [] args){  
         
		System.out.println(ServerFlag());
        }  
  
	//union server name
	public static String ServerFlag()
	{
		String out = getHostName(netAddress)+"-"+getHostIp(netAddress);
		return out;
	}
	
    public static InetAddress getInetAddress(){  
  
        try{  
            return InetAddress.getLocalHost();  
        }catch(UnknownHostException e){  
            System.out.println("unknown host!");  
        }  
        return null;  
    }  
  
    //get the ip address
    public static String getHostIp(InetAddress netAddress){  
        if(null == netAddress){  
            return null;  
        }  
        String ip = netAddress.getHostAddress();   
        return ip;  
    }  
  
    //get the host address 
    public static String getHostName(InetAddress netAddress){  
        if(null == netAddress){  
            return null;  
        }  
        String name = netAddress.getHostName();  
        return name;  
    }  
    
    //execute the linux method
    public String Execute_Linux(String cmd) throws Exception
    {
    	StringBuffer sb = new StringBuffer();
    	
    	String[] cmds = {"/bin/bash","-c",cmd};
//    	String[] cmds = {cmd};
		Process pro = Runtime.getRuntime().exec(cmds);
		pro.waitFor();
		InputStream in = pro.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while((line = read.readLine())!=null){
			sb.append(line);
		}
    	return sb.toString();
    }
    
    /*	get cpu usage
     * 
     */
    public String CPU_Usage() throws Exception
    {
    	
    	String cmd="cat /proc/loadavg | awk '{print $1,$2,$3}'";
    	
    	return Execute_Linux(cmd);
    }
    
    /*	get memory usage
     * 
     */
    public String Mem_Usage() throws Exception
    {
    	String cmd="cat /proc/meminfo| grep MemFree| awk {'print $2/1024\" M\"'}";
    	
    	return Execute_Linux(cmd);
    }
    
    
    /*	get port connections
     * 	netstat -nat|grep -i "80"|wc -l
     * 
     * */
    public String Port_Connection(int port) throws Exception
    {
    	String cmd="netstat -nat|grep -i \""+port+"\"|wc -l";
    	
    	return Execute_Linux(cmd);
    }
    
    
    /*	get http connections
     * 	ps -ef|grep httpd|wc -l
     * 
     * */
    public String HTTP_Connection() throws Exception
    {
    	String cmd="ps -ef|grep httpd|wc -l";
    	
    	return Execute_Linux(cmd);
    }
  
    
    /*
     * 	real time check 
     * 	watch -n 1 -d "pgrep httpd|wc -l"
     * 
     * */
    
    public String RealTime_HTTP_Connection() throws Exception
    {
    	String cmd="watch -n 1 -d \"pgrep httpd|wc -l\"";
    	
    	return Execute_Linux(cmd);
    }}  

