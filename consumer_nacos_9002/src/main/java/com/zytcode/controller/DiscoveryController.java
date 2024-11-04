package com.zytcode.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping
    public void showDiscoveryInfo() {
        //获取在nacos注册中心的所有服务名称
        List<String> services = discoveryClient.getServices();
        services.forEach(serviceName -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
            instances.forEach(instance -> {
                System.out.println("serviceId:" + instance.getServiceId());
                System.out.println("serviceHost:" + instance.getHost());
                System.out.println("servicePort:" + instance.getPort());
                System.out.println("uri:" + instance.getUri());
            });
        });
        services.forEach(System.out::println);
    }
}
