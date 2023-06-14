package com.atlassian;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ServiceApplication {
    public static void main(String[] args) {
        RateLimiter serviceRequestRateLimiter
               = RateLimiterFactory.initialize(TimeUnit.SECONDS.toSeconds(5L),5);
        System.out.println(serviceRequestRateLimiter.calculate(new RequestInfo("1", LocalDateTime.now())));


    }
}
