package com.fly.scpricing.service.impl;

import com.fly.scpricing.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Value("${server.port}")
    private String port;

    @Override
    public String testProvider(String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
