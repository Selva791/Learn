package com.atlassian;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServiceRequestRateLimiter implements RateLimiter,Runnable{
    private long time;
    Map<String, LocalDateTime> count;
    Map<String,Integer> requestCount;
    int maxCOunt;
    RequestInfo requestInfo;
    public ServiceRequestRateLimiter(long time,int maxCOunt){
        this.time = time;
        count = new HashMap<>();
        requestCount = new HashMap<>();
        this.maxCOunt=maxCOunt;
    }

    public void setupRequest(RequestInfo requestInfo){
        this.requestInfo=requestInfo;
    }
    @Override
    public synchronized boolean calculate(RequestInfo requestInfo) {
        if(count.containsKey(requestInfo.getId())){
            int values= requestCount.get(requestInfo.getId())+1;
            LocalDateTime localDateTime = count.get(requestInfo.getId());
            Duration duration = Duration.between(requestInfo.getStartTime(),localDateTime);
            if(duration.getSeconds()>time){
                count.put(requestInfo.getId(),requestInfo.getStartTime());
                requestCount.put(requestInfo.getId(),1);
                return true;
            }else if(duration.getSeconds()<time && values<maxCOunt){
                requestCount.put(requestInfo.getId(),requestCount.getOrDefault(requestInfo.getId(),0)+1);
                return true;
            }
            return false;
        }else{
            count.put(requestInfo.getId(),requestInfo.getStartTime());
            requestCount.put(requestInfo.getId(),1);
            return true;
        }
    }

    @Override
    public void run() {
        System.out.println(calculate(requestInfo));
    }
}
