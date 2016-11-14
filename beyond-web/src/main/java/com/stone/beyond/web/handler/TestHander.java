package com.stone.beyond.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stone on 2016/11/13.
 */
@Controller
public class TestHander {
    Logger Log = LoggerFactory.getLogger(TestHander.class);

    @RequestMapping("/test")
    public void test(){
        Log.info("Logback Helloworld!");
    }
}
