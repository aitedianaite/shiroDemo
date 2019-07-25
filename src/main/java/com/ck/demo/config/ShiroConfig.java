package com.ck.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器
        /**
         * shiro内置过滤器可以实现权限相关的拦截
         *          常用的过滤器
         *              anon：无需认证（登陆）
         *              authc：必须认证才可以访问
         *              user：如果使用rememberMe的功能可以直接访问
         *              perms：必须得到资源权限才可以访问
         *              role：必须得到角色权限才可以访问
         *
         *
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/hello","authc");
//        filterMap.put("/add","authc");
//        filterMap.put("/update","authc");
          filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("tologin");


        return shiroFilterFactoryBean;
    }




    /*
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") userRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;

    }



    /**
     * 创建Realm
     */
    @Bean(name="userRealm")
    public userRealm getRealm(){
        return new userRealm();
    }
}
