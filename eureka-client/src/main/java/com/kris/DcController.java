package com.kris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kris
 * @create 2017-11-21 17:02
 */
@RestController
public class DcController {

    @Autowired
    private DiscoveryClient mDiscoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        //测试服务的熔断降级
        //Thread.sleep(5000L);
        String services = "Services:" + mDiscoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
