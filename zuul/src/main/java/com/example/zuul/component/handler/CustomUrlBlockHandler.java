package com.example.zuul.component.handler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.zuul.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Sentinel 异常处理
 *
 * @Author daFa
 * @create 2019/1/21 18:28
 */
public class CustomUrlBlockHandler implements UrlBlockHandler {
    private final Logger logger = LoggerFactory.getLogger(CustomUrlBlockHandler.class);
    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) {
        logger.info("限流，禁止访问 {}", httpServletRequest.getRequestURI());
        new ExceptionUtil().handler(httpServletResponse, limitError("限流，禁止访问"));
    }

    /**
     * 认证错误
     *
     * @return
     */
    public static Map<String,Object> limitError(String clientMessage) {
        HashMap<String,Object> result = new HashMap<>();
        result.put("message",clientMessage);
        result.put("data",null);
        result.put("code",429);
        return result;

    }
}
