package com.fly.scpricing.controller;

import com.fly.scpricing.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sc-pricing")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hi")
    public String testHi(@RequestParam(name = "clientName",required = true) String clientName) {
        return testService.testProvider(clientName);
    }

    @HystrixCommand(fallbackMethod = "hi")
    public String hi(String name) {
        return "hi " + name + " , server is down";
    }
}
