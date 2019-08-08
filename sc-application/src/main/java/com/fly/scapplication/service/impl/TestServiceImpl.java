package com.fly.scapplication.service.impl;

import com.fly.scapplication.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {

    @Value("${server.port}")
    private String port;

    @Override
    public String testProvider(String clientName) {
        return "Sorry "+ clientName + ",This port: " +  port;
    }
}
