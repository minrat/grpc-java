/**
 * @Title: ZKTool.java
 * @Description: TODO
 * @author Test
 * @date 2017年4月14日 下午2:13:19
 * @version V1.0
 */

package com.test.framework.service.util;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;



/**
 * @author Test
 *
 */
public class ZKTool implements Watcher {
	private static Log log = LogFactory.getLog(ZKTool.class.getName());

	//缓存时间
	 private static final int SESSION_TIME   = 2000;   
	 protected ZooKeeper zooKeeper;
	 protected CountDownLatch countDownLatch=new CountDownLatch(1);
	 
	 protected SystemConfig sc =null;
	 
	 protected StringBuffer br = new StringBuffer();

	 
	 public ZKTool() throws IOException, InterruptedException
	 {
		 	sc =  new SystemConfig();
			String ip = sc.getProperties().getProperty("zookeeper.host.server");
			
			connect(ip);
	 }
	 
	 
	 public void connect(String hosts) throws IOException, InterruptedException{   
	        zooKeeper = new ZooKeeper(hosts,SESSION_TIME,this);   
	        countDownLatch.await();   
		 
	 }

	 
	/* (non-Javadoc)
	 * @see org.apache.zookeeper.Watcher#process(org.apache.zookeeper.WatchedEvent)
	 */
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		if(event.getState()==KeeperState.SyncConnected){
			countDownLatch.countDown();
		}
	}
	
	//zookeeper close 
	public void close() throws InterruptedException{   
        zooKeeper.close();   
    }  

	
	/**
	 *	获取节点信息
	 */
	public String getChild(String path) throws KeeperException, InterruptedException{   
		try{
			List<String> list=this.zooKeeper.getChildren(path, false);
			if(list.isEmpty()){
				log.debug(path+"中没有节点");
			}else{
				log.debug(path+"中存在节点");
				for(String child:list){
					log.debug("节点为："+child);
					br.append(child);
				}
			}
		}catch (KeeperException.NoNodeException e) {
			// TODO: handle exception
			 throw e;   

		}
		return br.toString();
	}
	
	
	/*
	 * 增加数据内容操作
	 * 
	 * */
	public boolean AddNode(String path,String data)throws KeeperException, InterruptedException{
		
		this.zooKeeper.create(path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		
		return false;
	}
	
	
	
	/*
	 *	删除操作
	 *	TODO 
	 */
	public void delet(String path,int version) throws InterruptedException, KeeperException{  
        this.zooKeeper.delete(path, version);  
    }  
      
	
	public boolean DeleteData(String path,byte[] data) throws InterruptedException, KeeperException
	{
		boolean flag ;
//		flag = this.zooKeeper.exists(path, null);
		this.zooKeeper.delete(path, 0);
		return false;
	}
	
	
	/*
	 * 数据设置，更新
	 * */
	public Stat setData(String path,String data,int version) throws KeeperException, InterruptedException{  
        return this.zooKeeper.setData(path, data.getBytes(), version);  
    }  
	
	/*
	 * 数据读取
	 * */
	public byte[] getData(String path) throws KeeperException, InterruptedException{  
        return this.zooKeeper.getData(path, false, null);  
    }  
	
	
	public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
		
//		ZKTool az = new ZKTool("192.168.1.67");
		ZKTool az = new ZKTool();
				Stat out = az.zooKeeper.exists("/config", false);
				System.out.println(out);
				
	}
}
