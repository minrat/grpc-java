/**
 * @Title: Jmeter.java
 * @Description: TODO
 * Copyright: Copyright (c) Minrat 2016 * 
 * @author Test
 * @date 2017年5月1日 上午12:57:58
 * @version V1.0
 */

package com.test.framework.action.performance.jmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.framework.action.performance.time.Java_P_CS_Entertainment_Sync_1000;

/**
 * @author Test
 *
 */
public class Java_Jmeter_Default extends AbstractJavaSamplerClient {
	
	private Logger logger=LoggerFactory.getLogger(Java_Jmeter_Default.class);
	
	SampleResult sr =null;
	private String resultData;
	private Java_P_CS_Entertainment_Sync_1000 greeter;

	public Java_Jmeter_Default()
	{
		sr = new SampleResult();
		sr.setDataEncoding("UTF-8");
	}
	
	 //每个线程测试前执行一次，做一些初始化工作；
	@Override
    public void setupTest(JavaSamplerContext arg0) {
		
		logger.info("Test Start");
		
    }
	
	@Override
	public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("ip", "");
        params.addArgument("port", "");
        return params;
    }
	/* (non-Javadoc)
	 * @see org.apache.jmeter.protocol.java.sampler.JavaSamplerClient#runTest(org.apache.jmeter.protocol.java.sampler.JavaSamplerContext)
	 */
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
        
        sr.setSampleLabel( "Java请求");
        try {
        	// jmeter start
            sr.sampleStart();
            
            greeter = new Java_P_CS_Entertainment_Sync_1000();
            String out = greeter.story_00();
            
            resultData = String.valueOf(out);
            if (resultData != null && resultData.length() > 0) 
            {
            	sr.setResponseMessage(resultData);
                sr.setResponseData(resultData, "UTF-8");
                sr.setDataType(SampleResult.TEXT);
            }
            
            logger.info("Consumer Time is: "+resultData);
            
            sr.setSuccessful(true);

        } catch (Throwable e) {
            sr.setSuccessful(false);
            e.printStackTrace();
        } finally {
        	
            sr.sampleEnd();
        }
        
        return sr;
	}
	
	@Override
    public void teardownTest(JavaSamplerContext arg0){
		logger.info("Test End");
    }
	
	
	public static void main(String[] args) {
		
		Java_Jmeter_Default j = new Java_Jmeter_Default();
		
		Arguments params = new Arguments();
        params.addArgument("ip", "");
        params.addArgument("port", "");
        
        JavaSamplerContext js =new JavaSamplerContext(params);
		j.runTest(js);
		
	}

}
