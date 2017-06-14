/**
 * @Title: KFKTool.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 下午2:39:55
 * @version V1.0
 */

package com.test.framework.service.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * @author Test
 *
 */
public class KFKTool {
	
//	private static Log log = LogFactory.getLog(KFKTool.class.getName());
	private ConsumerConnector connector ;
	private ConsumerConfig consumerConfig ;
	private Properties props;
	
	private SystemConfig sc ;
	//
	private static final int SESSION_TIME   = 1000000;   
	
	//group,default value is ""
	private String group_ID="sp_01";
	
	//zookeeper ip
	private String ip;
	
	//kafka topic
	private String topic ;
	
	//topic
    private Map<String,Integer> topics ;
    private Map<String, List<KafkaStream<byte[], byte[]>>> topicMessageStreams;
    private List<KafkaStream<byte[], byte[]>> streams ;
    private  ExecutorService threadPool ;
    
    private StringBuffer strbuffer;
	
	public KFKTool()
	{
		sc =  new SystemConfig();
		
		ip= sc.getProperties().getProperty("zookeeper.host.server");
		topic = sc.getProperties().getProperty("kafka.producer.app.topic");
		
		connect(ip,topic);
	}

	//connect kafka
	public void connect(String ips,String topicName)
	{
		// specify some consumer properties  
        props = new Properties();  
        props.put("zookeeper.connect",ips);  
        props.put("zookeeper.connectiontimeout.ms",SESSION_TIME);  
        props.put("group.id",group_ID);  
        props.put("auto.offset.reset", "smallest");
  
        // Create the connection to the cluster  
         consumerConfig = new ConsumerConfig(props);  
        
         connector = Consumer.createJavaConsumerConnector(consumerConfig);  
	}
	
	//Get the information from kafka
	public String GetFromTopic(String topic)
	{
		strbuffer = new StringBuffer();
	     //topic
        topics = new HashMap<String,Integer>();  
        
        // create 5 partitions of the stream for topic “test-topic”, to allow 5 threads to consume
        topics.put(topic, new Integer(5));  
        
        topicMessageStreams = this.connector.createMessageStreams(topics); 

        streams = topicMessageStreams.get(topic);
         
        //threads
        threadPool = Executors.newFixedThreadPool(1);  
        
        //consumer
        for (final KafkaStream<byte[], byte[]> stream : streams)
        {  
            threadPool.submit(new Runnable()
            {  
                public void run() 
                {  
                    ConsumerIterator<byte[], byte[]> it = stream.iterator();
                    while (it!=null)
                        System.out.println("topic: " + new String(it.next().topic()) + 
                                           "\t key:" + new String(it.next().key()) +
                                           "\t content:"  + new String(it.next().message()));
                    strbuffer.append("topic: " + new String(it.next().topic()) + 
                            "\t key:" + new String(it.next().key()) +
                            "\t content:"  + new String(it.next().message()));
                }  
            });  
        }    
		
		
		return strbuffer.toString();
	}
	
	
	public static void main(String[] args)
	{
		KFKTool kfk = new KFKTool();
		kfk.GetFromTopic("CRM-SDGP-DubboRPC-1.0");
	}
}
