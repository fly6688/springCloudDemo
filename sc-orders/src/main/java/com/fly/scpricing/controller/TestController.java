package com.fly.scpricing.controller;

import com.fly.scpricing.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sc-order")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hi")
    public String testHi(@RequestParam(name = "clientName",required = true) String clientName) {
        return testService.testProvider(clientName);
    }
}
