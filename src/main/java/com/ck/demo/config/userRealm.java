package com.ck.demo.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * shiro自定义realm
 */
public class userRealm extends AuthorizingRealm {
    private final Logger logger= LoggerFactory.getLogger(userRealm.class);
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String name="admin";
        String password="pass";
        logger.info("执行认证操作");
        //判定用户名
        if (!token.getUsername().equals(name)) {
            return null;
        }
        //判断密码
        return new SimpleAuthenticationInfo("",password,"");

    }
}
