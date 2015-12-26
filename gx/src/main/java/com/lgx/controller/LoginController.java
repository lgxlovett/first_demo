package com.lgx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lgx.model.User;
import com.lgx.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    UserService userService;
    
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(User user) {
        JSONObject result = new JSONObject();
        return result;
    }

    
    @RequestMapping("/to_register")
    public String toRegister() {
       return "register/register";
    }
}
