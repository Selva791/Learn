package com.atlassian;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServiceRequestRateLimiterTest {

    @Test
    public void testSuccessRateLimit() throws InterruptedException {
       ServiceRequestRateLimiter rateLimiter = RateLimiterFactory.initialize(TimeUnit.SECONDS.toSeconds(5),5);
        ExecutorService service = Executors.newFixedThreadPool(7);
        for(int i=0;i<7;i++){
            rateLimiter.setupRequest(new RequestInfo("1", LocalDateTime.now()));
            Thread t=new Thread(rateLimiter);
            service.execute(t);
           Thread.sleep(100);
        }
        service.shutdown();

    }
}
