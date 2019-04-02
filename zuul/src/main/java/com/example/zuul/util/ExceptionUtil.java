package com.example.zuul.util;


import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 异常封装
 *
 * @author daFa
 */
public class ExceptionUtil {
    String UTF8 = "UTF-8";
    String JSON_CONTENT_TYPE = "application/json; charset=utf-8";

    public void handler(HttpServletResponse response, Object result) {
        response.setCharacterEncoding(UTF8);
        response.setContentType(JSON_CONTENT_TYPE);
        PrintWriter printWriter;
        try {
            printWriter = response.getWriter();
            printWriter.append(JSONObject.toJSONString(result));
        } catch (Exception e) {
            throw new RuntimeException("异常处理失败");
        }

    }

}
