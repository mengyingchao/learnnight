package com.ypp.springcloud.controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.ypp.springcloud.Util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
//路由之前
    @Override
    public String filterType() {
        return "route";//在路由请求时候被调用
    }
    @Override
    public int filterOrder() {

        return 0;//数字越大，优先级越低。
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s MyFilter request to %s", request.getMethod(), request.getRequestURL().toString()));
        String header = request.getParameter("header");
        System.out.println("header:"+header);
        //前台传过来的拼接字段
        String toStringUser=request.getParameter("toStringUser");
        boolean b=false;
        if(null!=header&&null!=toStringUser){
            System.out.println("toStringUser:"+toStringUser);
            b= MD5Util.validatePassword(header,toStringUser);
            System.out.println("toStringUser加密后:"+MD5Util.generatePassword(toStringUser));
        }
        if (b) {
            ctx.setSendZuulResponse(true); //对该请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        }else {
            ctx.setSendZuulResponse(false); //过滤改请求，不对其进行路由
            ctx.setResponseStatusCode(401);//返回错误码
            ctx.setResponseBody("{\"result\":\"header is not correct!\"}");//返回错误内容
            ctx.set("isSuccess", false);
            return null;
        }
}
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.get("isSuccess");// 如果前一个过滤器的结果为true，则说明上一个过滤器成功了，需要进入当前的过滤，如果前一个过滤器的结果为false，则说明上一个过滤器没有成功，则无需进行下面的过滤动作了，直接跳过后面的所有过滤器并返回结果
    }
}
