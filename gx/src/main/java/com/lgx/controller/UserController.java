package com.lgx.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lgx.model.User;
import com.lgx.service.UserService;
import com.lgx.util.CommonUtil;
import com.lgx.util.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 判断用户名是否存在
     * 
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/isExists", method = RequestMethod.POST)
    public JSONObject isExists(String name) {
        JSONObject result = new JSONObject();
        User user;
        user = userService.findUserByName(name);
        if (user == null) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        return result;
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/register",  method = RequestMethod.POST)
    public JSONObject register(@Valid User user, BindingResult bindingResult) {
        System.out.println("-------------"+bindingResult.hasErrors());
        CommonUtil.newStandard(user);
        user.setPassword(MD5Util.MD5(user.getPassword()));
        userService.addUser(user);
        JSONObject result = new JSONObject();
        result.put("success", true);
        return result;
    }
}
