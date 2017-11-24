package com.kris;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kris
 * @create 2017-11-23 11:40
 */
@Service
public class ConsumerService {

    @Autowired
    private DcClient mDcClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return mDcClient.consumer();
    }

    public String fallback() {
        return "fallback";
    }
}
