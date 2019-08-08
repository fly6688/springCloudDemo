package com.fly.sczuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override
    /**
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    public String filterType() {
        return "pre";
    }

    @Override
    /**
     * 过滤的顺序
     */
    public int filterOrder() {
        return 0;
    }

    @Override
    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     */
    public boolean shouldFilter() {
        return true;
    }

    @Override
    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     */
    public Object run() throws ZuulException {
        RequestContext requestContent = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContent.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURI()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            log.warn("token is empty!!!");
            requestContent.setSendZuulResponse(false);
            requestContent.setResponseStatusCode(401);
            try {
                requestContent.getResponse().getWriter().write("token is empty!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        log.info("success");
        return null;
    }
}
