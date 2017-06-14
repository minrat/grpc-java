/**
 * @Title: RPC_Client.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年4月26日 下午5:43:23
 * @version V1.0
 */

package com.test.framework.action.performance.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author Test
 *
 */
public class RPC_Client {
	private static final Logger logger = Logger.getLogger(RPC_Client.class.getName());
	

    public RPC_Client(String host, int port) {
    	
    }

    public void shutdown() throws InterruptedException {
    }


    public static void syncTest(RPC_Client client, String user) {
        long t = System.nanoTime();
        for (int i = 0; i < 10000; i++) 
        {
        	//add action
        	
        }
        System.out.println("took: " + (System.nanoTime() - t) / 1000000 + " ms");
    }

    
    //asyn 
    public static void asyncTest(RPC_Client[] client, String user) {
        ExecutorService pool = 
        		Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        final CountDownLatch latch = new CountDownLatch(10000);
        long t = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            final int j = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                	//add action
                    
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("took: " + (System.nanoTime() - t) / 1000000 + " ms");
        pool.shutdownNow();
    }
    
    //modify
    public void Htsc()
    {
    	
    }
    
    //pre
    public void Origin()
    {
    	
    }
    
    

    public static void main(String[] args) throws Exception {
    	RPC_Client[] client = new RPC_Client[20];
        try {
            String user = "world";

            int i = 0;
            for (i = 0; i < 100; i++) {
                client[i] = new RPC_Client("localhost", 50051);
                //add action
            }

            boolean sync = true;
            if (args.length > 0) {
                sync = Boolean.parseBoolean(args[0]);
            }

            if (sync) 
            { 
            	syncTest(client[0], user); 
            }
            else 
            { 
            	asyncTest(client, user); 
            }
        }
        finally {

            for (int i = 0; i < 20; i++) {
                client[i].shutdown();
            }

        }
    }
}