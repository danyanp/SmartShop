package com.danyanpi.controller;

import com.danyanpi.bean.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class HttpErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @ResponseBody
    @RequestMapping(path  = ERROR_PATH ,method= {RequestMethod.POST})
    public BaseResult error(HttpServletRequest request, HttpServletResponse response){
        log.info("访问/error" + "  错误代码："  + response.getStatus());
        return new BaseResult(BaseResult.RESULT_FAIL,"error:"+response.getStatus());
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}