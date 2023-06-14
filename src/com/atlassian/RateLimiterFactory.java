package com.atlassian;

import java.util.concurrent.TimeUnit;

public class RateLimiterFactory {
    public static ServiceRequestRateLimiter initialize(long timeUnit,int maxCount){
       return new ServiceRequestRateLimiter(timeUnit,maxCount);
    }
}
