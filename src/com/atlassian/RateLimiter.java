package com.atlassian;

public interface RateLimiter {
    boolean calculate(RequestInfo requestInfo);
}
