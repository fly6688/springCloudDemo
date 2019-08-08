package com.fly.scapplication.service;

import com.fly.scapplication.service.impl.TestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @Author:         xuyunfei
* @CreateDate:     2019/8/5 0005 17:16
* @Description:    java类作用描述
*/
@FeignClient(value = "sc-pricing-provider",path="/sc-pricing", fallback = TestServiceImpl.class)
public interface TestService {

    /**
    * @Param
    * @Return
    * @Description:    响应
    */
    @RequestMapping(value = "/hi")
    String testProvider(@RequestParam(value = "clientName") String clientName );
}
