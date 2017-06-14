/**
 * @Title: TestBedCheck.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月12日 上午11:39:44
 * @version V1.0
 */

package com.test.framework.service.status.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.framework.service.status.StatusCheck;
import com.test.framework.service.util.SystemConfig;


/**
 * @author Test
 *
 */
public class TestBedCheck implements StatusCheck {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	
	public String ZKHost()
	{
		Properties properties = SystemConfig.getProperties();
	    if (properties == null) {
	      this.logger.error("Cannot load properties:grpc-java-config.properties");
	      try 
	      {
			throw new Exception("Cannot load properties:grpc-java-config.properties");
	      } 
	      catch (Exception e) 
	      {
			e.printStackTrace();
	      }
	    }
	    if ((!properties.containsKey("zookeeper.host.server")) || 
	      (properties.getProperty("zookeeper.host.server").length() == 0))
	    {
	      this.logger.error("Cannot find key :zookeeper.host.server in htsc-grpc-java-config.properties");

	      try 
	      {
			throw new Exception("Cannot find key :zookeeper.host.server in htsc-grpc-java-config.properties");
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    String info = properties.getProperty("zookeeper.host.server");
		
		return info;
	}
	
	String host= ZKHost();
	boolean flag=false;
	/* (non-Javadoc)
	 * @see com.test.framework.service.status.StatusCheck#ZKStatus()
	 * 获取 zookeeper 集群信息
	 * 
	 */
	@Override
	public boolean ZKStatus() 
	{
		
		ZkClient zkClient = new ZkClient(host,10000,10000,new SerializableSerializer());
		
		if(zkClient.toString() != "")
		{
			flag = true;
			zkClient.close();
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.test.framework.service.status.StatusCheck#KFKStatus()
	 * 获取 kafka 集群状态
	 */
	@Override
	public boolean KFKStatus() 
	{
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.test.framework.service.status.StatusCheck#GetKFKBrokers()
	 * 获取 Kafka 地址信息
	 */
	@Override
	public List<?> GetKFKBrokers() {

		/*
		 * method_01
		 * 
		 */
		List<String> out = new ArrayList<String>();
		
		
		ZooKeeper zkr = null;
		try {
			zkr = new ZooKeeper(host, 10000, null);
		
		if(true)
		{
			flag = true;
	        List<String> ids = zkr.getChildren("/brokers/ids", false);
				for (String id : ids) 
		        {  
					
					
					String  brokerInfo = new String (zkr.getData("/brokers/ids/" + id, false, null),"UTF-8"); 
		            
					//method-01:  character append
					String ip = "";
					String port = "";
					String data="";
					String[] sss = brokerInfo.split(",");
					for(String b:sss)
					{
						if(b.startsWith("\"host"))
						{
							ip=b.split("\"")[3];
						}
						
						else if(b.startsWith("\"port"))
						{
							port=b.split("\"")[2];
						}
						data=ip+port;
					}
					if(data.trim().length()>14)
					{
						out.add(data);
					}
					
					
//					//String - whole
//					System.out.println(id + ": " + brokerInfo); 
//		            out.add(brokerInfo.toString());
					
					//method-02:  substring 
//					String b =brokerInfo.substring(86, 103);
//					out.add(b);
					
					//method-03: read from config file
		        }  
				zkr.close();
		}
			}catch (Exception e1) {
				e1.printStackTrace();
			}  
	        
		return out;
	}

	/* (non-Javadoc)
	 * @see com.test.framework.service.status.StatusCheck#GetServiceProvider()
	 */
	@Override
	public List<?> GetServiceProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.test.framework.service.status.StatusCheck#GetServiceComsumer()
	 */
	@Override
	public List<?> GetServiceComsumer() {
		// TODO Auto-generated method stub
		return null;
	}

}
