package com.ck.demo.config;

import com.ck.demo.pojo.User;
import com.ck.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro自定义realm
 */
public class userRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
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
       User user= userService.userService(token.getUsername());
        logger.info("执行认证操作");
        //判断定用户名
        if (null==user) {
            return null;
        }


        //判断密码
        return new SimpleAuthenticationInfo("",user.getPassword(),"");

    }
}
