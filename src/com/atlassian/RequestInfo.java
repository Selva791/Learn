package com.atlassian;

import java.time.LocalDateTime;

public class RequestInfo {
    private String Id;
    private LocalDateTime startTime;

    public RequestInfo(String id, LocalDateTime startTime) {
        this.Id = id;
        this.startTime = startTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

}
