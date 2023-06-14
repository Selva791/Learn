package com.problem;

public class UrlInfo {
    String url;
    String result;

    public UrlInfo(String url,String result) {
        this.url = url;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
