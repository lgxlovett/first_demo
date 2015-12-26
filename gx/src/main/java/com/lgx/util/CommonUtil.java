package com.lgx.util;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lgx.common.BaseModel;
import com.lgx.common.Constants;
import com.lgx.model.User;

@Component
public class CommonUtil implements ApplicationContextAware {

    private static ApplicationContext context;// 声明一个静态变量保存

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * 获取当前用户信息
     * */
    public static User getCurrentUser() {
        try {
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest().getSession();
            User user = (User) session.getAttribute(Constants.USER);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取当前用户ID
     * */
    public static String getCurrentUserId() {
        try {
            return getCurrentUser().getId();
        } catch (Exception e) {
            return "1";
        }
    }
    
    /**
     * 对象新增初始化
     * */
    public static void newStandard(BaseModel entity){
        try {
            entity.setVoidFlag(Constants.Del_Status.NO);
            entity.setCreateUser(getCurrentUserId());
            entity.setCreateDate(new Date());
            entity.setUpdateUser(getCurrentUserId());
            entity.setUpdateDate(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 对象修改初始化
     * */
    public static void updateStandard(BaseModel entity){
        try {
            entity.setVoidFlag(Constants.Del_Status.NO);
            entity.setUpdateUser(getCurrentUserId());
            entity.setUpdateDate(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 对象删除初始化
     * */
    public static void deleteStandard(BaseModel entity){
        try {
            entity.setVoidFlag(Constants.Del_Status.YES);
            entity.setUpdateUser(getCurrentUserId());
            entity.setUpdateDate(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
