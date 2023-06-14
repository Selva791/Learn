package com.problem;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RequestUrlRouterTest {

    @Before
    public void setup(){
        Map<String,String> urlCallBack =new HashMap<>();
        urlCallBack.put("www.atlassia.com","company");
        urlCallBack.put("www.example.com","sample");
        urlCallBack.put("www.test1.com","sample-1");
      //  RequestUrlRouterFactory.initialize(urlCallBack);
    }
    @Test
    public  void testUrlRouterSuccessful(){
        // https://www.atlassian.com/test
        RequestUrlRouter  requestUrlRouter = RequestUrlRouterFactory.initiaLizeRouter();
        requestUrlRouter.addUrlWithCallBack(new UrlInfo("example/val","sample"));
        requestUrlRouter.addUrlWithCallBack(new UrlInfo("example/val2/good","sample1"));
        requestUrlRouter.addUrlWithCallBack(new UrlInfo("example/val2/good","sample2"));
        requestUrlRouter.addUrlWithCallBack(new UrlInfo("test/*/good","sample3"));
        requestUrlRouter.addUrlWithCallBack(new UrlInfo("test/val3/val2/val/good","sample5"));
        requestUrlRouter.addUrlWithCallBack(new UrlInfo("test/val3/val2/val1/good","sample6"));
        System.out.println(requestUrlRouter.getResult("test/val3/good"));
        System.out.println(requestUrlRouter.getResult("test/*/*/val1/good"));
        System.out.println(requestUrlRouter.getResult("example/val2/good"));

    }
}
