package com.traffic.transportservice.handler;

import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
* @Description:    统一异常处理
* @Author:         paopao
* @CreateDate:     2019/2/13 17:39
*/

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,String> exceptionHandler(HttpServletRequest request,Exception e){
        return ResultUtil.error(e.getMessage());
    }

}
