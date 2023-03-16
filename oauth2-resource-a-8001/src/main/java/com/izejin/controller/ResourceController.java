package com.izejin.controller;


import com.alibaba.fastjson2.JSON;
import com.izejin.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 土味儿
 * Date 2022/5/18
 * @version 1.0
 */
@RestController
public class ResourceController {
    @GetMapping("/res1")
    public String getRes1(HttpServletRequest req, HttpServletResponse resp){
        return JSON.toJSONString(new Result(200, "服务A -> 资源1"));
    }

    @GetMapping("/res2")
    public String getRes2(){
        return JSON.toJSONString(new Result(200, "服务A -> 资源2"));
    }
}

